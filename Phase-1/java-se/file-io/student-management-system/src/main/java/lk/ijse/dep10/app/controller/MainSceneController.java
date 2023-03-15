package lk.ijse.dep10.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep10.app.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class MainSceneController implements Serializable{

    public AnchorPane root;
    public Label lblTitle;
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnNew;

    @FXML
    private Button btnSave;

    @FXML
    private TableView<Student> tblStudent;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;
    private boolean isSavePressed=true;

    private ArrayList<Student> studentSerializableArrayList = new ArrayList<Student>();

    private ArrayList<String> allStudentIdList = new ArrayList<>();

    private String newId=null;


    private File fileDesktop = new File(new File(System.getProperty("user.home")), "Desktop");

    {
        File studentFile = new File(fileDesktop, "Student.ijse");
        System.out.println("File initialized");

    }
    private File studentIdsFile = new File(fileDesktop, "StudentIds.ijse");




    public void initialize() {




        /*table scene*/
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        /*load from file to table*/
        copyFromFileToTable();

        /*load student Ids from file to id*/
        copyIdFromFileTable();

        /*Fire new button*/
        btnNew.fire();


        /*selection model*/
        tblStudent.getSelectionModel().
                selectedItemProperty().addListener((value,previous,current)->{
                    if(current==null)return;
                    Student selectedStudent = tblStudent.getSelectionModel().getSelectedItem();
                    txtName.setText(selectedStudent.getName());
                    txtAddress.setText(selectedStudent.getAddress());
                    txtId.setText(selectedStudent.getId());


                });



        /*Set listener to Name text filed to validate the name online*/
//        txtName.textProperty().addListener((value,previous,current)->{
//            txtName.getStyleClass().remove("invalid");
//            for (char element:current.toCharArray()) {
//
//                if(!Character.isLetter(element)&&!(Character.isSpaceChar(element))){
//                    txtName.getStyleClass().add("invalid");
//                    return;
//                }
//            }
//
//
//        });
//        txtName.setOnKeyPressed(keyEvent -> {
//            if (!txtName.getStyleClass().isEmpty()) {
//                return;
//            }
//            if (keyEvent.getCode() == KeyCode.ENTER) {
//                System.out.println("Enter Key pressed!");
//            }
//
//        });




    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        ObservableList<Student> studentList = tblStudent.getItems();
        Student selectedStudentForDelete = tblStudent.getSelectionModel().getSelectedItem();
        if (selectedStudentForDelete == null) {
            return;
        }

        Optional<ButtonType> optional = new Alert(Alert.AlertType.CONFIRMATION,
                "Do you want to remove this student", ButtonType.YES, ButtonType.NO).showAndWait();
        if (optional.isEmpty()||optional.get() == ButtonType.NO) return;

        studentList.remove(selectedStudentForDelete);
        studentSerializableArrayList.remove(selectedStudentForDelete);
        writeArrayObjectToFile();
        tblStudent.getSelectionModel().clearSelection();
        txtId.clear();
        isSavePressed=true;

        btnNew.fire();


    }

    @FXML
    void btnNewOnAction(ActionEvent event) {

        /*clear text fields*/
        txtAddress.clear();
        txtName.clear();

        /*Activate disabilities*/
//        txtAddress.setDisable(true);
//        btnDelete.setDisable(true);
//        btnSave.setDisable(true);
//        txtName.setDisable(false);

        /*generate new ID if only save pressed*/

        if (isSavePressed) {
            generateID();
        }




        isSavePressed=false;
        txtName.requestFocus();


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        Student student = new Student(txtId.getText(),          //save entered student
                txtName.getText(), txtAddress.getText());
        ObservableList<Student> studentList =  tblStudent.getItems();


        studentSerializableArrayList.add(student);
        studentList.add(student);
        allStudentIdList.add(newId);


        /*Save to desktop directory file location*/
        writeArrayObjectToFile();

        /*save student id to local file*/
        saveIdListToLocal();
        isSavePressed=true;

        btnNew.fire();


    }
    void copyFromFileToTable(){
        try {
            FileInputStream fis = new FileInputStream(studentFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            studentSerializableArrayList = (ArrayList<Student>) ois.readObject();

            ObservableList<Student> viewStudentList = tblStudent.getItems();

            for (Student student : studentSerializableArrayList) {
                viewStudentList.add(student);

            }

            ois.close();


        } catch (IOException | ClassNotFoundException e) {
            return;

        }
    }

    void writeArrayObjectToFile() {
        try {
            FileOutputStream fos = new FileOutputStream(studentFile);       //for students
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentSerializableArrayList);
            oos.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void generateID() {
        if(allStudentIdList.isEmpty()){
            txtId.setText("S001");
            allStudentIdList.add("S001");
            return;
        }



        int lastIdDigit = Integer.parseInt((allStudentIdList.get(
                allStudentIdList.size()-1)).substring(1))+1;
        newId = String.format("S%03d", (lastIdDigit));

        txtId.setText(newId);



    }

    void saveIdListToLocal() {
        try {
            FileOutputStream fodId = new FileOutputStream(studentIdsFile);      //for save IDs
            ObjectOutputStream oosId = new ObjectOutputStream(fodId);
            oosId.writeObject(allStudentIdList);
            oosId.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }

    void copyIdFromFileTable() {
        try {
            FileInputStream fis = new FileInputStream(studentIdsFile);
            ObjectInputStream ois = new ObjectInputStream(fis);

            allStudentIdList = (ArrayList<String>) ois.readObject();

            ois.close();


        } catch (IOException | ClassNotFoundException e) {
            return;

        }

    }


}
