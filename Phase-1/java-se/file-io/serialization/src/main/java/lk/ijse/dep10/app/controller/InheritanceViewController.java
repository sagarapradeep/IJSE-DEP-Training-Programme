package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lk.ijse.dep10.app.model.inherit1.D;

import java.io.*;

public class InheritanceViewController {

    @FXML
    private Button btnDeSerializationD;

    @FXML
    private Button btnSerializationD;

    private File file = new File("database.db");


    @FXML
    void btnDeSerializationDOnAction(ActionEvent event) {

        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            D dInstance = (D) ois.readObject();
            System.out.println(dInstance);

            ois.close();


            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void btnSerializationDOnAction(ActionEvent event) {
        D dInheritance = new D(50, 60, 70, 80);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(dInheritance);
            oos.close();
            System.out.println("Serialization Done!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
