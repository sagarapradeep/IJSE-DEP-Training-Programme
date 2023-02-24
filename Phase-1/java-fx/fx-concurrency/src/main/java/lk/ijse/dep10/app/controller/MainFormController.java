package lk.ijse.dep10.app.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class MainFormController {

    @FXML
    private Button btnRun;

    @FXML
    private Label lblPrecentage;

    @FXML
    private ProgressBar prg;

    @FXML
    void btnRunOnAction(ActionEvent event) {
        Task<Void> task=new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                for (int i = 0; i <= 400000; i++) {

                    updateProgress(i, 400000);       //update progress property
                    updateMessage(String.format("%.2f",(i*100 / 400000.0))+"%");
                    if (i == 400000) {
                        updateMessage("Completed!");
                    }
                }


                return null;
            }
        };
        new Thread(task).start();

        lblPrecentage.textProperty().bind(task.messageProperty());

        prg.progressProperty().bind(task.progressProperty());       //bind progress bar progress property to task progress property
//        System.out.println("Ok");


//        lblPrecentage.setText(progress+"% complete");
//        prg.setProgress(progress);


    }

}
