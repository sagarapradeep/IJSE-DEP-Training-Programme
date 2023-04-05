package lk.ijse.dep10;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("Just before javaFXRE run");
        launch(args);
        System.out.println("Just after javaFXRE destroyed");

    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("start method called");
        Platform.exit();

    }
}
