package lk.ijse.dep10.basics;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class AppInitializer extends Application {

    private static Stage stgProgressBar;
    private static Stage stgImageViewer;
    private static Stage stgAudioPlayer;
    private static Stage stgVideoPlayer;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        mainScene(primaryStage);
        primaryStage.setTitle("Java FX Controls Continue");
        primaryStage.setResizable(false);
        primaryStage.show();
        primaryStage.centerOnScreen();
    }

    private void mainScene(Stage stage) {
        Label lblTitle = new Label("Java FX Controls Cont.");
        Button btnProgressBar = new Button("Progress Bar");
        Button btnImageViewer = new Button("Image Viewer");
        Button btnAudio = new Button("Play Audio");
        Button btnVideo = new Button("Play Video");
        Button btnDialogs = new Button("FX Dialogs");
        VBox root = new VBox(lblTitle, btnProgressBar, btnImageViewer, btnAudio, btnVideo,btnDialogs);

        root.setSpacing(10);
        root.setPadding(new Insets(10));

        lblTitle.setFont(new Font(20));
        lblTitle.setMaxWidth(Double.MAX_VALUE);
        lblTitle.setAlignment(Pos.CENTER);

        Font font = new Font(16);
        btnProgressBar.setFont(font);
        btnImageViewer.setFont(font);
        btnAudio.setFont(font);
        btnVideo.setFont(font);
        btnDialogs.setFont(font);
        btnDialogs.setMaxWidth(Double.MAX_VALUE);
        btnProgressBar.setMaxWidth(Double.MAX_VALUE);
        btnImageViewer.setMaxWidth(Double.MAX_VALUE);
        btnAudio.setMaxWidth(Double.MAX_VALUE);
        btnVideo.setMaxWidth(Double.MAX_VALUE);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setWidth(300);
        stage.setHeight(400);

        /* Setting Event Listeners */

        btnProgressBar.setOnAction(event -> showProgressBarStage());
        btnImageViewer.setOnAction(event -> showImageViewerStage());
        btnAudio.setOnAction(event -> showAudioPlayerStage());
        btnVideo.setOnAction(event -> showVideoPlayerStage());
        btnDialogs.setOnAction(event -> showDialogsStage() );
    }

    private void showProgressBarStage() {
        if (stgProgressBar != null) return;

        stgProgressBar = new Stage();
        stgProgressBar.setTitle("Progress Bar Demo");
        progressBarScene();
        stgProgressBar.show();
        stgProgressBar.centerOnScreen();

        /* Setting Event Listeners */

        stgProgressBar.setOnCloseRequest(event -> stgProgressBar = null);
    }

    private void progressBarScene() {
        Button btnStart = new Button("Start");
        Button btnStop = new Button("Stop");
        HBox hBox = new HBox(btnStart, btnStop);

        ProgressBar prg = new ProgressBar(0);
        Label lblPercentage = new Label("0%");
        VBox root = new VBox(hBox, prg, lblPercentage);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        root.setPadding(new Insets(10));

        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        Font font = new Font(16);
        btnStart.setFont(font);
        btnStop.setFont(font);

        lblPercentage.setFont(font);

        prg.setMaxWidth(Double.MAX_VALUE);

        stgProgressBar.setScene(new Scene(root));
        stgProgressBar.setMinWidth(300);
        stgProgressBar.setWidth(600);

        KeyFrame keyFrame = new KeyFrame(Duration.millis(50), event -> {
            prg.setProgress(prg.getProgress() + 0.05);
            int percentage = (int) (prg.getProgress() * 100);
            if (percentage < 100) lblPercentage.setText(percentage + "%");
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);

        /* Setting Event Listeners */

        prg.progressProperty().addListener((value, previousValue, currentValue) -> {
            System.out.printf("Old-Value: %s, New Value: %s \n", previousValue, currentValue);
            if (currentValue.intValue() >= 1) {
                timeline.stop();
                lblPercentage.setText("Completed!");
            }
        });

        btnStart.setOnAction(event -> {
            if (prg.getProgress() >= 1) prg.setProgress(0);
            timeline.playFromStart();
        });
        btnStop.setOnAction(event -> timeline.stop());
    }

    private void showImageViewerStage() {
        if (stgImageViewer != null) return;

        stgImageViewer = new Stage();
        stgImageViewer.setTitle("Image Viewer Demo");
        imageViewerScene();
        stgImageViewer.show();
        stgImageViewer.centerOnScreen();

        /* Setting Event Listeners */

        stgImageViewer.setOnCloseRequest(event -> stgImageViewer = null);
    }

    private void imageViewerScene() {
        ImageView img1 = new ImageView();
        AnchorPane pne1 = new AnchorPane(img1);
        AnchorPane.setLeftAnchor(img1, 0.0);
        AnchorPane.setTopAnchor(img1, 0.0);
        AnchorPane.setRightAnchor(img1, 0.0);
        AnchorPane.setBottomAnchor(img1, 0.0);

        ImageView img2 = new ImageView();
        AnchorPane pne2 = new AnchorPane(img2);
        AnchorPane.setLeftAnchor(img2, 0.0);
        AnchorPane.setTopAnchor(img2, 0.0);
        AnchorPane.setRightAnchor(img2, 0.0);
        AnchorPane.setBottomAnchor(img2, 0.0);

        Button btnInternalResource = new Button("Internal Resource");
        Button btnExternalResource = new Button("External Resource");
        VBox vBox1 = new VBox(pne1, btnInternalResource);
        VBox vBox2 = new VBox(pne2, btnExternalResource);
        HBox root = new HBox(vBox1, vBox2);

        pne1.setPrefWidth(250);
        pne1.setPrefHeight(250);
        pne2.setPrefWidth(250);
        pne2.setPrefHeight(250);

        pne1.setBorder(Border.stroke(Color.GRAY));
        pne2.setBorder(Border.stroke(Color.GRAY));

        vBox1.setAlignment(Pos.CENTER);
        vBox2.setAlignment(Pos.CENTER);
        vBox1.setSpacing(15);
        vBox2.setSpacing(15);

        Font font = new Font(16);
        btnInternalResource.setFont(font);
        btnExternalResource.setFont(font);

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(10));

        stgImageViewer.setScene(new Scene(root));
        stgImageViewer.setWidth(600);
        stgImageViewer.setMinHeight(400);

        /* Setting Event Listeners */

        btnInternalResource.setOnAction(event -> {
//            AppInitializer.class.getResource():URL    // Within static context
//            this.getClass().getResource():URL

//            Image image = new Image("/img/background-image.png"); // Java FX Only

            Image image = new Image(this.getClass().getResource("/img/background-image.png").toString());
            img1.setImage(image);
            img1.setFitWidth(250);
            img1.setFitHeight(250);
        });

        btnExternalResource.setOnAction(event -> {
            // File (Old)
            // Path (New)

//            Image image = new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");
//            Image image = new Image("file:data/img/background-image.jpg"); // Java FX Only

//            Image image = new Image(new File("data/img/background-image.jpg").toURI().toString());
            Image image = new Image(Path.of("data/img/background-image.jpg").toUri().toString());
//            Image image = new Image(Path.of("/home/ranjith-suranga/Desktop/transient.jpg").toUri().toString());
            img2.setImage(image);
            img2.setFitWidth(250);
            img2.setFitHeight(250);
        });
    }

    private void showAudioPlayerStage(){
        if (stgAudioPlayer != null) return;

        stgAudioPlayer = new Stage();
        stgAudioPlayer.setTitle("Audio Player Demo");
        audioPlayerScene();
        stgAudioPlayer.show();
        stgAudioPlayer.centerOnScreen();

        /* Setting Event Listeners */

        stgAudioPlayer.setOnCloseRequest(event -> stgAudioPlayer = null);
    }

    private void audioPlayerScene(){

        Button btnOpen=new Button("Open a file");
        ImageView img = new ImageView();
        Label lblStatus = new Label("Click to play the audio");
        VBox root = new VBox(btnOpen,img, lblStatus);

        Image icnPlay = new Image(this.getClass().getResource("/icon/play.png").toString());
        Image icnStop = new Image(this.getClass().getResource("/icon/stop.png").toString());

        img.setImage(icnPlay);

        img.setFitWidth(150);
        img.setFitHeight(150);
        img.setCursor(Cursor.HAND);

        root.setSpacing(40);
        root.setAlignment(Pos.CENTER);

        lblStatus.setFont(new Font(24));

        stgAudioPlayer.setScene(new Scene(root));
        stgAudioPlayer.setMinWidth(400);
        stgAudioPlayer.setWidth(400);
        stgAudioPlayer.setMinHeight(400);

        Media media = new Media(this.getClass().getResource("/mp3/file_example_MP3_700KB.mp3").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        /* Setting Event Listeners */

        img.setOnMouseEntered(event -> img.setOpacity(0.8));
        img.setOnMouseExited(event -> img.setOpacity(1));
        img.setOnMousePressed(event -> img.setEffect(new InnerShadow(10, Color.BLACK)));
        img.setOnMouseReleased(event -> {
            img.setEffect(null);

            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
                lblStatus.setText("Stopped!");
                img.setImage(icnPlay);
                mediaPlayer.stop();
            }else{
                lblStatus.setText("Playing...");
                img.setImage(icnStop);
                mediaPlayer.play();
            }
        });
    }

    private void showVideoPlayerStage(){
        if (stgVideoPlayer != null) return;

        stgVideoPlayer = new Stage();
        stgVideoPlayer.setTitle("Video Player Demo");
        videoPlayerScene();
        stgVideoPlayer.show();
        stgVideoPlayer.centerOnScreen();

        /* Setting Event Listeners */

        stgVideoPlayer.setOnCloseRequest(event -> stgVideoPlayer = null);
    }

    private void videoPlayerScene() {
        Image imgPlay = new Image(getClass().getResource("/icon/video-player/play.png").toString(), 48, 48, true, true);
        Image imgPause = new Image(getClass().getResource("/icon/video-player/pause.png").toString(), 48, 48, true, true);
        Image imgStop = new Image(getClass().getResource("/icon/video-player/stop.png").toString(), 48, 48, true, true);
        Image imgOpen = new Image(getClass().getResource("/icon/video-player/open.png").toString(), 48, 48, true, true);
        Image imgSpeaker = new Image(getClass().getResource("/icon/video-player/unmute.png").toString(), 48, 48, true, true);
        Image imgMute = new Image(getClass().getResource("/icon/video-player/mute.png").toString(), 48, 48, true, true);

        ImageView imgViewPlay = new ImageView(imgPlay);
        ImageView imgViewStop = new ImageView(imgStop);
        ImageView imgViewOpen = new ImageView(imgOpen);
        ImageView imgViewSpeaker = new ImageView(imgSpeaker);

        Label lblPlay = new Label("", imgViewPlay);
        Label lblStop = new Label("", imgViewStop);
        Label lblOpen = new Label("", imgViewOpen);
        Label lblSpeaker = new Label("", imgViewSpeaker);


        lblPlay.setTooltip(new Tooltip("Play"));
        lblStop.setTooltip(new Tooltip("Stop"));
        lblOpen.setTooltip(new Tooltip("Open a video file to play"));
        lblSpeaker.setTooltip(new Tooltip("Mute"));

        Slider sldVolume = new Slider(0, 1, 0.7);

        HBox hBox = new HBox(lblPlay, lblStop, lblOpen, lblSpeaker, sldVolume);

        Image imgBackground = new Image(getClass().getResource("/icon/video-player/play-inside.png").toString(), 200,200,true, true);
        ImageView imgViewBackground = new ImageView(imgBackground);
        Label lblBackground = new Label("", imgViewBackground);

        lblBackground.setAlignment(Pos.CENTER);
        lblBackground.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        MediaView mediaView = new MediaView();
        mediaView.setPreserveRatio(true);
        StackPane stackPane = new StackPane(lblBackground, mediaView);
        stackPane.setBackground(Background.fill(Color.BLACK));

        AnchorPane root = new AnchorPane(stackPane, hBox);
        AnchorPane.setLeftAnchor(hBox, 0.0);
        AnchorPane.setRightAnchor(hBox, 0.0);
        AnchorPane.setBottomAnchor(hBox, 0.0);

        AnchorPane.setTopAnchor(stackPane, 0.0);
        AnchorPane.setLeftAnchor(stackPane, 0.0);
        AnchorPane.setRightAnchor(stackPane, 0.0);
        AnchorPane.setBottomAnchor(stackPane, 89.0);

        hBox.setSpacing(15);
        hBox.setAlignment(Pos.CENTER);
        hBox.setPadding(new Insets(20,10,20,10));
        hBox.setBackground(Background.fill(Color.LIGHTBLUE));

        HBox.setHgrow(lblOpen, Priority.ALWAYS);
        lblOpen.setMaxWidth(Double.MAX_VALUE);
        lblOpen.setAlignment(Pos.CENTER);

        for (Node control : hBox.getChildren()) {
            if (control instanceof Label){
                Label lbl = (Label) control;
                lbl.setCursor(Cursor.HAND);
                lbl.setOnMouseEntered(event -> {
                    lbl.getGraphic().setOpacity(0.8);
                    ScaleTransition st = new ScaleTransition(Duration.millis(100), lbl);
                    st.setFromX(1);
                    st.setFromY(1);
                    st.setToX(1.1);
                    st.setToY(1.1);
                    st.play();
                });
                lbl.setOnMouseExited(event -> {
                    lbl.getGraphic().setOpacity(1);
                    ScaleTransition st = new ScaleTransition(Duration.millis(100), lbl);
                    st.setFromX(1.1);
                    st.setFromY(1.1);
                    st.setToX(1);
                    st.setToY(1);
                    st.play();
                });
            }
        }
        Scene scene = new Scene(root);
        stgVideoPlayer.setScene(scene);
        stgVideoPlayer.setMinWidth(400);
        stgVideoPlayer.setWidth(600);
        stgVideoPlayer.setMinHeight(400);
        stgVideoPlayer.show();

        mediaView.fitWidthProperty().bind(stackPane.widthProperty());
        mediaView.fitHeightProperty().bind(stackPane.widthProperty());

        lblOpen.setOnMouseClicked(mouseEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("video files", "*.mp4", "*.avi", "*.flv")       //get only video files
            );

            fileChooser.setTitle("Open new file");
            File videoFile = fileChooser.showOpenDialog(stgVideoPlayer);
            if (videoFile != null) {
                Media media = new Media(videoFile.toURI().toString());
                MediaPlayer videoPlayer = new MediaPlayer(media);
                mediaView.setMediaPlayer(videoPlayer);
                mediaView.toFront();

                videoPlayer.play();

                videoPlayer.volumeProperty().bind(sldVolume.valueProperty());       //set sound using slider bar using observable design pattern

                mediaView.setFitWidth(stackPane.getWidth());
                mediaView.setFitHeight(stackPane.getHeight());
            }

        });

        lblStop.setOnMouseClicked(event -> {
            MediaPlayer videoPlayer = mediaView.getMediaPlayer();
            if (videoPlayer != null) {
                videoPlayer.stop();
                mediaView.setMediaPlayer(null);

                lblBackground.toFront();
            }
        });

        lblPlay.setOnMouseClicked(event->{
            MediaPlayer videolayer = mediaView.getMediaPlayer();
            if(videolayer==null) return;
            if (videolayer.getStatus() == MediaPlayer.Status.PLAYING) {

            }
        });


    }

    private void showDialogsStage() {

        Button btnErrorMsg = new Button("Error Message");
        Button btnInfomationMsg = new Button("Information Message");
        Button btmWarningMsg = new Button("Warning Message");
        Button btnCostumMsg = new Button("Costum Message");
        Button btnConfirmationMsg = new Button("Confirmation Message");

        VBox vBox = new VBox(btnErrorMsg, btnInfomationMsg, btmWarningMsg, btnCostumMsg,btnConfirmationMsg);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(15));

        for (Node child : vBox.getChildren()) {
            Button btn=(Button)child;
            btn.setFont(Font.font("Ubuntu", 18));
            btn.setTextFill(Color.NAVY);
            btn.setMaxWidth(Double.MAX_VALUE);
        }

        btnErrorMsg.setOnAction(event ->{
            Alert errAlert = new Alert(Alert.AlertType.ERROR,"Something Wrong");       //error message alert
            errAlert.show();
        });

        btmWarningMsg.setOnAction(actionEvent -> {
            Alert wrnAlert = new Alert(Alert.AlertType.WARNING, "Warning");     //warning alert
            wrnAlert.show();
        });

        btnInfomationMsg.setOnAction(actionEvent -> {
            var infrAlert = new Alert(Alert.AlertType.INFORMATION, "For your Information");     //informations type
            infrAlert.show();
        });
        btnConfirmationMsg.setOnAction(actionEvent -> {
            Alert confimAletr = new Alert(Alert.AlertType.CONFIRMATION, "Are you want to delete",
                    ButtonType.YES, ButtonType.NO);
            Optional<ButtonType> button = confimAletr.showAndWait();            //monitor what button user press

            if(button.isPresent()&&button.get()==ButtonType.YES) System.out.println("yes");     //if button is yes
            else {
                System.out.println("No");
            }

        });
        btnCostumMsg.setOnAction(actionEvent -> {
            Alert cstAlter = new Alert(Alert.AlertType.NONE, "This is a Constum Message",ButtonType.OK,ButtonType.NEXT
            ,ButtonType.PREVIOUS);      //defined alert
            cstAlter.setTitle("This is a constume alert");      //set title
            cstAlter.setHeaderText("This is the header text");

            Image icon=new Image(getClass().getResource("/icon/video-player/play-inside.png").toString(), 32, 32, true, true);
            ImageView imgView = new ImageView(icon);
            cstAlter.setGraphic(imgView);           //set image for alert
            cstAlter.show();
            

        });

        Stage stage = new Stage();
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.sizeToScene();

        stage.setTitle("FX Dialogs");
        stage.show();
        stage.centerOnScreen();
    }

}