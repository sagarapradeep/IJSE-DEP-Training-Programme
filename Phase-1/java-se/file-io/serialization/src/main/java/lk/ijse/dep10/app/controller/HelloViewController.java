package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.dep10.app.model.Student;

import java.io.*;

public class HelloViewController {

    @FXML
    private Button btnSave;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    private File homeDir = new File(System.getProperty("user.home"));
    private File desktopDir = new File(homeDir, "Desktop");
    private File studentFile = new File(desktopDir, "student.dep");

    public void initialize() {
        if(!studentFile.exists())return;

        try {
            FileInputStream fis = new FileInputStream(studentFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Student student = (Student) ois.readObject();

            txtAddress.setText(student.address);
            txtName.setText(student.name);
            txtID.setText(student.id);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Student newStudent = new Student(txtID.getText(), txtName.getText(), txtAddress.getText());

        File homeDir = new File(System.getProperty("user.home"));
        File desktopDir = new File(homeDir, "Desktop");
        File studentFile = new File(desktopDir, "student.dep");

        try {
            FileOutputStream fos = new FileOutputStream(studentFile);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(newStudent);


            oos.close();

        } catch (IOException e) {
            throw new RuntimeException(e);

        }


    }

}
