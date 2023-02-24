package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    @FXML
    private Button btnHelloSerialization;

    @FXML
    private Button btnManageStudents;

    Stage stgHello;
    Stage stgManageStudent;

    @FXML
    void btnHelloSerializationOnAction(ActionEvent event) throws IOException {
        stgHello = new Stage();
        stgHello.setScene(new Scene(new FXMLLoader(this.getClass().
                getResource("/view/HelloView.fxml")).load()));

        stgHello.setTitle("Hello Serialization");
        stgHello.sizeToScene();
        stgHello.show();
        stgHello.centerOnScreen();

        stgHello.setOnCloseRequest(e->stgHello=null);


    }

    @FXML
    void btnManageStudentsOnAction(ActionEvent event) throws IOException {
        stgManageStudent = new Stage();
        stgManageStudent.setScene(new Scene(new FXMLLoader(this.getClass().
                getResource("/view/StudentView.fxml")).load()));

        stgManageStudent.setTitle("Manage Students");
        stgManageStudent.sizeToScene();
        stgManageStudent.show();
        stgManageStudent.centerOnScreen();
        stgManageStudent.setOnCloseRequest(e->stgManageStudent=null);

    }

}
