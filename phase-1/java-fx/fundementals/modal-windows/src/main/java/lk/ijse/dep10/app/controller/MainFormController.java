package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainFormController {

    public Button btnModalWindow2;
    public Button btnModalWindow1;
    public Button btnOpenDialog;
    public Button btnSaveDialog;
    public Button btnCreateUSer;
    @FXML
    private Button btnNormalWindow;

    @FXML
    void
    btnNormalWindowOnAction(ActionEvent event) throws IOException {
        URL fxmlFile = getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();


        Scene scene=new Scene(root);
        Stage window = new Stage();

        window.setScene(scene);

        window.sizeToScene();
        window.setTitle("Top Level Window");      //top level window(do not depend on previos window)
        window.show();
        window.centerOnScreen();
    }

    public void btnModalWindow1OnAction(ActionEvent actionEvent) throws IOException {
        URL fxmlFile = getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();


        Scene scene=new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.initModality(Modality.APPLICATION_MODAL);        //set modality
        window.sizeToScene();
        window.setTitle("Modal Window 1");      //top level window(do not depend on previos window)
        window.show();
        window.centerOnScreen();


    }

    public void btnModalWindow2OnAction(ActionEvent actionEvent) throws IOException {
        URL fxmlFile = getClass().getResource("/view/EmptyForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();


        Scene scene=new Scene(root);
        Stage window = new Stage();
        window.setScene(scene);
        window.initModality(Modality.WINDOW_MODAL);        //set modality
        window.initOwner(btnNormalWindow.getScene().getWindow());       //initilaize owner for window modal modal windows

        window.sizeToScene();
        window.setTitle("Modal Window 2");      //top level window(do not depend on previos window)
        window.show();
        window.centerOnScreen();
    }

    public void btnOpenDialogOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open a File Chooser");
//        fileChooser.showOpenDialog(null);     //top level window
        fileChooser.showOpenDialog(btnOpenDialog.getScene().getWindow());       //modal window
    }


    public void btnCreateUserOnAction(ActionEvent actionEvent) {


    }

    public void btnSaveDialogOnAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export a file");
//        fileChooser.showOpenDialog(null);     //top level window
        fileChooser.showOpenDialog(btnOpenDialog.getScene().getWindow());       //modal window
    }
}
