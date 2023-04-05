package lk.ijse.dep10.clienta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Client A");
        primaryStage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/ClientView.fxml")).load()));
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
}
