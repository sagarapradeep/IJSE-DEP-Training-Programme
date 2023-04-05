package lk.ijse.dep10.assignment02.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lk.ijse.dep10.assignment02.util.DateAndTime;

import java.io.IOException;

public class UserViewController {

    public Label lblLoggedUser;
    public Label lblDateAndTime;
    public Label lblMain1;
    @FXML
    private Button btnLogout;

    @FXML
    private Button btnManageCostumer;

    @FXML
    private Button btnManageItem;

    public void initialize() {
        dateAndTimeCounter();

    }
    private void dateAndTimeCounter() {
        new Thread(()->{
            DateAndTime.setDateAndTime(lblDateAndTime);

        }).start();
    }

    public void init(String userName) {
        lblLoggedUser.setText(userName);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        Stage stage = (Stage) btnLogout.getScene().getWindow();

        try {
            stage.setScene(new Scene(new FXMLLoader
                    (this.getClass().getResource("/view/LoginView.fxml")).load()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnManageCostumerOnAction(ActionEvent event) {

    }

    @FXML
    void btnManageItemOnAction(ActionEvent event) {

    }

}
