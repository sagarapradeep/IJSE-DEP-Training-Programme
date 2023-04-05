package lk.ijse.dep10.app.controls;

import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



public class MainFormControls {
    public Canvas cnvMain;
    public ColorPicker clrStroke;
    public ColorPicker clrFill;

    double x1;
    double width;
    double y1;
    double height;

    public void initialize2() {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(Color.LIME);
        gc.fillRect(50,50,150,150);
        gc.clearRect(50,50,50,50);

        gc.setFill(Color.RED);
        gc.fillRoundRect(250,50,150,150,20,20);

        gc.setFont(new Font(32));
//        gc.setFill(Color.YELLOWGREEN);
//        gc.fillText("Sagara",20,80);

        gc.setFill(Color.YELLOWGREEN);
        gc.setStroke(Color.LIGHTSEAGREEN);
        gc.strokeText("Sagara",20,80);
    }


    public void cnvMainOnMouseClicked(MouseEvent mouseEvent) {

    }

    public void cnvMainOnMouseReleased(MouseEvent mouseEvent) {

//        width=mouseEvent.getX()-x1;
//        height = mouseEvent.getY() - y1;
//
//        if (width < 0) {
//            width=-width;
//        }
//        if (height < 0) {
//            height=-height;
//        }
//
//        GraphicsContext gp = cnvMain.getGraphicsContext2D();
//
//        gp.strokeRect(x1, y1, width, height);

    }



    public void cnvMainOnMousePressed(MouseEvent mouseEvent) {
        x1 = mouseEvent.getX();
        y1 = mouseEvent.getY();
    }

    public void cnvMainOnMouseDragged(MouseEvent mouseEvent) {
        width=mouseEvent.getX()-x1;
        height = mouseEvent.getY() - y1;

        if (width < 0) {
            width=-width;
        }
        if (height < 0) {
            height=-height;
        }

        GraphicsContext gp = cnvMain.getGraphicsContext2D();
        gp.clearRect(0,0,cnvMain.getWidth(),cnvMain.getHeight());

        gp.strokeRect(x1, y1, width, height);
    }

    public void clrFillOnAction(ActionEvent actionEvent) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(clrFill.getValue());
    }

    public void clrStrokeOnAction(ActionEvent actionEvent) {
        GraphicsContext gc = cnvMain.getGraphicsContext2D();
        gc.setFill(clrStroke.getValue());
    }
}

