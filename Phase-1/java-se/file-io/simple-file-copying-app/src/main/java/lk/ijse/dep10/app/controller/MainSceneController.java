package lk.ijse.dep10.app.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;

public class MainSceneController {

    public TextField txtSource;
    public TextField txtDestination;
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
    private ProgressBar prg;







    private File sourceDirectory;
    private File destinationDirectory;


    public void initialize() {
        btnReset.fire();

        txtSource.setText("No Such File or Directory");
        txtDestination.setText("No Such File or Directory");
        btnCopy.setDisable(true);

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        btnCopy.setDisable(true);
        btnSelectFileDestination.setDisable(true);

        txtDestination.setText("No Such File or Directory");
        txtSource.setText("No Such File or Directory");

    }

    @FXML
    void btnSelectFileDestinationOnAction(ActionEvent event) throws IOException {
        /*create directory chooser for destination*/
        DirectoryChooser desChooser = new DirectoryChooser();
        desChooser.setTitle("Select Copy Directory");
        destinationDirectory=desChooser.showDialog(btnCopy.getScene().getWindow());
        if(!destinationDirectory.exists()) return;

        txtDestination.setText(destinationDirectory.toString());
        btnCopy.setDisable(false);


    }

    @FXML
    void btnSelectFileSourceOnAction(ActionEvent event) throws IOException {
        JFileChooser sourceChooser = new JFileChooser();
        sourceChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        sourceChooser.setDialogTitle("Select file or Directory to copy");
        sourceChooser.showOpenDialog(null);
        sourceDirectory = sourceChooser.getSelectedFile();


        if(sourceDirectory==null)return;
        txtSource.setText(sourceDirectory.toString());


        btnSelectFileDestination.setDisable(false);




    }

    @FXML
    void btnCopyOnAction(ActionEvent event) throws IOException {
        if((new File(destinationDirectory,sourceDirectory.getName())).exists()){
            Optional<ButtonType> optionalButtonType = new Alert(Alert.
                    AlertType.CONFIRMATION, "File already exists. Do you wanna to replace it?",
                    ButtonType.NO, ButtonType.YES).showAndWait();
            if((optionalButtonType.get()==ButtonType.NO)||optionalButtonType.isEmpty()) {
                btnReset.fire();
                return;
            }
        }

        dirCopy(sourceDirectory, destinationDirectory);
        new Alert(Alert.AlertType.CONFIRMATION, "All Files copied!").showAndWait();

        btnReset.fire();


    }

    void dirCopy(File source, File destination) throws IOException {
        if (source.isDirectory()) {
            File newFile = new File(destination, source.getName());
            if (!newFile.exists()) {
                newFile.mkdir();
            }
            File[] filesInSource = source.listFiles();
            for (File file : filesInSource) {
                dirCopy(file, newFile);

            }

        }

        else {
            fileCopy(source,destination);

        }


    }

    void fileCopy(File source, File destination) throws IOException {       //if file copy using this method

        Task<Void>task=new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                File copiedFile = new File(destination, source.getName());
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(copiedFile);
                double write=0.0;

                while (true) {
                    byte[] buffer = new byte[1024*1024*10];
                    int read = fis.read(buffer);
                    if(read ==-1)break;
                    fos.write(buffer, 0, read);

                    write+=read;
                    System.out.println("Write: "+write);
                    int percentage = (int)(write * 100 / sourceDirectory.length());

                    updateProgress(write, sourceDirectory.length());
                    updateMessage(String.format("%d%s", percentage, "%"));


                }
                fis.close();
                fos.close();
                return null;
            }
        };
        new Thread(task).start();
        prg.progressProperty().bind(task.progressProperty());
        lblProgressBar.textProperty().bind(task.messageProperty());

        task.setOnSucceeded(workerStateEvent -> {
            prg.progressProperty().unbind();
            lblProgressBar.textProperty().unbind();
            prg.setProgress(0);
            lblProgressBar.setText("0%");
        });

    }





}
