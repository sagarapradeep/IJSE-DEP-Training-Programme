package lk.ijse.dep10.assignment.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.assignment.db.DBConnection;
import lk.ijse.dep10.assignment.model.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerViewController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewCustomer;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ListView<String> lstContact;

    @FXML
    private TableView<Customer> tblCustomers;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtSearch;

    public void initialize(){
        Platform.runLater(()->{
            txtId.setDisable(true);
            btnNewCustomer.fire();
        });

        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        loadAllCustomer();

        btnRemove.setDisable(true);
        lstContact.getSelectionModel().selectedItemProperty().addListener((value,pv,current)->{
            btnRemove.setDisable(current == null);
        });

        btnDelete.setDisable(true);
        tblCustomers.getSelectionModel().selectedItemProperty().addListener((value,pv,current)->{
            btnDelete.setDisable(current == null);
        });

    }
    private void loadAllCustomer(){
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement stm1 = connection.createStatement();
            String sql = "SELECT *FROM Customer";
            ResultSet rstCustomer = stm1.executeQuery(sql);

            PreparedStatement stm2 = connection.prepareStatement("SELECT *FROM Contact WHERE customer_id=?");

            while (rstCustomer.next()) {
                int id = rstCustomer.getInt("id");
                String name = rstCustomer.getString("name");
                String address = rstCustomer.getString("address");
                ArrayList<String> contactList = new ArrayList<>();
                stm2.setInt(1, id);
                ResultSet rstcontatcts = stm2.executeQuery();

                while (rstcontatcts.next()) {
                    String contact = rstcontatcts.getString("contact");
                    contactList.add(contact);
                }
                Customer customer = new Customer(id, name, address, contactList);
                tblCustomers.getItems().add(customer);

            }

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load the customers");
        }


    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (!isContactValid()) {
            System.out.println("Invalid");
            txtContact.getStyleClass().add("invalid");
            txtContact.requestFocus();
            txtContact.selectAll();
            return;
        }
        txtContact.getStyleClass().remove("invalid");
        lstContact.getItems().add(txtContact.getText());
        txtContact.requestFocus();
        txtContact.clear();
    }

    private boolean isContactValid() {
        return txtContact.getText().matches("\\d{3}-\\d{7}");

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) {
        ObservableList<Customer> customersList = tblCustomers.getItems();


        var newId = customersList.isEmpty() ? "1" : ((customersList.get(customersList.size() - 1).getId()) + 1);
        txtId.setText(newId.toString());
        txtCustomerName.clear();
        txtAddress.clear();
        txtContact.clear();
        lstContact.getItems().clear();
        tblCustomers.getSelectionModel().clearSelection();
        txtCustomerName.requestFocus();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        lstContact.getItems().remove(lstContact.getSelectionModel().getSelectedItem());
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (!isDataValid()) {
            return;
        }
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            if (!lstContact.getItems().isEmpty()) {
                PreparedStatement stm = connection.prepareStatement("SELECT *FROM Contact WHERE contact=?");

                for (String item : lstContact.getItems()) {
                    stm.setString(1, item);
                    ResultSet resultSet = stm.executeQuery();
                    if (resultSet.next()) {
                        new Alert(Alert.AlertType.ERROR, "Contact Number already exists").showAndWait();
                        lstContact.getStyleClass().add("invalid");
                        return;
                    }
                }

            }

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer(id, name, address) VALUES (?,?,?)");
            preparedStatement.setInt(1, Integer.parseInt(txtId.getText()));
            preparedStatement.setString(2, txtCustomerName.getText());
            preparedStatement.setString(1, txtAddress.getText());

            if (!lstContact.getItems().isEmpty()) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("INSERT INTO Contact(contact, customer_id) VALUES (?,?)");
                for (String item : lstContact.getItems()) {
                    preparedStatement1.setString(1, item);
                    preparedStatement1.setInt(2, Integer.parseInt(txtId.getText()));
                    preparedStatement1.executeQuery();
                }


            }

            new Customer(Integer.parseInt(txtId.getText()), txtCustomerName.getText(), txtAddress.getText(), lstContact.getItems());


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private boolean isDataValid() {
        boolean dataValid = true;
        String name = txtCustomerName.getText();
        String address = txtAddress.getText();


//        if (lstContact.getItems().isEmpty()) {
//            txtContact.requestFocus();
//            dataValid = false;
//            txtContact.getStyleClass().add("invalid");
//        }
        if (address.strip().length() < 5) {
            txtAddress.selectAll();
            txtAddress.requestFocus();
            txtAddress.getStyleClass().add("invalid");
            dataValid = false;
        }

        if (!name.matches("[A-Za-z]{3,}")) {
            dataValid = false;
            txtCustomerName.requestFocus();
            txtCustomerName.getStyleClass().add("invalid");
            txtCustomerName.selectAll();
        }




        return dataValid;
    }

}
