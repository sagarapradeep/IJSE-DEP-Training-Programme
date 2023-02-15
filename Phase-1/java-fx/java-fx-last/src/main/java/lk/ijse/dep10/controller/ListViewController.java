package lk.ijse.dep10.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep10.model.Student;

import java.util.Optional;

public class ListViewController {

    public Button btnDelete;
    public Button btnNew;
    public TextField txtID;
    public Button btnSave;
    public ListView <Student>lstStudents;
    public TextField txtName;
    public TextField txtAddress;


    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;

    @FXML
    private Label lblSelectednName;

    @FXML
    private ListView<String> lstNames;

    @FXML
    private TextField txtInput;


    public void initialize() {
        lstNames.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null) {
                lblSelectednName.setText("No name has been selected");
                btnRemove.setDisable(true);
                return;
            }

            lblSelectednName.setText("Selected Name: " + current);
            btnRemove.setDisable(false);
        });

        lstStudents.getSelectionModel().selectedItemProperty().addListener((value,previous,current)->{
            if (current == null) {
                btnDelete.setDisable(true);
                return;
            }
            btnDelete.setDisable(false);
            txtID.setText(current.id);
            txtName.setText(current.name);
            txtAddress.setText(current.address);

            txtID.setDisable(true);
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String input = txtInput.getText();
        if (input.isEmpty() || input.isBlank()) {
            txtInput.clear();
            txtInput.requestFocus();
            return;
        }

        ObservableList<String> names = lstNames.getItems();
        names.add(txtInput.getText().strip());

        txtInput.clear();
        txtInput.requestFocus();

    }


    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        String selectedName = lstNames.getSelectionModel().getSelectedItem();
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete " + selectedName,
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optButton = confirmMsg.showAndWait();
        if (optButton.isEmpty() || optButton.get() == ButtonType.NO) return;

        ObservableList<String> names = lstNames.getItems();
        names.remove(lstNames.getSelectionModel().getSelectedIndex());

        lstNames.getSelectionModel().clearSelection();

    }


    public void lstNamesOnKeyReleased(KeyEvent keyEvent) {
//        System.out.println(keyEvent.getCode());
        if (keyEvent.getCode() == KeyCode.DELETE) {
            btnRemove.fire();

        }
//        System.out.println("Working");
    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        btnSave.setDisable(false);
        txtAddress.setDisable(false);
        txtName.setDisable(false);
        txtID.setDisable(false);

        txtID.getStyleClass().remove("invalid");          //clear all style classes for id text Field
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");

        lstStudents.getSelectionModel().clearSelection();
        
        



        txtName.clear();
        txtAddress.clear();
        txtID.clear();

        txtID.requestFocus();

    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        boolean isValid=true;
        String id = txtID.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();

        txtID.getStyleClass().remove("invalid");          //clear all style classes for id text Field
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");



        /*Address validation*/
        if (address.isBlank() || address.length() < 4) {
            txtAddress.getStyleClass().add("invalid");
            txtAddress.requestFocus();
            txtAddress.selectAll();
            isValid=false;
        }

        /*Name validation*/
        if(name.isBlank()){
            txtName.getStyleClass().add("invalid");
            txtName.requestFocus();
            txtName.selectAll();
            isValid=false;
        }

        /*id validation*/
        if (id.isBlank() || id.charAt(0) != 'S' || id.substring(1).length() != 3 || !isNumber(id.substring(1))) {
            txtID.getStyleClass().add("invalid");
            txtID.selectAll();
            txtID.requestFocus();
            isValid=false;
        }

        if (!isValid)return;

        //data validation ok

        ObservableList<Student> studentList = lstStudents.getItems();   //create studentList Observable list connected with lstStudent list View
        //business validation

        if(lstStudents.getSelectionModel().getSelectedItem()==null)//no item seletced
        {
            for (Student student : studentList) {
                if (student.id.equals(id)) {
                    txtID.getStyleClass().add("invalid");
                    txtID.selectAll();
                    txtID.requestFocus();
                    return;
                }
            }
            Student student = new Student(id, name, address);

            studentList.add(student);

        }else{
            Student selectedStudent = lstStudents.getSelectionModel().getSelectedItem();
            selectedStudent.name=name;
            selectedStudent.address=address;
        }
        btnNew.fire();











    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

        Student selectedStudent = lstStudents.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,String.format("Are you sure to delete Student ID: %s",selectedStudent.id),ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> optButton = alert.showAndWait();
        if(optButton.isEmpty()||optButton.get()==ButtonType.NO) return;

        lstStudents.getItems().remove(selectedStudent);
        btnNew.fire();



    }

    public void txtOnAction(ActionEvent actionEvent) {
        btnSave.fire();
    }

    /*Id validation for digits*/
    private boolean isNumber(String id) {
        for (int i = 0; i < 3; i++) {
            if(!Character.isDigit(id.charAt(i)))return false;
        }
        return true;
    }

    public void lstStudentOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE) {
            btnDelete.fire();
        }
    }
}


