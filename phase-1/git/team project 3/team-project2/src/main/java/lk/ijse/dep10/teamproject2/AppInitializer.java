package lk.ijse.dep10.teamproject2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.dep10.teamproject2.db.DBConnection;

import java.io.IOException;
import java.sql.Connection;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {



        primaryStage.setScene(new Scene(new FXMLLoader(this.getClass().getResource("/view/MainUIView.fxml")).load()));

        primaryStage.setTitle("Main UI");
        primaryStage.show();


    }
}
