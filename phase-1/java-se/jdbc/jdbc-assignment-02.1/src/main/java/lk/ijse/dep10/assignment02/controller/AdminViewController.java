package lk.ijse.dep10.assignment02.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import lk.ijse.dep10.assignment02.util.DateAndTime;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminViewController {

    public Button btnLogOut;
    public Label lblLoggedUser;
    public Label lblDateAndTime;
    public Label lblMain3;
    @FXML
    private Button btnManageCostumer;

    @FXML
    private Button btnManageItem;

    @FXML
    private Button btnManageUsers;

    public String loggedUser;

    public void initialize() {
        dateAndTimeCounter();

    }

    private void dateAndTimeCounter() {
        new Thread(()->{
            DateAndTime.setDateAndTime(lblDateAndTime);

        }).start();
    }




    public void initData(String userName) {
        this.loggedUser = userName;
        lblLoggedUser.setText(userName);

    }

    @FXML
    void btnManageCostumerOnAction(ActionEvent event) {

    }

    @FXML
    void btnManageItemOnAction(ActionEvent event) {

    }

    @FXML
    void btnManageUsersOnAction(ActionEvent event) {
        Stage stage = (Stage) btnManageUsers.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(this.getClass().getResource("/view/AdminUserManipulationView.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            AdminUserManipulationViewController ctrl = fxmlLoader.getController();
            ctrl.initData(loggedUser);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();

        try {
            stage.setScene(new Scene(new FXMLLoader
                    (this.getClass().getResource("/view/LoginView.fxml")).load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
