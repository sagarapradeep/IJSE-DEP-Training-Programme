package lk.ijse.dep10.app.controller;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MainCanvasControls {

    @FXML
    private ImageView imgErase;

    @FXML
    private ImageView imgOval;

    @FXML
    private ImageView imgPensil;

    @FXML
    private ImageView imgRectangle;

    @FXML
    private ImageView imgRoundRect;

    @FXML
    private ImageView imgText;

    @FXML
    private VBox vBox;

    Tooltip tooltip = new Tooltip("Rectangle");

    /*Vbox*/
    @FXML
    void vBoxOnMouseEntered(MouseEvent event) {
        vBox.getScene().setCursor(Cursor.HAND);
        tooltip.setText("Control Panel");
        Tooltip.install(vBox, tooltip);

    }



    /*Rectangle*/
    @FXML
    void imgRectangleOnMouseEntered(MouseEvent event) {
        imgRectangle.setOpacity(0.2);
        tooltip.setText("Rectangle");
        Tooltip.install(imgRectangle, tooltip);

    }

    @FXML
    void imgRectangleOnMouseExited(MouseEvent event) {
        imgRectangle.setOpacity(1);

    }



    /*round rectangle*/
    @FXML
    void imgRoundRectOnMouseEntered(MouseEvent event) {
        imgRoundRect.setOpacity(0.2);
        tooltip.setText("Round Rectangle");
        Tooltip.install(imgRoundRect, tooltip);

    }

    @FXML
    void imgRoundRectOnMouseExited(MouseEvent event) {
        imgRoundRect.setOpacity(1);

    }



    /*Oval*/
    @FXML
    void imgOvalOnMouseEntered(MouseEvent event) {
        imgOval.setOpacity(0.2);
        tooltip.setText("Oval");
        Tooltip.install(imgOval, tooltip);

    }
    @FXML
    void imgOvaOnMouseExited(MouseEvent event) {
        imgOval.setOpacity(1);

    }





    /*Pensil*/
    @FXML
    void imgPensilOnMouseEntered(MouseEvent event) {
        imgPensil.setOpacity(0.2);
        tooltip.setText("Pensil");
        Tooltip.install(imgPensil, tooltip);

    }

    @FXML
    void imgPensilOnMouseExited(MouseEvent event) {
        imgPensil.setOpacity(1);

    }



    /*Text*/
    @FXML
    void imgTextOnMouseEntered(MouseEvent event) {
        imgText.setOpacity(0.2);
        tooltip.setText("Text");
        Tooltip.install(imgText, tooltip);

    }

    @FXML
    void imgTextOnMouseExited(MouseEvent event) {
        imgText.setOpacity(1);

    }



    @FXML
    /*Erase*/
    void imgEraserOnMouseEntered(MouseEvent event) {
        imgErase.setOpacity(0.2);
        tooltip.setText("Eraser");
        Tooltip.install(imgErase, tooltip);

    }

    @FXML
    void imgEraserOnMouseExited(MouseEvent event) {
        imgErase.setOpacity(1);

    }

}
