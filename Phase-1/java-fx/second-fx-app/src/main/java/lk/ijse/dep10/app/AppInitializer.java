package lk.ijse.dep10.app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

//        Button btn1 = new Button("Button 1");       //buttons
//        Button btn2 = new Button("Button 2");
//        Button btn3 = new Button("Button 3");
//        Button btn4 = new Button("Button 4");
//        Button btn5 = new Button("Button 5");
//
////        btn5.setLayoutY(250);           //place button in relevant area
////        btn5.setLayoutX(250);
//
//        TextField txt1 = new TextField();               //text fields
//        TextField txt2 = new TextField();
//        TextField txt3 = new TextField();
//        TextField txt4 = new TextField();
//
////        AnchorPane anchorPane = new AnchorPane(btn1,btn2,btn3,btn4,btn5);
//        BorderPane borderPane = new BorderPane();
//
////        anchorPane.getChildren().add(btn1);
//        borderPane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5,txt1,txt2,txt3,txt4);
//
//        borderPane.setTop(btn1);
//        borderPane.setBottom(btn2);
//        borderPane.setLeft(btn3);
//        borderPane.setRight(btn4);
//        borderPane.setCenter(txt1);
//
//        BorderPane.setAlignment(btn1, Pos.CENTER);
//        BorderPane.setAlignment(btn2, Pos.CENTER);
//        BorderPane.setAlignment(btn3, Pos.CENTER);
//        BorderPane.setAlignment(btn4, Pos.CENTER);
//        BorderPane.setAlignment(txt1, Pos.CENTER);
//
//
//        Scene mainScene = new Scene(borderPane);
//        primaryStage.setScene(mainScene);
//
//        primaryStage.setTitle("My second fx app");
//        primaryStage.setWidth(500);
//        primaryStage.setHeight(500);
//
//        primaryStage.show();
//        primaryStage.centerOnScreen();

//        hBoxDemo();
//        vBoxDemo();
        gridPaneDemo();

    }

    private void hBoxDemo() {
        Stage stage = new Stage();

        Button[] buttons = new Button[5];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + i);
        }

        HBox hBox = new HBox(buttons);
        Scene scene = new Scene(hBox);

        stage.sizeToScene();        //set stage size according to scene
        stage.setTitle("H Box Demo");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
    }

    private void vBoxDemo() {
        Stage stage = new Stage();

        Button[] buttons = new Button[4];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button("Button " + (i + 1));
        }

        VBox vBox = new VBox(10,buttons);
        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.sizeToScene();
        stage.setTitle("V Box Demo");
        stage.show();
        stage.centerOnScreen();
    }

    private void gridPaneDemo() {
        Stage stage = new Stage();

        Label lblTitle = new Label("Costumer Details");
        Label lblId = new Label("ID");
        Label lblName = new Label("name");
        Label lblAddress = new Label("Address");

        Button btnSave = new Button("Save");

        TextField txtId = new TextField("456");
        TextField txtName = new TextField();
        TextField txtAddress = new TextField();

        GridPane container = new GridPane();

        container.add(lblTitle,0,0,2,1);
        container.add(lblId,0,1);
        container.add(lblName,0,2);
        container.add(lblAddress,0,3);

        container.add(txtId,1,1);
        container.add(txtName,1,2);
        container.add(txtAddress,1,3);

        Scene scene = new Scene(container);

        stage.setScene(scene);
        stage.sizeToScene();


        stage.setTitle("Grid Pane Demo");
        stage.show();
        stage.centerOnScreen();
    }

}
