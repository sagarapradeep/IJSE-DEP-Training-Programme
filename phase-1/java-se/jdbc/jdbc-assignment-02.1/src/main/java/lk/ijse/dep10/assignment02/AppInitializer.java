package lk.ijse.dep10.assignment02;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lk.ijse.dep10.assignment02.db.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT *FROM Users";
            ResultSet resultSet = statement.executeQuery(sql);
            boolean condition = resultSet.next();

            if (!condition) {
                primaryStage.setScene(new Scene
                        (new FXMLLoader(this.getClass().
                                getResource("/view/AdminSignUpView.fxml")).load()));

            } else {
                primaryStage.setScene(new Scene
                        (new FXMLLoader(this.getClass().
                                getResource("/view/LoginView.fxml")).load()));


            }
            primaryStage.show();
            primaryStage.centerOnScreen();



        } catch (SQLException | IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Error while loading data!").show();
        }

    }
}
