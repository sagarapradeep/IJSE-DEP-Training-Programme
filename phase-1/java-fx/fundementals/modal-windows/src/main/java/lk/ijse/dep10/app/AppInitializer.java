package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        URL fxmlFile = getClass().getResource("/view/MainForm.fxml");       //create pointer for fxml file(intrnal resource)
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);       //create fxmlloader instance
        AnchorPane root = fxmlLoader.load();        //execute load() method in FXMLLoader class(load file and assign root)
        /*load root element in fxml file to root*/


        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);

        primaryStage.setTitle("Modal Window");
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
}
