package lk.ijse.dep10.projects;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.File;

public class AppInitializer extends Application {
    private MediaPlayer mediaPlayer;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mediaPlayer(primaryStage);

    }

    public void mediaPlayer(Stage stage) {

        final int imageHeight = 50;
        final int imageWidth = 50;

        Button btnOpen = new Button("Open");
        btnOpen.setPadding(new Insets(10));
        btnOpen.setFont(new Font("Ubuntu", 21));
        btnOpen.setTextFill(Color.NAVY);

        Label lblFileLocation = new Label("Nothing");
        lblFileLocation.setPadding(new Insets(10));

        /*Image view*/

        ImageView imgPlay = new ImageView();
        imgPlay.setFitWidth(imageWidth);
        imgPlay.setFitHeight(imageHeight);
        ImageView imgStop = new ImageView();
        imgStop .setFitWidth(imageWidth);
        imgStop .setFitHeight(imageHeight);
        ImageView imgLoop = new ImageView();
        imgLoop.setFitWidth(imageWidth);
        imgLoop.setFitHeight(imageHeight);
        ImageView imgMute = new ImageView();
        imgMute.setFitWidth(imageWidth);
        imgMute.setFitHeight(imageHeight);

        /*Slider bar*/
        Slider slider = new Slider();
        slider.setMax(2);
        slider.setMin(1);
        slider.setMajorTickUnit(4);



        /*Set images from resources*/
        Image icnPlay = new Image(this.getClass().getResource("/image/play.png").toString());
        Image icnPause = new Image(this.getClass().getResource("/image/pause.png").toString());
        Image icnStop = new Image(this.getClass().getResource("/image/stop.png").toString());
        Image icnLoop = new Image(this.getClass().getResource("/image/loop.png").toString());
        Image icnMute = new Image(this.getClass().getResource("/image/mute.png").toString());
        Image icnunMute = new Image(this.getClass().getResource("/image/unmute.png").toString());

        /*set image to imageView*/
        imgPlay.setImage(icnPlay);
        imgStop.setImage(icnStop);
        imgLoop.setImage(icnLoop);
        imgMute.setImage(icnMute);


        /*HBoxes for each horizontal pack */
        HBox hBox1 = new HBox(btnOpen);
        hBox1.setPadding(new Insets(10));
        HBox hBox2 = new HBox(lblFileLocation);
        hBox2.setPadding(new Insets(10));
        HBox hBox3 = new HBox(imgPlay, imgStop, imgLoop, imgMute,slider);
        hBox3.setPadding(new Insets(10));
        hBox3.setSpacing(40);
        hBox3.setAlignment(Pos.CENTER);
        hBox3.setBorder(Border.stroke(Color.RED));




        /*Set image appearances for play and pause when with curser*/
        imgPlay.setOnMouseEntered(event->{
            imgPlay.setOpacity(0.4);
            imgPlay.setCursor(Cursor.HAND);
        });
        imgPlay.setOnMouseExited(event->{
            imgPlay.setOpacity(1);
            imgPlay.setCursor(Cursor.DEFAULT);
        });
        imgPlay.setOnMouseClicked(event->{
            imgPlay.setEffect(new InnerShadow(10, Color.BLACK));
            imgStop.setEffect(new InnerShadow());
        });
        imgPlay.setOnMouseReleased(event->{
            if (mediaPlayer != null) {

                if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    imgPlay.setImage(icnPause);
                    mediaPlayer.pause();


                }else{
                    imgPlay.setImage(icnPlay);
                    mediaPlayer.play();
                }
            }
        });

        /*Set image appearances for stop when with curser*/
        imgStop.setOnMouseEntered(event->{
            imgStop.setOpacity(0.4);
            imgStop.setCursor(Cursor.HAND);
        });
        imgStop.setOnMouseExited(event->{
            imgStop.setOpacity(1);
            imgStop.setCursor(Cursor.DEFAULT);
        });
        imgStop.setOnMouseClicked(event->{
            if(mediaPlayer.getStatus()==MediaPlayer.Status.PLAYING)imgStop.setEffect(new InnerShadow(10, Color.BLACK));

        });
        imgStop.setOnMouseReleased(event->{
            if (mediaPlayer != null) {
                mediaPlayer.stop();

            }
        });

        /*Mute image*/
        imgMute.setOnMouseEntered(event->{
            imgMute.setOpacity(0.4);
            imgMute.setCursor(Cursor.HAND);
        });
        imgMute.setOnMouseExited(event->{
            imgMute.setOpacity(1);
            imgMute.setCursor(Cursor.DEFAULT);
        });
        imgMute.setOnMouseClicked(event->{
            imgMute.setEffect(new InnerShadow(10, Color.BLACK));
        });
        imgMute.setOnMouseReleased(event->{
            if (mediaPlayer != null) {
                if (mediaPlayer.isMute()) {
                    imgMute.setImage(icnunMute);
                    mediaPlayer.setMute(false);

                }else{
                    imgMute.setImage(icnMute);
                    mediaPlayer.setMute(true);
                }
            }
        });



        /*Slider*/
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mediaPlayer.setVolume(slider.getValue() * 10);
            }
        });

        /*Loop*/

        imgLoop.setOnMouseEntered(event->{
            imgLoop.setOpacity(0.4);
            imgLoop.setCursor(Cursor.HAND);
        });
        imgLoop.setOnMouseExited(event->{
            imgLoop.setOpacity(1);
            imgLoop.setCursor(Cursor.DEFAULT);
        });
        imgLoop.setOnMouseClicked(event->{
            if(mediaPlayer.getStatus()==MediaPlayer.Status.PLAYING)imgLoop.setEffect(new InnerShadow(10, Color.BLACK));

        });
        imgStop.setOnMouseReleased(event->{
            if (mediaPlayer != null) {
                mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);

            }
        });










        /*Set open file button to action*/
        btnOpen.setOnAction(event ->{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Audio File to Play");
            File audioFile = fileChooser.showOpenDialog(null);

            if (audioFile != null) {
                Media media = new Media(audioFile.toURI().toString());
                mediaPlayer=new MediaPlayer(media);
                lblFileLocation.setText(audioFile.toURI().toString());

            }
            else{
                mediaPlayer=null;
            }


        });

        Stop[] stops = new Stop[] { new Stop(0, Color.LIGHTBLUE), new Stop(1, Color.LIGHTGREEN)};
        LinearGradient linear = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);


        VBox vBox = new VBox(hBox1, hBox2, hBox3);      //vBox for all Hboxes
        vBox.setBackground(Background.fill(linear));


        Scene scene = new Scene(vBox);




        stage.setScene(scene);
        stage.sizeToScene();
        stage.setMinWidth(300);
        stage.setMinHeight(300);

        stage.setTitle("Medial Player");
        stage.show();

    }


}
