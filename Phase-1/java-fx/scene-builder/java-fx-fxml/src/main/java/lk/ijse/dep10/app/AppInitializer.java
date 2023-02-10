package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/MainForm.fxml"));       //can convert xml to java
        AnchorPane root=fxmlLoader.load();

        Scene scene = new Scene(root);
        primaryStage.setTitle("First XML App");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
