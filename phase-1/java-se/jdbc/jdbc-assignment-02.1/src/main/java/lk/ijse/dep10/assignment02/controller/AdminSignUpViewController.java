package lk.ijse.dep10.assignment02.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lk.ijse.dep10.assignment02.db.DBConnection;
import lk.ijse.dep10.assignment02.util.DateAndTime;
import lk.ijse.dep10.assignment02.util.Role;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminSignUpViewController {

    public Label lblDateAndTime;
    public Label lblMain4;
    @FXML
    private Button btnCreateAdmin;

    @FXML
    private PasswordField pswPassword;

    @FXML
    private PasswordField pswRePassword;

    @FXML
    private TextField txtFullName;

    @FXML
    private TextField txtUserName;

    public void initialize() {
        dateAndTimeCounter();

    }

    private void dateAndTimeCounter() {

        DateAndTime.setDateAndTime(lblDateAndTime);


    }

    @FXML
    void btnCreateAdminOnAction(ActionEvent event) {


        if (!isDataValid()) {
            return;
        }


        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String fullName = txtFullName.getText();
            String userName = txtUserName.getText();
            String password = pswPassword.getText();
            Role role = Role.ADMIN;

//            User adminUser = new User(fullName, userName, password, role);

            String sql = "INSERT INTO Users VALUES ('%s','%s','%s','%s')";

            sql = String.format(sql, userName, fullName, password, role);
            statement.executeUpdate(sql);
            System.out.println("Admin saved to table");

            loadLoginScene();

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to create Admin").showAndWait();
            return;
        }

    }

    private void loadLoginScene() {
        Stage stage = (Stage) btnCreateAdmin.getScene().getWindow();
        try {
            stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/LoginView.fxml")).load()));
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load the login scene").showAndWait();
            return;
        }

    }

    private boolean isDataValid() {
        boolean dataValid = true;

        if (pswPassword.getText().isEmpty() || pswPassword.getText().isBlank() || !pswPassword.getText().equals(pswRePassword.getText())) {
            pswRePassword.clear();
            pswPassword.selectAll();
            pswPassword.requestFocus();
            dataValid = false;
        }
        if (txtUserName.getText().length() < 3 || txtUserName.getText().isBlank() || txtUserName.getText().isEmpty()) {
            dataValid = false;
            txtUserName.selectAll();
            txtUserName.requestFocus();
        }
        if (txtFullName.getText().isEmpty() || txtFullName.getText().isBlank()) {
            dataValid = false;
            txtFullName.selectAll();
            txtFullName.requestFocus();
        }


        return dataValid;


    }

    @FXML
    void pswPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void pswRePasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtFullNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

}
