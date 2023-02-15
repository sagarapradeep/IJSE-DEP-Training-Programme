package lk.ijse.dep10.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import lk.ijse.dep10.model.StudentInfo;

public class ListViewExerciseController {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnForward;

    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ListView<String> lstContacts;

    @FXML
    private ListView<String> lstModules;

    @FXML
    private ListView<String> lstSelectedModules;

    @FXML
    private ListView<StudentInfo> lstStudent;

    @FXML
    private RadioButton rdoFemale;

    @FXML
    private RadioButton rdoMale;

    @FXML
    private TextField txtContact;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    public void initialize(){
       txtName.textProperty().addListener((value,previous,current)->{
           txtName.getStyleClass().remove("Invalid");
           char[] chars = current.toCharArray();
           for (char c : chars) {
               if (!(Character.isLetter(c) || Character.isSpaceChar(c))){
                   txtName.getStyleClass().add("invalid");
                   return;
               }
           }

       });

       txtContact.textProperty().addListener((value,previous,currentText)->{
           txtContact.getStyleClass().remove("invalid");

       });
    }


    @FXML
    void btnAddOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnForwardOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {
        txtId.setText(generateNewStudentId());
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtContact.setDisable(false);
        btnAdd.setDisable(false);
        btnForward.setDisable(false);
        btnBack.setDisable(false);
        btnSave.setDisable(false);
        rdoMale.setDisable(false);
        rdoFemale.setDisable(false);

        txtName.clear();
        txtContact.clear();
        rdoMale.getToggleGroup().selectToggle(null);


        ObservableList<String> moduleList = lstModules.getItems();
        moduleList.clear();
        moduleList.addAll("Object oriented programming","Programming Fundamentals",
                "Database Management System","Angular","React Js","Mongo DB","Cloud Native Applications");
        txtName.requestFocus();
        ObservableList<String> contactList = lstContacts.getItems();
        contactList.clear();

        ObservableList<String> selectedModuleList = lstSelectedModules.getItems();
        selectedModuleList.clear();
    }
    private String generateNewStudentId(){
        ObservableList<StudentInfo> studentList = lstStudent.getItems();
        if (studentList.isEmpty()) return "S001";
        String lastStudentId = studentList.get(studentList.size() - 1).id;
        int newId=Integer.parseInt(lastStudentId.substring(1)+1);
        return String .format("S%03d",newId);

    }
    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void lstContactsOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void lstModulesOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void lstSelectedModulesOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void lstStudentsOnKeyReleased(KeyEvent event) {

    }

    @FXML
    void txtContactOnAction(ActionEvent event) {

    }

}
