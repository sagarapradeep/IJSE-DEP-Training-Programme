import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {

        String[] firstWindowButtonSet = new String[]{"Anchor Pane", "Flow Pane", "Tile Pane", "Stack Pane", "Grid Pane"};
        gridPaneStage(firstWindowButtonSet);

    }

    public void gridPaneStage(String []fistWindowButtonSet) {
        Stage stage = new Stage();      //create new stage
        stage.setTitle("Interface 1");      //set title
        Button[] btnArray = buttonInitializer(fistWindowButtonSet);

        btnArray[0].setOnAction(event ->{
            printSomething();
        });

        GridPane gridPane = new GridPane();     //create grid pane container
        gridPane.add(btnArray[0], 0, 0);
        gridPane.add(btnArray[1], 0, 1);
        gridPane.add(btnArray[2], 0, 2);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20,100,50,100));

        Scene scene1 = new Scene(gridPane);

        stage.setScene(scene1);
        stage.sizeToScene();        //create stage size as scene size
        stage.setResizable(false);          //disable resizing option
        stage.show();                       //show stage
        stage.centerOnScreen();
    }

    public Button[] buttonInitializer(String[]firstWindowButton) {
        Button[] button = new Button[5];

        for (int i = 0; i < button.length; i++) {
            button[i] = new Button(firstWindowButton[i]);

        }
        return button;
    }

    public void printSomething() {
        System.out.println("Welcome to Anchor Pane");
    }
}
