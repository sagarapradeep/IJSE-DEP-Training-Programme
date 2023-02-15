package lk.ijse.dep10.Controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import lk.ijse.dep10.model.Student;

import java.util.Optional;

public class ListViewSceneController {

    public Label lblSelectedNames;
    public Button btnSave;
    public Button btnDelete;
    public ListView<Student> lstStudent;
    public Button btnNew;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtId;
    @FXML
    private Button btnAdd;

    @FXML
    private Button btnRemove;
    @FXML
    private ListView<String> lstNames;
    @FXML
    private TextField txtInput;


    public void initialize() {
        lstNames.getSelectionModel().selectedItemProperty().addListener((value, previous, current) -> {
            if (current == null) {
                lblSelectedNames.setText("No name has been selected");
                btnRemove.setDisable(true);
                return;
            }
            lblSelectedNames.setText("Selected Name: " + current);
            btnRemove.setDisable(false);
        });

        lstStudent.getSelectionModel().selectedItemProperty().addListener((value,previous,current)->{
            if (current==null){
                btnDelete.setDisable(true);

                return;
            }
            btnDelete.setDisable(false);
            txtId.setText(current.id);
            txtName.setText(current.name);
            txtAddress.setText(current.address);
            txtId.setDisable(true);
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String input = txtInput.getText();
        if (input.isEmpty()) {
            txtInput.selectAll();
            txtInput.requestFocus();
            return;
        }
        ObservableList<String> names = lstNames.getItems();
        names.add(input.strip());
        txtInput.clear();
        txtInput.requestFocus();
        lstNames.getSelectionModel().clearSelection();
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        String selectedName = lstNames.getSelectionModel().getSelectedItem();
        Alert confirmMsg = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete " + selectedName,
                ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> optButton = confirmMsg.showAndWait();
        if (optButton.isEmpty() || (optButton.get() == ButtonType.NO)) return;

        ObservableList<String> names = lstNames.getItems();
        names.remove(lstNames.getSelectionModel().getSelectedIndex());

        lstNames.getSelectionModel().clearSelection();
    }

    public void btnSaveOnAction(ActionEvent event) {
        boolean isValid = true;
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        txtId.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");
        if (address.isBlank() || address.length() < 3) {
            txtAddress.getStyleClass().add("invalid");
            txtAddress.selectAll();
            txtAddress.requestFocus();
            isValid = false;
        }
        if (name.isBlank()) {

            txtName.getStyleClass().add("invalid");
            txtName.selectAll();
            txtName.requestFocus();
            isValid = false;
        }


        if (id.isBlank() || id.charAt(0) != 'S' || id.substring(1).length() < 3 ||
                !isNumber(id.substring(1))) {
            txtId.getStyleClass().add("invalid");
            txtId.selectAll();
            txtId.requestFocus();
            isValid = false;
        }
        if (!isValid) return;


        ObservableList<Student> studentList = lstStudent.getItems();
        if (lstStudent.getSelectionModel().getSelectedIndex()== -1){ // nothing has been selected

            for (Student student1 : studentList) {
                if (student1.id.equals(id)){
                    txtId.getStyleClass().add("invalid");
                    txtId.selectAll();
                    txtId.requestFocus();
                    return;
                }
            }
            Student student=new Student(id,name,address);
            studentList.add(student);
        }else{
            Student selectedStudent=lstStudent.getSelectionModel().getSelectedItem();
            selectedStudent.name=name;
            selectedStudent.address=address;
        }
        btnNew.fire();
    }

    public void lstNamesOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE) ;
        btnRemove.fire();


    }



    private boolean isNumber(String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public void btnDeleteOnAction(ActionEvent event) {

        Student selectedStudent=lstStudent.getSelectionModel().getSelectedItem();
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,String.format("Are you sure to delete the student id:%s ?",selectedStudent.id),ButtonType.YES,ButtonType.NO);
        Optional<ButtonType> optButton = alert.showAndWait();
        if (optButton.isEmpty() || optButton.get() == ButtonType.NO) return;
        lstStudent.getItems().remove(selectedStudent);
        btnNew.fire();

    }

    public void btnNewOnAction(ActionEvent event) {
        txtId.setDisable(false);
        txtName.setDisable(false);
        txtAddress.setDisable(false);
        btnSave.setDisable(false);
        txtId.requestFocus();

        txtId.clear();
        txtName.clear();
        txtAddress.clear();

        txtId.getStyleClass().remove("invalid");
        txtName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");
    }
    public void txtOnAction(ActionEvent event) {
        btnSave.fire();
    }
    public void lstStudentOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode()==KeyCode.DELETE){
            btnDelete.fire();
        }
    }
}
