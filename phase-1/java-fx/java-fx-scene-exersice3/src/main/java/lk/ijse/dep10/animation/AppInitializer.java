package lk.ijse.dep10.animation;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class AppInitializer extends Application {
    int i = 0;
    int j = 0;
    String temp = "";
    boolean reverse = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        loginPanel(primaryStage);

    }

    private void loginPanel(Stage stage) {
        Label lblTitle = new Label("Student Login");          //student login label
        lblTitle.setFont(Font.font("Ubuntu", FontWeight.BOLD, 40));
        lblTitle.setTextFill(Color.NAVY);
        lblTitle.setPadding(new Insets(10, 20, 30, 20));

        Label lblPassWord = new Label("Enter Password");        //password label
        lblPassWord.setFont(Font.font("Ubuntu", FontWeight.BOLD, 18));
        lblPassWord.setTextFill(Color.NAVY);
        lblPassWord.setPadding(new Insets(10));

        PasswordField pswdField = new PasswordField();      //pswd field
        pswdField.setMaxWidth(200);
        pswdField.setAlignment(Pos.CENTER);

        Label lblInvalidPswd = new Label("Invalid Password");       //invalid password label
        lblInvalidPswd.setTextFill(Color.RED);
        lblInvalidPswd.setVisible(false);


        Button btnLogin = new Button("Login");      //login button
        btnLogin.setFont(Font.font("Ubuntu", 21));
        btnLogin.setTextFill(Color.NAVY);
        btnLogin.setDefaultButton(true);

        btnLogin.setOnAction(event -> {
            String password = pswdField.getText();
            if (!(password.equals("Admin"))) {
                lblInvalidPswd.setVisible(true);
                pswdField.selectAll();
            } else {
                animationScene(stage);
            }
        });

        VBox vBox = new VBox(lblTitle, lblPassWord, pswdField, lblInvalidPswd, btnLogin);
        vBox.setAlignment(Pos.CENTER);
        vBox.setPadding(new Insets(20, 10, 30, 10));
        vBox.setSpacing(10);
        vBox.setBackground(Background.fill(Color.LIGHTGREY));

        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
        stage.centerOnScreen();
    }

    private void animationScene(Stage stage) {


        Label lblBase = new Label("Hi! Welcome to the App");            //base text in root pane
        lblBase.setFont(Font.font("Ubuntu", FontWeight.BOLD, 28));
        lblBase.setTextFill(Color.NAVY);
        lblBase.setOpacity(0.2);
        lblBase.setAlignment(Pos.CENTER);


        Label lblMoving = new Label("");        //create moving label
        lblMoving.setVisible(false);

        AnchorPane anchorPane = new AnchorPane(lblMoving);                 //anchorpane for


        anchorPane.setOnMouseEntered(event -> {           //set visible for moving label with mouse entered
            lblMoving.setVisible(true);
        });
        anchorPane.setOnMouseExited(event -> {
            lblMoving.setVisible(false);
        });

        anchorPane.setOnMouseMoved(event -> {                //get mouse coordinates
            lblMoving.setLayoutX(event.getX());
            lblMoving.setLayoutY(event.getY());

        });

        StackPane stackPane = new StackPane(lblBase, anchorPane);       //base root in stack pane

        Scene scene = new Scene(stackPane);
        stage.setScene(scene);


        KeyFrame frame1 = new KeyFrame(Duration.millis(0), event -> {
            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(2), lblBase);
            translateTransition.setFromX(-450);
            translateTransition.setToX(100);
            translateTransition.play();
        });

        KeyFrame frame2 = new KeyFrame(Duration.millis(2000), event -> {
            TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), lblBase);
            translateTransition.setFromX(100);
            translateTransition.setToX(0);
            translateTransition.play();
        });

        KeyFrame frame3 = new KeyFrame(Duration.millis(2500), event -> {
            ScaleTransition scaleTransition1 = new ScaleTransition(Duration.millis(350), lblBase);
            scaleTransition1.setFromX(1);
            scaleTransition1.setToX(1.3);
            scaleTransition1.setFromY(1);
            scaleTransition1.setToY(1.3);
            scaleTransition1.play();
        });

        KeyFrame frame4 = new KeyFrame(Duration.millis(2850), event -> {
            ScaleTransition scaleTransition1 = new ScaleTransition(Duration.millis(350), lblBase);
            scaleTransition1.setFromX(1.3);
            scaleTransition1.setToX(1);
            scaleTransition1.setFromY(1.3);
            scaleTransition1.setToY(1);
            scaleTransition1.play();
        });

        String[] messages = new String[]{"Welcome", "to", "the", "App"};

        KeyFrame frame5 = new KeyFrame(Duration.seconds(0.4), event -> {
            char[] strToCharArray = messages[i].toCharArray();

            if (!reverse) {

                if (j == strToCharArray.length) {
                    reverse = true;
                } else if (i == messages.length) {
                    String temp = "";
                    i = 0;

                } else {
                    temp += strToCharArray[j];
                    System.out.println("i =" + i + " " + "j= " + j);
//                lblMoving.setText(temp);
                    ++j;
                }
            } else {
                if (j == 0) {
                    reverse = false;
                    ++i;
                    temp = "";
                } else {
                    temp = temp.substring(0, j);
                    --j;
                }
            }


        });

        Timeline timeline1 = new Timeline(frame1, frame2, frame3, frame4);

        Timeline timeline2 = new Timeline(frame5);


        timeline1.setCycleCount(1);
        timeline1.play();

        timeline2.setCycleCount(10);
        timeline2.play();

        stage.sizeToScene();
        stage.setMinWidth(500);
        stage.setMinWidth(500);
        stage.show();

    }
}
