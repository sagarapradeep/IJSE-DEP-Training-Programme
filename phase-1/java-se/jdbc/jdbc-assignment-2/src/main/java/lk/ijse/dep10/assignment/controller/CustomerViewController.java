package lk.ijse.dep10.assignment.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep10.assignment.db.DBConnection;
import lk.ijse.dep10.assignment.model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerViewController {

    public Button btnAdd;
    public Button btnDelete;
    public Button btnRemove;
    public Button btnSave;
    public ListView<String> lstContacts;
    public TableView<Customer> tblCustomers;
    public TextField txtAddress;
    public TextField txtId;
    public TextField txtName;
    public TextField txtSearch;
    public TextField txtContact;
    public Button btnNew;

    public void initialize(){
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        loadAllCustomers();
        txtContact.setOnAction(this::btnAddOnAction);

        btnRemove.setDisable(true);
        lstContacts.getSelectionModel().selectedItemProperty().addListener((ov, previous, current) -> {
            btnRemove.setDisable(current == null);
        });

        btnDelete.setDisable(true);
        tblCustomers.getSelectionModel().selectedItemProperty().addListener((ov, previous, current) -> {
            btnDelete.setDisable(current == null);
        });
    }

    private void loadAllCustomers() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            ResultSet rstCustomers = stm.executeQuery("SELECT * FROM Customer");
            PreparedStatement stm2 = connection
                    .prepareStatement("SELECT * FROM Contact WHERE customer_id = ?");

            while (rstCustomers.next()){
                int id = rstCustomers.getInt("id");
                String name = rstCustomers.getString("name");
                String address = rstCustomers.getString("address");

                ArrayList<String> contactList = new ArrayList<>();

                stm2.setInt(1, id);
                ResultSet rstContacts = stm2.executeQuery();

                while (rstContacts.next()){
                    String contact = rstContacts.getString("contact");
                    contactList.add(contact);
                }

                Customer customer = new Customer(id, name, address, contactList);
                tblCustomers.getItems().add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load customers").show();
        }
    }

    public void btnAddOnAction(ActionEvent event) {
        if (!txtContact.getText().matches("\\d{3}-\\d{7}") ||
            lstContacts.getItems().contains(txtContact.getText().strip())){
            txtContact.requestFocus();
            txtContact.selectAll();
            txtContact.getStyleClass().add("invalid");
        }else{
            txtContact.getStyleClass().remove("invalid");
            lstContacts.getItems().add(txtContact.getText().strip());
            txtContact.requestFocus();
            txtContact.clear();
        }
    }

    public void btnDeleteOnAction(ActionEvent event) {

    }

    public void btnRemoveOnAction(ActionEvent event) {
        lstContacts.getItems().remove(lstContacts.getSelectionModel().getSelectedItem());
    }

    public void btnSaveOnAction(ActionEvent event) {
        if (!isDataValid()) return;

        try {
            Connection connection = DBConnection.getInstance().getConnection();

            if (!lstContacts.getItems().isEmpty()) {
                PreparedStatement stm = connection.
                        prepareStatement("SELECT * FROM Contact WHERE contact = ?");
                for (String contact : lstContacts.getItems()) {
                    stm.setString(1, contact);
                    if (stm.executeQuery().next()){
                        new Alert(Alert.AlertType.ERROR, contact + " already exists").show();
                        lstContacts.getStyleClass().add("invalid");
                        return;
                    }
                }
            }

            connection.setAutoCommit(false);        // Starting a new transaction context

            PreparedStatement stmCustomer = connection
                    .prepareStatement("INSERT INTO Customer (id, name, address) VALUES (?, ?, ?)");
            stmCustomer.setInt(1, Integer.parseInt(txtId.getText()));
            stmCustomer.setString(2, txtName.getText());
            stmCustomer.setString(3, txtAddress.getText());
            stmCustomer.executeUpdate();

            if (!lstContacts.getItems().isEmpty()){
                PreparedStatement stmContact = connection
                        .prepareStatement("INSERT INTO Contact (contact, customer_id) VALUES (?, ?)");
                int x= 0;
                for (String contact : lstContacts.getItems()) {
                    stmContact.setString(1, contact);
                    stmContact.setInt(2, Integer.parseInt(txtId.getText()));
                    stmContact.executeUpdate();
                }
            }

            connection.commit();

            Customer customer = new Customer(Integer.parseInt(txtId.getText()),
                    txtName.getText(),
                    txtAddress.getText(),
                    new ArrayList<>(lstContacts.getItems()));
            tblCustomers.getItems().add(customer);
            btnNew.fire();
        } catch (Throwable e) {
            try {
                DBConnection.getInstance().getConnection().rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to save the customer, try again!").show();
        }finally {
            try {
                DBConnection.getInstance().getConnection().setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private boolean isDataValid(){
        boolean dataValid = true;
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");
        lstContacts.getStyleClass().remove("invalid");

        String name = txtName.getText();
        String address = txtAddress.getText();

        if (address.strip().length() < 3){
            txtAddress.requestFocus();
            txtAddress.selectAll();
            txtAddress.getStyleClass().add("invalid");
            dataValid = false;
        }

        if (!name.matches("[A-Za-z ]+")){
            txtName.requestFocus();
            txtName.selectAll();
            txtName.getStyleClass().add("invalid");
            dataValid = false;
        }

        return dataValid;
    }

    public void lstContactsKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnRemove.fire();
    }

    public void tblCustomersOnKeyReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.DELETE) btnDelete.fire();
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        ObservableList<Customer> customerList = tblCustomers.getItems();
        var newId = customerList.isEmpty()? "1":
                customerList.get(customerList.size() - 1).getId() + 1;
        txtId.setText(newId + "");
        txtName.clear();
        txtAddress.clear();
        txtContact.clear();
        lstContacts.getItems().clear();
        lstContacts.getSelectionModel().clearSelection();
        tblCustomers.getSelectionModel().clearSelection();
        txtName.requestFocus();
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");
        lstContacts.getStyleClass().remove("invalid");
    }
}
