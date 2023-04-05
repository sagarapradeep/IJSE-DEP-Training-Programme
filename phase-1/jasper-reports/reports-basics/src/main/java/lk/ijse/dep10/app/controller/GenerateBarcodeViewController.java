package lk.ijse.dep10.app.controller;

import com.sun.glass.ui.CommonDialogs;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GenerateBarcodeViewController {

    @FXML
    private Button btnDownloadBarcode;

    @FXML
    private ImageView imgBarcode;

    @FXML
    private TextField txtText;

    public void initialize() {
        generateBarcode();
        txtText.textProperty().addListener(c->{
            generateBarcode();
        });
    }

    public void generateBarcode() {
        try {

            if(!txtText.getText().matches("\\d{12}"))return;
            Barcode barcode = BarcodeFactory.createEAN13(txtText.getText());
            barcode.setFont(new Font("ubuntu",Font.BOLD,14));

            BufferedImage barcodeImage = BarcodeImageHandler.getImage(barcode);

            WritableImage fxImage = SwingFXUtils.toFXImage(barcodeImage, null);
            imgBarcode.setImage(fxImage);


        } catch (BarcodeException | OutputException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnDownloadBarcodeOnAction(ActionEvent event) throws IOException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save barcode image");
        fileChooser.setInitialFileName("barcode.jpeg");


        fileChooser.getExtensionFilters()
                .add(new FileChooser.ExtensionFilter("JPEG Image (*.jpeg)","*.jpeg"));

        File file = fileChooser.showSaveDialog(btnDownloadBarcode.getScene().getWindow());

        if(file==null) return;

        Image fxImage = imgBarcode.getImage();
        BufferedImage barcodeImage = SwingFXUtils.fromFXImage(fxImage, null);

        ImageIO.write(barcodeImage, "png", file);
        new Alert(Alert.AlertType.INFORMATION, "Image Saved!").showAndWait();




    }

}
