package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        var stage = new Stage();            //creat new stage
        AnchorPane anchorPane = new AnchorPane();       //creat new object from anchor pane basket(can hold many features)
        Button btnClickMe = new Button("Click me");        //creat a new button object
        var mainScene = new Scene(anchorPane);        //creat scene object


        anchorPane.getChildren().add(btnClickMe);           //add button to anchor pane basket
        btnClickMe.setLayoutX(50);          //set button location
        btnClickMe.setLayoutY(50);
        stage.setTitle("My first java FX app");     //set title for new stage
        stage.setScene(mainScene);          //set scene to first stage
        stage.setWidth(500);        //set stage size
        stage.setHeight(500);
        stage.show();           //set stage to show in display




//        var stage2 = new Stage();
//        stage2.setTitle("My secnd stage");
//        stage2.show();

    }
}
