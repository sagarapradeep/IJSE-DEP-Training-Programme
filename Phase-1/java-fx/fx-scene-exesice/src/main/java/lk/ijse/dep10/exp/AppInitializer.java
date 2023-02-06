package lk.ijse.dep10.exp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Scanner;


public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginScene(primaryStage);


    }

    private void loginScene(Stage stage) {


        stage.setTitle("Login");
        Label loginLabel = new Label("LOG IN");
        loginLabel.setPadding(new Insets(5,10,25,10));
        loginLabel.setFont(new Font("Ubuntu", 40));
        loginLabel.setTextFill(Color.NAVY);

        Label enterpsdLabel = new Label("Enter Password");
        enterpsdLabel.setFont(new Font("Ubuntu", 20));

        Label lblHint = new Label("Invalid Password");
        lblHint.setFont(new Font("Ubuntu", 20));
        lblHint.setTextFill(Color.RED);
        lblHint.setVisible(false);

        PasswordField txtPassword=new PasswordField();
        txtPassword.setAlignment(Pos.CENTER);
        txtPassword.setMaxWidth(300);

        Button loginbtn = new Button("Login");
        loginbtn.setDefaultButton(true);
        loginbtn.setFont(new Font("Ubuntu", 20));

        loginbtn.setOnAction(event ->{
            String pasword =txtPassword.getText();
            if (!(pasword.equals("Admin"))) {
                lblHint.setVisible(true);
                txtPassword.selectAll();
            }
            else {
                mainScene(stage);
            }
        });

        VBox vBox=new VBox(loginLabel,enterpsdLabel,txtPassword,lblHint,loginbtn);
        vBox.setPadding(new Insets(40));
        vBox.setAlignment(Pos.BASELINE_CENTER);
        Scene scene = new Scene(vBox);
        vBox.setSpacing(20);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.centerOnScreen();
    }

    private void mainScene(Stage stage) {
        Label lblGreen = new Label("Hi! Welcome to the App");
        lblGreen.setTextFill(new Color(0, 0, 0, 0.2));

        Label lbl = new Label("Hi i'm moving");
        lbl.setVisible(false);

        AnchorPane anchorPane = new AnchorPane(lbl);
        anchorPane.setPrefHeight(400);
        anchorPane.setPrefWidth(500);

        anchorPane.setOnMouseEntered(event -> lbl.setVisible(true));        //get label when mouse in
        anchorPane.setOnMouseExited(event -> lbl.setVisible(false));        //hide when mouse is not there

        anchorPane.setOnMouseMoved(event ->{
            lbl.setLayoutX(event.getX());
            lbl.setLayoutY(event.getY());

        });



//        BorderPane borderPane = new BorderPane();
//        borderPane.setPadding(new Insets(40));
//        borderPane.setCenter(lblGreen);



        Scene scene = new Scene(anchorPane);


        stage.setScene(scene);
        stage.sizeToScene();


        stage.show();

    }


}
