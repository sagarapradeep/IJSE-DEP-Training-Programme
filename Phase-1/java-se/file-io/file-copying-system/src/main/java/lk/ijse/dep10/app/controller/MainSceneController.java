package lk.ijse.dep10.app.controller;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class MainSceneController {

    @FXML
    private Button btnCopy;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSelectFileDestination;

    @FXML
    private Button btnSelectFileSource;

    @FXML
    private Label lblProgressBar;

    @FXML
    private Label lblSelectFileDestination;

    @FXML
    private Label lblSelectFileSource;

    @FXML
    private ProgressBar prg;
    private byte[]bytes;
    private FileOutputStream fos;
    private FileInputStream fis;
    private File sourceFile;
    private File destinationDirectory;
    private File newFile;

    public void initialize() {
        lblSelectFileDestination.setText("No Such File or Directory");
        lblSelectFileSource.setText("No Such File or Directory");
        btnCopy.setDisable(true);

    }

    @FXML
    void btnCopyOnAction(ActionEvent event) throws IOException {
        long fileLength = sourceFile.length();
        System.out.println(fileLength);
        prg = new ProgressBar();


        Task<Void>task=new Task<Void>() {
            int i=1;
            @Override
            protected Void call() throws Exception {
                while (true) {
                    byte[] buffer = new byte[1];
//                    System.out.println(i);
                    int read = fis.read(buffer);
                    if(read==-1)break;
                    fos.write(buffer, 0,read);
//                    double progress = buffer.length*100 /(double) fileLength;
//                    updateProgress(i, sourceFile.length());

                    System.out.println(i);
                    if(i==10)break;
                    ++i;

                }
                return null;
            }
        };new Thread(task).start();

        prg.progressProperty().bind(task.progressProperty());


        fos.close();


    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        btnCopy.setDisable(true);

        lblSelectFileDestination.setText("No Such File or Directory");
        lblSelectFileSource.setText("No Such File or Directory");

    }

    @FXML
    void btnSelectFileDestinationOnAction(ActionEvent event) throws IOException {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select Destination to save the file");
        destinationDirectory = directoryChooser.showDialog(btnCopy.getScene().getWindow());

        if (destinationDirectory == null) {
            return;
        }
        System.out.println(destinationDirectory);
        newFile = new File(destinationDirectory, sourceFile.getName());
        newFile.createNewFile();
        fos = new FileOutputStream(newFile);
        lblSelectFileDestination.setText(newFile.toString());

        if (Objects.equals(destinationDirectory, sourceFile.getParentFile().toString())) {
            lblSelectFileDestination.setText("Same folder selected please select seperated folder");
            return;
        }
        btnCopy.setDisable(false);




    }

    @FXML
    void btnSelectFileSourceOnAction(ActionEvent event) throws IOException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select File to Copy");
        sourceFile = fileChooser.showOpenDialog(btnCopy.getScene().getWindow());

        if (sourceFile == null) {
            return;
        }
        lblSelectFileSource.setText(sourceFile.toString());

        fis = new FileInputStream(sourceFile);
    }

}
