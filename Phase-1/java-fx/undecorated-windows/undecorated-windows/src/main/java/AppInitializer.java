import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /*btn exit*/
        Button btnExit = new Button("X");
        btnExit.setFont(Font.font("Ubuntu", 20));
        btnExit.setTextFill(Color.BLACK);
        btnExit.setCursor(Cursor.HAND);
        btnExit.setPrefWidth(10);
        btnExit.setPrefHeight(30);
        btnExit.setBackground(Background.fill(Color.TRANSPARENT));

        btnExit.setOnMouseEntered(event ->{
            btnExit.setTextFill(Color.RED);
        });
        btnExit.setOnMouseExited(event ->{
            btnExit.setTextFill(Color.BLACK);
        });
        btnExit.setOnMouseReleased(event ->{
            Platform.exit();
        });


    /*Btn minimize*/
        Button btnMinimize = new Button("-");
        btnMinimize.setFont(Font.font("Ubuntu", 20));
        btnMinimize.setTextFill(Color.BLACK);
        btnMinimize.setCursor(Cursor.HAND);
        btnMinimize.setPrefWidth(20);
        btnMinimize.setPrefHeight(30);
        btnMinimize.setBackground(Background.fill(Color.TRANSPARENT));

        btnMinimize.setOnMouseEntered(event ->{
            btnMinimize.setTextFill(Color.NAVY);
        });
        btnMinimize.setOnMouseExited(event ->{
            btnMinimize.setTextFill(Color.BLACK);
        });
        btnMinimize.setOnMouseReleased(event ->{
            primaryStage.setIconified(true);        //set stage minimize
        });

        HBox hBox = new HBox(btnMinimize, btnExit);








        Image imgView = new Image(this.getClass().getResource("/img/toppng.com-scroll-paper-png-old-paper-scroll-art-1653x2230.png").toString());
        ImageView img = new ImageView(imgView);
        img.setFitWidth(400);
        img.setFitHeight(650);
        img.setPreserveRatio(true);


        AnchorPane root = new AnchorPane(img,hBox);

        /*Image anchor*/
        AnchorPane.setTopAnchor(img, 0.0);
        AnchorPane.setBottomAnchor(img, 0.0);
        AnchorPane.setLeftAnchor(img, 0.0);
        AnchorPane.setRightAnchor(img, 0.0);

        /*hBox anchor*/
        AnchorPane.setTopAnchor(hBox, 0.0);
        AnchorPane.setBottomAnchor(hBox, 100.0);
        AnchorPane.setLeftAnchor(hBox, 300.0);
        AnchorPane.setRightAnchor(hBox, 0.0);

        /*Create undecorated window move*/
        root.setOnMouseDragged(event ->{
            if(event.getButton()== MouseButton.PRIMARY) {
                primaryStage.setX(event.getScreenX());
                primaryStage.setY(event.getScreenY());
            }});


//        /*Exit anchor*/
//        AnchorPane.setTopAnchor(btnExit, 150.0);
//        AnchorPane.setBottomAnchor(btnExit, 500.0);
//        AnchorPane.setLeftAnchor(btnExit, 60.0);
//        AnchorPane.setRightAnchor(btnExit, 300.0);
//
//        /*Minimize anchor*/
//        AnchorPane.setTopAnchor(btnExit, 150.0);
//        AnchorPane.setBottomAnchor(btnExit, 500.0);
//        AnchorPane.setLeftAnchor(btnExit, 60.0);
//        AnchorPane.setRightAnchor(btnExit, 300.0);

        Scene mainScene = new Scene(root);
        root.setBackground(Background.fill(Color.TRANSPARENT));
        mainScene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(mainScene);

//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.initStyle(StageStyle.TRANSPARENT);

        primaryStage.setTitle("Under Corated Window");
        primaryStage.sizeToScene();
        primaryStage.show();
        primaryStage.centerOnScreen();





    }
}
