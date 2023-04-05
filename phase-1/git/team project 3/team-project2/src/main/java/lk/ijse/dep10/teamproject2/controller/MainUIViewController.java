package lk.ijse.dep10.teamproject2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainUIViewController {

    @FXML
    private Button btnManageCustomer;

    @FXML
    private Button btnManageEmployee;

    @FXML
    private Button btnManageStudent;

    @FXML
    private Button btnManageTeachers;

    @FXML
    void btnManageCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnManageEmployeeOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) btnManageCustomer.getScene().getWindow();
        stage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/EmployeeView.fxml")).load()));

    }

    @FXML
    void btnManageStudentOnAction(ActionEvent event) {

    }

    @FXML
    void btnManageTeachersOnAction(ActionEvent event) {

    }

}
