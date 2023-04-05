package lk.ijse.dep10.assignment02.util;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
    public static void setDateAndTime(Label lbl) {
        lbl.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd  hh:mm:ss")));
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            lbl.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd  hh:mm:ss")));
        });
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.playFromStart();
    }
}
