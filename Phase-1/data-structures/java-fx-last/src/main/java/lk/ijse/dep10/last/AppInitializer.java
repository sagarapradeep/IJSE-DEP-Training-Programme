package lk.ijse.dep10.last;

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
        URL fxmlFile=this.getClass().getResource("/view/MainView.fxml");
        FXMLLoader fxmlLoader=new FXMLLoader(fxmlFile);
        AnchorPane root=fxmlLoader.load();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.centerOnScreen();

    }
}
