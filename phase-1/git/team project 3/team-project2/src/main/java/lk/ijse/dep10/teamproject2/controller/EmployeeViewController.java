package lk.ijse.dep10.teamproject2.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep10.teamproject2.db.DBConnection;
import lk.ijse.dep10.teamproject2.util.Employee;

import java.sql.*;
import java.util.Optional;

public class EmployeeViewController {

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNewEmployee;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Employee> tblEmployee;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    public void initialize() {
        tblEmployee.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmployee.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmployee.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        loadData();

        Platform.runLater(btnNewEmployee::fire);

        tblEmployee.getSelectionModel().selectedItemProperty().addListener((pv, value,current)->{
            if (current == null) {
                btnDelete.setDisable(true);
                return;
            }
            btnDelete.setDisable(false);

            txtId.setText(current.getId());
            txtName.setText(current.getName());
            txtAddress.setText(current.getAddress());

        });


    }


    private void loadData() {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            Statement stmStudent = connection.createStatement();
            ResultSet rst1 = stmStudent.executeQuery("SELECT *FROM Employee");


            while (rst1.next()) {
                String id = rst1.getString(1);
                String name = rst1.getString(2);
                String address = rst1.getString(3);


                Employee student = new Employee(id, name, address);
                tblEmployee.getItems().add(student);

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private String generateNewId() {
        ObservableList<Employee> employeeList = tblEmployee.getItems();
        if (employeeList.isEmpty()) {
            return "C-001";
        }
        String lastId = employeeList.get(employeeList.size() - 1).getId();
        lastId = lastId.substring(2);
        System.out.println(lastId);
        int newId = Integer.parseInt(lastId);
        String newID2 = String.format("C-%03d", (newId + 1));
        return newID2;
    }


    @FXML
    void btnNewEmployeeOnAction(ActionEvent event) {
        txtName.clear();
        txtAddress.clear();
        tblEmployee.getSelectionModel().clearSelection();
        txtName.requestFocus();
        txtId.setText(generateNewId());


    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if (!isDataValid()) {
            return;
        }

        Connection connection = DBConnection.getInstance().getConnection();

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();


        try {
            connection.setAutoCommit(false);


            /*save changes*/
            if (!(tblEmployee.getSelectionModel().getSelectedItem() == null)) {

                Employee selectedEmployee = tblEmployee.getSelectionModel().getSelectedItem();


                PreparedStatement stmModifyStudent = connection.prepareStatement("UPDATE Employee SET name=?, address=? WHERE id=?");
                stmModifyStudent.setString(1, name);
                stmModifyStudent.setString(2, address);
                stmModifyStudent.setString(3, id);
                stmModifyStudent.executeUpdate();


                selectedEmployee.setName(txtName.getText());
                selectedEmployee.setAddress(txtAddress.getText());

                tblEmployee.refresh();
                btnNewEmployee.fire();
                connection.commit();

                new Alert(Alert.AlertType.INFORMATION, "Modified entity successfully saved to database!").show();


                return;

            }


            /*save new student*/

            PreparedStatement stmStudent = connection.prepareStatement("INSERT INTO Employee(id,name, address) VALUES (?,?,?)");
            stmStudent.setString(1, id);
            stmStudent.setString(2, name);
            stmStudent.setString(3, address);
            stmStudent.executeUpdate();


            Employee newEmployee = new Employee(id, name, address);


            tblEmployee.getItems().add(newEmployee);
            connection.commit();

            btnNewEmployee.fire();


        } catch (Throwable throwable) {
            try {
                throwable.printStackTrace();
                connection.rollback();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
        new Alert(Alert.AlertType.INFORMATION, "New entity successfully saved!").show();


    }

    private boolean isDataValid() {

        boolean dataValid = true;
        String name = txtName.getText();
        String address = txtAddress.getText();

        if (!name.matches("[A-Za-z]{3,}( [A-Za-z]{3,})?")) {
            dataValid = false;
            txtName.requestFocus();
            txtName.selectAll();
            new Alert(Alert.AlertType.ERROR, "Invalid name!").show();
        }
        if (!address.matches("[A-Za-z]{3,}")) {
            dataValid = false;
            txtAddress.requestFocus();
            txtAddress.selectAll();
            new Alert(Alert.AlertType.ERROR, "Invalid address!").show();
        }


        return dataValid;

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        Connection connection = DBConnection.getInstance().getConnection();
        Employee selectedEmployee = tblEmployee.getSelectionModel().getSelectedItem();
        if (selectedEmployee == null) {
            return;
        }

        String id = selectedEmployee.getId();

        Optional<ButtonType> optional = new Alert(Alert.AlertType.CONFIRMATION, "Are sure to delete selected entity", ButtonType.YES, ButtonType.NO).showAndWait();

        if ((optional.get() == ButtonType.NO) || optional.get() == null) {
            return;

        }

        try {


            PreparedStatement stmStudent = connection.prepareStatement("DELETE FROM Employee WHERE id=?");
            stmStudent.setString(1, id);
            stmStudent.executeUpdate();

            tblEmployee.getItems().remove(selectedEmployee);
            tblEmployee.refresh();

            if (tblEmployee.getItems().isEmpty()) {
                btnNewEmployee.fire();
            }


        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to connect database try again!").showAndWait();

        }
    }
}
