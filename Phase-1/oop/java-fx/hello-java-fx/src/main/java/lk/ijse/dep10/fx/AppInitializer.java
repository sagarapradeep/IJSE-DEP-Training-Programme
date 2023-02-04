package lk.ijse.dep10.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        System.out.println("Just before the launching JAVAFX runtime environment");     /*run main method*/
        launch(args);                                   /*Call java fx runtime environment, and call start method*/
        System.out.println("Just after the Java FX runtime environment destroyed");

    }       

    @Override
    public void start(Stage primaryStage) {
        System.out.println("FX entry point");       /*Start method runs*/
        Platform.exit();        /*Exit from Java fx runtime environment*/
    }
}
