package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lk.ijse.dep10.app.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainViewController {

    public void initialize() {
        Connection connection = DBConnection.getInstance().getConnection();
        System.out.println(connection);

    }

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ListView<String> lstContacts;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (!lstContacts.getItems().contains(txtContact.getText())) {
            lstContacts.getItems().add(txtContact.getText());
            txtContact.requestFocus();
            txtContact.clear();
            return;

        }
        new Alert(Alert.AlertType.ERROR, "Contact Already exists").showAndWait();
        txtContact.selectAll();
        txtContact.requestFocus();

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        if (lstContacts.getSelectionModel().getSelectedItem() == null) {
            return;
        }
        lstContacts.getItems().remove(lstContacts.getSelectionModel().getSelectedItem());
        lstContacts.getSelectionModel().clearSelection();
        txtContact.requestFocus();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Connection connection = DBConnection.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT *FROM test.Contact WHERE contact= ?");
            for (String item : lstContacts.getItems()) {
                preparedStatement.setString(1, item);
                if (preparedStatement.executeQuery().next()) {
                    new Alert(Alert.AlertType.ERROR, "Already exist contact").showAndWait();
                    return;
                }
            }



            PreparedStatement stmStudent = connection.prepareStatement("INSERT INTO test.Student(id, name, address) VALUES(?,?,?) ");
            stmStudent.setInt(1, Integer.parseInt(txtId.getText()));
            stmStudent.setString(2, txtName.getText());
            stmStudent.setString(3, txtAddress.getText());
            stmStudent.executeUpdate();

            PreparedStatement stmContact = connection.prepareStatement("INSERT INTO test.Contact(contact,student_id) VALUES (?,?)");

            for (String item : lstContacts.getItems()) {
                System.out.println(item);
                stmContact.setString(1, item);
                stmContact.setInt(2, Integer.parseInt(txtId.getText()));
                stmContact.executeUpdate();
            }




        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
