package lk.ijse.dep10.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainViewController {

    public Button btncomboBox;
    public Button btnTableView;
    @FXML
    private Button btnListView;

    @FXML
    void btnComboBox(MouseEvent event) {

    }

    @FXML
    void btnListViewOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();
        URL fxmlFile=getClass().getResource("/view/ListViewScene.fxml");
        FXMLLoader fxmlLoader=new FXMLLoader(fxmlFile);
        AnchorPane root=fxmlLoader.load();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(btnListView.getScene().getWindow());
        stage.show();
        stage.centerOnScreen();

    }

    public void btncomboBoxOnAction(ActionEvent event) {
    }

    public void btnTableViewOnAction(ActionEvent event) {
    }

    public void btnListViewExerciseOnAction(ActionEvent event) throws IOException {
        Stage stage=new Stage();

        URL fxmlFile=this.getClass().getResource("/view/ListViewExercise.fxml");
        FXMLLoader fxmlLoader=new FXMLLoader(fxmlFile);
        AnchorPane root=fxmlLoader.load();
        Scene scene=new Scene(root);
        stage.setScene(scene);

        stage.setTitle("List view exercise");
        stage.initOwner(btnListView.getScene().getWindow());
        stage.initModality(Modality.WINDOW_MODAL);
        stage.centerOnScreen();
        stage.setMaximized(true);
        stage.show();
    }
}
