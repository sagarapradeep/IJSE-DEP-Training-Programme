package lk.ijse.dep10.app.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import lk.ijse.dep10.app.model.transients.Employee;
import lk.ijse.dep10.app.model.transients.PersonalInfo;
import lk.ijse.dep10.app.model.transients.Status;

import java.io.*;
import java.util.ArrayList;

public class TransientViewController {

    public RadioButton rdoSingle;
    public RadioButton rdoMarried;
    public Button btnNew;
    public VBox vBoxSpouse;
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnEmpAdd;

    @FXML
    private Button btnEmpRemove;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnSpAdd;

    @FXML
    private Button btnSpRemove;

    @FXML
    private ListView<String> lstEmpContacts;

    @FXML
    private ListView<String> lstSpContacts;

    @FXML
    private ToggleGroup tdlStatus;

    @FXML
    private TableView<Employee> tblEmpDetails;

    @FXML
    private TextField txtEmpContact;

    @FXML
    private TextField txtEmpID;

    @FXML
    private TextField txtEmpName;

    @FXML
    private TextField txtSpContact;

    @FXML
    private TextField txtSpId;

    @FXML
    private TextField txtSpName;

    private File employeeDataBase = new File("employee-db.db");

    private ArrayList<Employee> employeeList = new ArrayList<>();

    public void initialize() {
        /*Column mapping*/

        tblEmpDetails.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmpDetails.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        tblEmpDetails.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("spouseName"));

        /*selection listners*/
        lstEmpContacts.getSelectionModel().selectedItemProperty().addListener((value,old,current)->{
            btnEmpRemove.setDisable(current == null);
        });

        lstSpContacts.getSelectionModel().selectedItemProperty().addListener((value,old,current)->{
            btnSpRemove.setDisable(current == null);
        });

        tblEmpDetails.getSelectionModel().selectedItemProperty().addListener((value,old,current)->{
            btnDelete.setDisable(current == null);
        });

        tdlStatus.selectedToggleProperty().addListener((ov,old,current)->{
            vBoxSpouse.setDisable(current != rdoMarried);

        });




        btnSpRemove.setDisable(true);
        btnEmpRemove.setDisable(true);
        btnDelete.setDisable(true);



    }

    public void btnNewOnAction(ActionEvent actionEvent) {
        /*clear text fields*/
        txtEmpID.clear();
        txtEmpContact.clear();
        txtEmpName.clear();
        txtSpId.clear();
        txtSpContact.clear();
        txtSpName.clear();


        /*Clear list boxes*/
        lstEmpContacts.getSelectionModel().clearSelection();
        lstSpContacts.getSelectionModel().clearSelection();

        /*Table selection clear*/
        tblEmpDetails.getSelectionModel().clearSelection();

        /*clear toggle group*/
        tdlStatus.selectToggle(null);

        /*get focus to ID*/
        txtEmpID.requestFocus();

    }

    @FXML
    void btnEmpAddOnAction(ActionEvent event) {
        String contact = txtEmpContact.getText();
        if(contact.isBlank()||lstEmpContacts.getItems().contains(contact)) return;
        lstEmpContacts.getItems().add(contact);
        txtEmpContact.requestFocus();

    }

    @FXML
    void btnEmpRemoveOnAction(ActionEvent event) {
        lstEmpContacts.getItems().remove(lstEmpContacts.getSelectionModel().getSelectedItem());
        if(lstEmpContacts.getItems().isEmpty())txtEmpContact.requestFocus();

    }

    @FXML
    void btnSpAddOnAction(ActionEvent event) {
        String contact = txtSpContact.getText();
        if(contact.isBlank()||lstSpContacts.getItems().contains(contact)) return;
        lstSpContacts.getItems().add(contact);
        txtSpContact.requestFocus();
        txtSpContact.clear();

    }

    @FXML
    void btnSpRemoveOnAction(ActionEvent event) {
        lstSpContacts.getItems().remove(lstSpContacts.getSelectionModel().getSelectedItem());
        if(lstSpContacts.getItems().isEmpty())txtSpContact.requestFocus();

    }

    @FXML
    void lstEmpContactsOnKeyReleased(KeyEvent event) {
        if(event.getCode()== KeyCode.DELETE)btnEmpRemove.fire();

    }

    @FXML
    void lstSpContactsOnKeyReleased(KeyEvent event) {
        if(event.getCode()== KeyCode.DELETE)btnSpRemove.fire();

    }

    @FXML
    void tblEmpDetailsOnKeyReleased(KeyEvent event) {
        if(event.getCode()== KeyCode.DELETE)btnDelete.fire();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if(!isValid())return;

        String  id=txtEmpID.getText();
        String name = txtEmpName.getText();
        ArrayList<String> employeeContacts = new ArrayList<>(lstEmpContacts.getItems());
        PersonalInfo employeeInfo = new PersonalInfo(name, employeeContacts);
        Status status = tdlStatus.getSelectedToggle() == rdoMarried ? Status.MARRIED : Status.SINGLE;
        PersonalInfo spouseInfo = null;

        if (status == Status.MARRIED) {
            String spouseName = txtSpName.getText();
            ArrayList<String> spouseContacts = new ArrayList<>(lstSpContacts.getItems());
            spouseInfo = new PersonalInfo(spouseName, spouseContacts);

        }

        Employee employee = new Employee(id, employeeInfo, spouseInfo, status);
        employeeList.add(employee);
        FileOutputStream fos = null;
        ObjectOutputStream oos= null;
        try {
            fos = new FileOutputStream(employeeDataBase);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(employeeList);
            oos.close();
            tblEmpDetails.getItems().add(employee);

        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to save employee").show();
            employeeList.remove(employee);

        }




    }

    private boolean isValid() {
        if (txtEmpID.getText().isEmpty()) {
            txtEmpID.requestFocus();
            return false;
        }else if (txtEmpName.getText().isEmpty()) {
            txtEmpName.requestFocus();
            return false;
        }else if (!(rdoMarried.isSelected()||rdoSingle.isSelected())) {
            tdlStatus.selectToggle(rdoSingle);
            return false;
        }else if (lstEmpContacts.getItems().isEmpty()) {
            txtEmpContact.requestFocus();
            return false;
        }

        if (rdoMarried.isSelected()) {
            if (txtSpId.getText().isEmpty()) {
                txtSpId.requestFocus();
                return false;
            }else if (txtSpName.getText().isEmpty()) {
                txtSpName.requestFocus();
                return false;
            }else if (lstSpContacts.getItems().isEmpty()) {
                txtSpContact.requestFocus();
                return false;
            }




        }
        return true;

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {


    }
}
