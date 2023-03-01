package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import lk.ijse.dep10.app.model.Customer;

import java.io.*;

public class SerialVersionUIDViewController {

    @FXML
    private Button btnDeSerialize;

    @FXML
    private Button btnSerialize;
    private File file = new File("customer.cu");


    @FXML
    void btnDeSerializeOnAction(ActionEvent event) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Customer c001 = (Customer) ois.readObject();
            c001.print();


            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to load the customer");
        }


    }

    @FXML
    void btnSerializeOnAction(ActionEvent event) {
        Customer customer = new Customer("C001", "Saman", "Kaduwela");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(customer);
            fos.close();
        } catch (Exception e) {

            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Fail to save the customer");
        }


    }

}
