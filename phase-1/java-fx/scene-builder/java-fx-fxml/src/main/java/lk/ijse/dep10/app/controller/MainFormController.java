package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class MainFormController {

    @FXML
    private Button btnOk;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtname;

    @FXML
    void btnOkOnAction(ActionEvent event) {
        System.out.println("You clicked Ok");

    }

}
