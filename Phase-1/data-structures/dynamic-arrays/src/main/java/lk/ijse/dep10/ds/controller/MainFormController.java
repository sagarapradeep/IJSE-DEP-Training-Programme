package lk.ijse.dep10.ds.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import lk.ijse.dep10.ds.util.DynamicArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MainFormController {

    private DynamicArray numbers = new DynamicArray();

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnContains;

    @FXML
    private Button btnPrint;

    @FXML
    private Button btnPrintAll;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSize;

    @FXML
    private TextField txtField;

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String value = txtField.getText();
        numbers.add(value);
        txtField.clear();
        txtField.requestFocus();

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        numbers.clear();

    }

    @FXML
    void btnContainsOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog();
        prompt.setHeaderText("Enter value");
        Optional<String> optInput = prompt.showAndWait();           //wrap up using Optional
        if(optInput.isEmpty()||optInput.get().isBlank()) return;

        String input = optInput.get();
        System.out.println(numbers.contains(input));

    }

    @FXML
    void btnPrintAllOnAction(ActionEvent event) {
        System.out.println(numbers);

    }

    @FXML
    void btnPrintOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog();
        prompt.setHeaderText("Enter index");
        Optional<String> optInput = prompt.showAndWait();           //wrap up using Optional
        if(optInput.isEmpty()||optInput.get().isBlank()) return;

        int index = Integer.parseInt(optInput.get());
        System.out.println(numbers.get(index));

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        TextInputDialog prompt = new TextInputDialog();
        prompt.setHeaderText("Enter object to remove");
        Optional<String> optInput = prompt.showAndWait();           //wrap up using Optional
        if(optInput.isEmpty()||optInput.get().isBlank()) {

            return;
        }

        String input = optInput.get();
//        if(!numbers.contains(Integer.parseInt(input))){
//            System.out.println("Element not in the list");
//            return;
//        }
        numbers.remove(input);


    }

    @FXML
    void btnSizeOnAction(ActionEvent event) {
        System.out.println("Size: " + numbers.size());

    }

    @FXML
    void txtFielsOnAction(ActionEvent event) {

    }

}
