package lk.ijse.dep10.animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppInitializer extends Application {
    Stage stageTransition;
    Stage stageAnimation;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);

    }

    private void mainScene(Stage stage) {

        stage.setTitle("JavaFX Animation Demo");
        Label lblTopic = new Label("JavaFX Animation Module");
        lblTopic.setMaxWidth(Double.MAX_VALUE);
        lblTopic.setAlignment(Pos.CENTER);
        lblTopic.setFont(Font.font("Ubuntu", FontWeight.BOLD, 25));
        lblTopic.setTextFill(Color.NAVY);


        Label lblTime = new Label(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        lblTime.setMaxWidth(Double.MAX_VALUE);
        lblTime.setAlignment(Pos.CENTER);
        lblTime.setFont(Font.font("Ubuntu", FontWeight.BOLD, 25));
        lblTopic.setTextFill(Color.NAVY);


        Button btnTransition =new Button("Transition");
        btnTransition.setMaxWidth(Double.MAX_VALUE);
        btnTransition.setAlignment(Pos.CENTER);
        btnTransition.setFont(Font.font("Ubuntu", 20));
        btnTransition.setTextFill(Color.BLUE);


        Button btnAnimation = new Button("Animation");
        btnAnimation.setMaxWidth(Double.MAX_VALUE);
        btnAnimation.setAlignment(Pos.CENTER);
        btnAnimation.setTextFill(Color.BLUE);
        btnAnimation.setFont(Font.font("Ubuntu", 20));


        VBox vBox = new VBox(lblTopic, btnTransition, btnAnimation,lblTime);

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1.0),event->{
            lblTime.setText(LocalTime.now().format(DateTimeFormatter.ofPattern("hh:mm:ss")));

        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();

        vBox.setPadding(new Insets(40));
        vBox.setSpacing(20);
        vBox.setAlignment(Pos.CENTER);

        btnTransition.setOnAction(actionEvent -> {
            sceneTransition();
        });

        btnAnimation.setOnAction(actionEvent -> {
            sceneAnimation();
        });

        Scene scene = new Scene(vBox);

        stage.setScene(scene);
        stage.sizeToScene();

        stage.centerOnScreen();
        stage.show();

    }

    private void sceneTransition() {
        Button btnFadeIn = new Button("Fade In");


        Button btnFadeOut = new Button("Fade Out");


        Button btnScale = new Button("Scale");


        Button btnRotate = new Button("Rotate");


        Button btnTranslateX = new Button("TranslateX");


        Button btnTranslateY = new Button("TranslateY");
        Button btnReset = new Button("Reset");


        Label lblPreview = new Label("Preview");
        lblPreview.setFont(Font.font("Ubuntu", FontWeight.BOLD, 40));
        lblPreview.setTextFill(Color.color(0,0,0.6,0.5));
        lblPreview.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);

        HBox hBox= new HBox(btnReset,btnFadeIn, btnFadeOut, btnScale, btnRotate, btnTranslateX, btnTranslateY);
        hBox.setAlignment(Pos.CENTER);
        for (Node child : hBox.getChildren()) {
            Button btn=(Button) child;
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setAlignment(Pos.CENTER);
            btn.setFont(Font.font("Ubuntu", 20));
            HBox.setHgrow(btn, Priority.ALWAYS);
        }


        hBox.setPrefHeight(100);
        hBox.setPrefWidth(800);
        hBox.setPadding(new Insets(15,10,150,10));
        hBox.setSpacing(10);

        VBox vBox = new VBox(hBox, lblPreview);

        Scene scene = new Scene(vBox);
        if(stageTransition!=null)return;
        stageTransition = new Stage();
        stageTransition.setScene(scene);

        stageTransition.setTitle("Transition Scene");
        stageTransition.centerOnScreen();
        stageTransition.setMinWidth(600);
        stageTransition.setMinHeight(500);
        stageTransition.show();

        stageTransition.setOnCloseRequest(event ->{
            stageTransition=null;
        });

        btnFadeIn.setOnAction(event ->{
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(5), lblPreview);
            fadeIn.setFromValue(0);
            fadeIn.setToValue(1);
            fadeIn.play();
        });

        btnFadeOut.setOnAction(event ->{
            FadeTransition fadeIn = new FadeTransition(Duration.seconds(5), lblPreview);
            fadeIn.setFromValue(1);
            fadeIn.setToValue(0);
            fadeIn.play();
        });

        btnScale.setOnAction(event ->{
            ScaleTransition scale = new ScaleTransition(Duration.seconds(5), lblPreview);
            scale.setFromX(1);
            scale.setToX(2);
            scale.setFromY(1);
            scale.setToY(2);
            scale.play();
        });

        btnRotate.setOnAction(event ->{
            RotateTransition rotate = new RotateTransition(Duration.seconds(5), lblPreview);
            rotate.setFromAngle(0);
            rotate.setToAngle(360);
            rotate.play();
//            rotate.setOnFinished(e->rotate.jumpTo(Duration.ZERO));
        });

        btnTranslateX.setOnAction(event ->{
            TranslateTransition transitionX = new TranslateTransition(Duration.seconds(5), lblPreview);
            transitionX.setFromX(-500);
            transitionX.setToX(0);
            transitionX.play();
//            rotate.setOnFinished(e->rotate.jumpTo(Duration.ZERO));
        });

        btnTranslateY.setOnAction(event ->{
            TranslateTransition transitionY = new TranslateTransition(Duration.seconds(5), lblPreview);
            transitionY.setFromY(-500);
            transitionY.setToY(0);
            transitionY.play();
//            rotate.setOnFinished(e->rotate.jumpTo(Duration.ZERO));
        });

        btnReset.setOnAction(event ->{
            lblPreview.setScaleX(1);
            lblPreview.setScaleY(1);
            lblPreview.setRotate(0);
            lblPreview.setOpacity(1);

        });


    }

    private void sceneAnimation() {

        Button btnPlay = new Button("Play");
        btnPlay.setFont(Font.font("Ubuntu", 20));
        btnPlay.setMinWidth(100);
        btnPlay.setMaxWidth(Double.MAX_VALUE);
        Button btnStop = new Button("Stop");
        btnStop.setFont(Font.font("Ubuntu", 20));
        btnStop.setMinWidth(100);
        btnStop.setMaxWidth(Double.MAX_VALUE);

        Label lblPreview = new Label("Preview");
        lblPreview.setFont(Font.font("Ubuntu", FontWeight.BOLD, 40));
        lblPreview.setTextFill(Color.color(0,0,0.6,0.5));
        lblPreview.setMaxWidth(Double.MAX_VALUE);
        lblPreview.setAlignment(Pos.CENTER);

        VBox vBox = new VBox(btnPlay, btnStop);
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(5));

        StackPane stackPane = new StackPane(lblPreview);
        stackPane.setBackground(Background.fill(Color.LIGHTSKYBLUE));


        HBox hBox = new HBox(vBox,stackPane);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));

        HBox.setHgrow(stackPane,Priority.ALWAYS);
        if(stageAnimation!=null)return;
        stageAnimation = new Stage();
        stageAnimation.setTitle("Animation Scene");

        Scene scene = new Scene(hBox);
        stageAnimation.setScene(scene);

        stageAnimation.setMinWidth(400);
        stageAnimation.setMinHeight(300);

        stageAnimation .centerOnScreen();
        stageAnimation .show();

        stageAnimation.setOnCloseRequest(event ->{
            stageAnimation = null;
        });

        KeyFrame keyFrame1=new KeyFrame(Duration.millis(500),event->{       //Key frames for timelines
            lblPreview.setTextFill(Color.RED);


        });
        KeyFrame keyFrame2=new KeyFrame(Duration.millis(750),event->{
            lblPreview.setTextFill(Color.DARKBLUE);
            lblPreview.setScaleX(3.5);
            lblPreview.setScaleY(3.5);
        });
        KeyFrame keyFrame3=new KeyFrame(Duration.millis(1000),event->{
            lblPreview.setTextFill(Color.GAINSBORO);
            lblPreview.setScaleX(0.9);
            lblPreview.setScaleY(0.9);
        });
        KeyFrame keyFrame4=new KeyFrame(Duration.millis(1250),event->{
            lblPreview.setTextFill(Color.NAVAJOWHITE);
            lblPreview.setTranslateX(40);
            lblPreview.setTranslateY(40);

        });
        KeyFrame keyFrame5=new KeyFrame(Duration.millis(500),event->{
            lblPreview.setTextFill(Color.OLIVEDRAB);
            lblPreview.setTranslateX(0);
            lblPreview.setTranslateY(0);
        });

        Timeline timeLine = new Timeline(keyFrame1, keyFrame2, keyFrame3, keyFrame4, keyFrame5);        //set key frames to timeline
        timeLine.setCycleCount(Animation.INDEFINITE);

        btnPlay.setOnAction(event ->{
            timeLine.playFromStart();
        });
        btnStop.setOnAction(event ->{
            timeLine.stop();
        });


    }
}
