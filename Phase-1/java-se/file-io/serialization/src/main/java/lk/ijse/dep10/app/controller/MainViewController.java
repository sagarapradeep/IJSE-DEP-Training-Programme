package lk.ijse.dep10.app.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MainViewController {

    public Button btnSerializationWithInheritance;
    public Button btnSerializationWithInheritance2;
    public Button btnTransient;
    @FXML
    private Button btnHelloSerialization;

    @FXML
    private Button btnManageStudents;

    Stage stgHello;
    Stage stgManageStudent;
    Stage stgInheritance;
    Stage stgInheritance2;

    Stage stgTransient;

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

    public void btnSerializationWithInheritanceOnAction(ActionEvent actionEvent) throws IOException {
        if(stgInheritance!=null)return;

        stgInheritance=new Stage();
        stgInheritance.setScene(new Scene(new FXMLLoader(this.getClass().getResource
                ("/view/InheritanceView.fxml")).load()));

        stgInheritance.setTitle("Inheritance");

        stgInheritance.show();
        stgInheritance.centerOnScreen();



    }

    public void btnSerializationWithInheritance2OnAction(ActionEvent actionEvent) throws IOException {
        if(stgInheritance2!=null)return;

        stgInheritance2=new Stage();
        stgInheritance2.setScene(new Scene(new FXMLLoader(this.getClass().getResource
                ("/view/InheritanceView2.fxml")).load()));

        stgInheritance2.setTitle("Inheritance");

        stgInheritance2.show();
        stgInheritance2.centerOnScreen();
    }

    public void btnTransientOnAction(ActionEvent actionEvent) throws IOException {
        if(stgTransient!=null)return;

        stgTransient=new Stage();
        stgTransient.setScene(new Scene(new FXMLLoader(this.getClass().getResource
                ("/view/TransientView.fxml")).load()));

        stgTransient.setTitle("Transient");

        stgTransient.show();
        stgTransient.setMaximized(true);
        stgTransient.centerOnScreen();
        stgTransient.setOnCloseRequest(e->stgTransient = null);
    }
}
