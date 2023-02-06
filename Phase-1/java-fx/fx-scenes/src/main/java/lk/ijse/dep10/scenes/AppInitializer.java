package lk.ijse.dep10.scenes;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class AppInitializer extends Application {

    public static void main(String[] args) {

        launch(args);
        System.out.println("JVM is about to exit");
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Scene Manipulation");

//        primaryStage.setMinWidth(250);      //set min width
//        primaryStage.setMinHeight(350);
//
//        primaryStage.setMaxWidth(600);
//        primaryStage.setMaxHeight(450);


        mainScene(primaryStage);

    }

    private void mainScene(Stage stage) {
//
//        Paint paintForTextBox = Color.web("Black");
//        Background backgroundForLabel = Background.fill(paintForTextBox);
        Label lblTitle = new Label(("Main Scene").toUpperCase());
//        lblTitle.setTextFill(Color.web("White"));       //set colour for texts
//
        Font font = new Font("Ubuntu",30);      //set font for text
//        lblTitle.setFont(font);
//        lblTitle.setBackground(backgroundForLabel);

        Button btn1 = new Button("Scene 1");
//        btn1.setFont(new Font("Ubuntu", 15));
//        btn1.setBackground(Background.fill(Color.web("Grey")));     //short method for set colour
        btn1.setOnAction(event -> {
            fistScene(stage);
        });


        Button btn2 = new Button("Scene 2");
//        btn2.setFont(new Font("Ubuntu", 15));
//        Paint paintBtn2 = Color.web("Orange");
//        Background backgroundForBtn2 = Background.fill(paintBtn2);
//        btn2.setBackground(backgroundForBtn2);

        Button btn3 = new Button("Scene 3");
//        btn3.setFont(new Font("Ubuntu", 15));
//        Paint paintBtn3 = Color.rgb(255, 0, 0,0.6);
//        Background backgroundForBtn3 = Background.fill(paintBtn3);
//        btn3.setBackground(backgroundForBtn3);

        Button btn4 = new Button("Platform Exit");
//        btn4.setFont(new Font("Ubuntu", 15));
//        Paint paintBtn4=new Color(0.7,0.6,0.1,1);
//        Background backgroundForBtn4 = Background.fill(paintBtn4);
//        btn4.setBackground(backgroundForBtn4);          //set background for button 4

        btn4.setOnAction(event ->{
            System.out.println("Platform Exit");
            Platform.exit();
        } );
        btn2.setOnAction(event -> {
            secondScene(stage);
        });
        btn3.setOnAction(event -> {
            thirdScene(stage);
        });

        Button btn5 = new Button("System Exit");
//        btn5.setFont(new Font("Ubuntu", 15));
//        btn5.setBackground(Background.fill(Color.web("Brown")));

//        btn1.setPrefWidth(250);     //set width for button

        btn5.setOnAction(event ->{
            System.out.println("System Exit");
            System.exit(0);
        } );

        btn2.maxWidth(Double.MAX_VALUE);        //set maximum value for button.Then control vary with the stage

        Paint paintForVBox = Color.web("Lightgreen");
        Background backgroundForVBox = Background.fill(paintForVBox);
        VBox root = new VBox(lblTitle,btn1,  btn2, btn3,btn4,btn5);
        root.setBackground(backgroundForVBox);

        for (Node child :root.getChildren()) {
            if(!(child instanceof Labeled)) continue;
            Labeled lbl = (Labeled) child;
            lbl.setFont(font);

        }
        for (Node child : root.getChildren()) {
            if(!(child instanceof Labeled)) continue;
            Labeled lbl =(Labeled) child;
            lbl.setMaxWidth(Double.MAX_VALUE);      //set button width automatically to stage width

        }
        lblTitle.setAlignment(Pos.CENTER);




        root.setSpacing(10);
        root.setPadding(new Insets(10));

        Scene mainScene = new Scene(root);
        stage.setScene(mainScene);
        stage.sizeToScene();
        stage.centerOnScreen();
        stage.show();

    }

    private void fistScene(Stage stage) {
        System.out.println("First Scene");
        Label label = new Label(("First Scene").toUpperCase());


        label.setFont(new Font("Ubuntu",20));
        label.setAlignment(Pos.CENTER);
        Button btnBack = new Button("Back");

        btnBack.setFont(new Font("Ubuntu",15));
        btnBack.setOnAction(event -> mainScene(stage));
        btnBack.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(label, btnBack);
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20));
        vBox.setBackground(Background.fill(Color.web("Lightgray")));
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        stage.sizeToScene();
        stage.centerOnScreen();
    }

    private void secondScene(Stage stage) {
        System.out.println("Second Scene");

        Label label = new Label(("Second Scene").toUpperCase());


        label.setFont(new Font("Ubuntu",20));
        label.setAlignment(Pos.CENTER);
        Button btnBack = new Button("Back");
        btnBack.setMaxWidth(Double.MAX_VALUE);
        btnBack.setFont(new Font("Ubuntu",15));
        btnBack.setOnAction(event -> mainScene(stage));
        btnBack.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(label, btnBack);
        vBox.setBackground(Background.fill(Color.web("Lightyellow")));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(20));
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
        stage.sizeToScene();
        stage.centerOnScreen();

    }
    private void thirdScene(Stage stage) {
        System.out.println("Third Scene");

        Label label = new Label(("Third Scene").toUpperCase());

        label.setMaxWidth(Double.MAX_VALUE);
        label.setFont(new Font("Ubuntu",20));
        label.setAlignment(Pos.CENTER);
        Button btnBack = new Button("Back");
        btnBack.setMaxWidth(Double.MAX_VALUE);
        btnBack.setFont(new Font("Ubuntu",15));
        btnBack.setOnAction(event -> mainScene(stage));
        btnBack.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(label, btnBack);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(20));
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        vBox.setBackground(Background.fill(Color.web("Lightblue")));
        stage.show();
        stage.sizeToScene();
        stage.centerOnScreen();

    }
}
