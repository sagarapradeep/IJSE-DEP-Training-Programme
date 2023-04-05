package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppInitializer extends Application {

    public Stage mainCanvasStage;
    public Stage controlPanelStage;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        mainPanelWindow();      //call main window


    }

    public void mainPanelWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/MainCanvas.fxml"));
        AnchorPane root = fxmlLoader.load();

        mainCanvasStage = new Stage();
        mainCanvasStage.setTitle("Main Canvas Panel");

        Scene scene = new Scene(root);
        mainCanvasStage.setScene(scene);
        mainCanvasStage.show();
        mainCanvasStage.centerOnScreen();

    }

}
