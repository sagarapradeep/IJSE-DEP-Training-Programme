package lk.ijse.dep10.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.event.AncestorEvent;
import java.io.IOException;
import java.net.URL;

public class MainViewController {

    public Button btnListViewExersice;
    @FXML
    private Button btnComboBox;

    @FXML
    private Button btnCommunication;

    @FXML
    private Button btnListView;

    @FXML
    private Button btnTableView;

    @FXML
    void btnComboBoxOnAction(ActionEvent event) {

    }

    @FXML
    void btnCommunicationOnAction(ActionEvent event) {

    }

    @FXML
    void btnListViewOnAction(ActionEvent event) throws IOException {
        URL fxmlFile = this.getClass().getResource("/view/ListViewScene.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();


        Scene scene = new Scene(root);


        Stage stage = new Stage();
        stage.setScene(scene);

        stage.setTitle("List View Demo");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListView.getScene().getWindow());
        stage.show();
        stage.centerOnScreen();
    }

    @FXML
    void btnTableViewOnAction(ActionEvent event) {

    }

    public void btnListViewExersiceOnAction(ActionEvent actionEvent) throws IOException {
        URL fxmlFile = this.getClass().getResource("/view/ListViewExersice.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);
        AnchorPane root = fxmlLoader.load();


        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        stage.setTitle("List View Exersice");
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListViewExersice.getScene().getWindow());

        stage.show();
        stage.centerOnScreen();

    }
}
