package lk.ijse.dep10.assignment02.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.ijse.dep10.assignment02.db.DBConnection;
import lk.ijse.dep10.assignment02.util.DateAndTime;
import lk.ijse.dep10.assignment02.util.Role;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginViewController {

    public Label lblDateAndTime;
    public Label lblMain2;
    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField pswPassword;

    @FXML
    private TextField txtUserName;


    public void initialize() {
        dateAndTimeCounter();
        txtUserName.textProperty().addListener((ov,previous,current)->{

            txtUserName.getStyleClass().remove("invalid");
            pswPassword.getStyleClass().remove("invalid");

        });

    }
    private void dateAndTimeCounter() {
        new Thread(()->{
            DateAndTime.setDateAndTime(lblDateAndTime);

        }).start();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if(!isLoginValid())return;

        try {
            String userName = txtUserName.getText();
            String password = pswPassword.getText();

            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM Users");

            while (resultSet.next()) {
                String dbUserName = resultSet.getString(1);
                String dbPassword = resultSet.getString(3);


                if (dbUserName.equals(userName) && dbPassword.equals(password)) {
                    Stage stage = (Stage) btnLogin.getScene().getWindow();
                    if (resultSet.getString(4).equals("ADMIN")) {
                        FXMLLoader fxmlLoader=new FXMLLoader
                                (this.getClass().getResource("/view/AdminView.fxml"));
                        stage.setScene(new Scene(fxmlLoader.load()));
                        AdminViewController ctr = fxmlLoader.getController();
                        ctr.initData(dbUserName);
                    }
                    else {
                        FXMLLoader fxmlLoader=new FXMLLoader(this.getClass().getResource("/view/UserView.fxml"));
                        stage.setScene(new Scene(fxmlLoader.load()));
                        UserViewController ctrl = fxmlLoader.getController();
                        ctrl.init(dbUserName);

                    }

                    break;

                }

                txtUserName.selectAll();
                pswPassword.clear();
                txtUserName.getStyleClass().add("invalid");
                pswPassword.getStyleClass().add("invalid");
                txtUserName.requestFocus();
            }



        } catch (SQLException | IOException e) {
            e.printStackTrace();
            System.out.println("failed to load connection for login!");
        }

    }

    private boolean isLoginValid() {
        boolean loginValid = true;
        if (pswPassword.getText().isBlank() || pswPassword.getText().isEmpty()) {
            pswPassword.requestFocus();
            loginValid = false;
        }
        if (txtUserName.getText().isEmpty() || txtUserName.getText().isBlank()) {
            txtUserName.requestFocus();
            loginValid = false;
        }
        return loginValid;

    }

    @FXML
    void pswPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

}
