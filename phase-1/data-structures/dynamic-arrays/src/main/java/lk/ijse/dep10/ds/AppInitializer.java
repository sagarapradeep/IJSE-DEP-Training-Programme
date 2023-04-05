package lk.ijse.dep10.ds;


import javafx.application.Application;
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
        URL fxmlFile = this.getClass().getResource("/view/MainForm.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(fxmlFile);

        AnchorPane anchorPane = fxmlLoader.load();

        Scene scene = new Scene(anchorPane);


        primaryStage.setTitle("Dynamic Arrays Demo");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }
}
