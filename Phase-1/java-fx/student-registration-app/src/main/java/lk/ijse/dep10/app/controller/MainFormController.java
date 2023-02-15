package lk.ijse.dep10.app.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import lk.ijse.dep10.app.model.StudentDetails;

import java.util.ArrayList;

public class MainFormController {
    public Button btnAddContact;
    public Button btnAddStudent;
    public ListView<String> lstContactList;
    public Button btnRemove;
    public ListView<String> lstModules;
    public Button btnAddModules;
    public Button btnRemoveModules;
    public ListView <String>lstSelectedModules;
    public Button btnSave;
    public ListView<StudentDetails> lstSummary;
    public TextField txtId;
    public TextField txtName;
    public TextField txtContact;

    public int studentID=1;
    public boolean isAdd=false;
    public int index;
    public Button btnDelete;

    public void initialize() {
        txtName.setDisable(true);
        txtContact.setDisable(true);
        txtId.setDisable(true);

        lstModules.setDisable(true);
        lstContactList.setDisable(true);
        lstSummary.setDisable(true);
        lstSelectedModules.setDisable(true);

        btnAddContact.setDisable(true);
        btnAddModules.setDisable(true);
        btnRemove.setDisable(true);
        btnSave.setDisable(true);
        btnRemoveModules.setDisable(true);


        /*Set listner to contact numbers list view to edit them*/
        lstContactList.getSelectionModel().selectedItemProperty().addListener((value,previous,current)->{
            if (current == null) {
                btnRemove.setDisable(true);
                return;
            }
            btnRemove.setDisable(false);
            txtContact.setText(current);
            txtContact.requestFocus();

            index = lstContactList.getSelectionModel().getSelectedIndex();
            isAdd=true;
            lstContactList.getSelectionModel().clearSelection();

        });

        /*Set lisner to summary list to display student details summary*/
        lstSummary.getSelectionModel().selectedItemProperty().addListener((value,previous,current)->{
            if (current == null) {
                btnDelete.setDisable(true);
                return;
            }
            txtId.setText(current.id);
            txtName.setText(current.name);

            ObservableList<String> selectedContact = lstContactList.getItems();
            selectedContact.clear();
            selectedContact.addAll(current.contactNumbers);

            ObservableList<String> selectedModules = lstSelectedModules.getItems();
            selectedModules.clear();
            selectedModules.addAll(current.selectedModules);
        });


    }

    /*new Student Button*/
    public void btnAddOnAction(ActionEvent actionEvent) {

        txtName.clear();
        txtName.requestFocus();

        txtId.clear();
        txtContact.clear();
        ObservableList<String> contactNumber = lstContactList.getItems();
        contactNumber.clear();

        ObservableList<String> selectedModules = lstSelectedModules.getItems();
        selectedModules.clear();



        txtName.setDisable(false);
        txtContact.setDisable(false);
        btnAddContact.setDisable(false);
        btnSave.setDisable(false);
        btnAddModules.setDisable(false);
        lstSelectedModules.setDisable(false);
        lstModules.setDisable(false);
        

        txtId.setText(String.format("S%03d", studentID));       //id set

        txtName.getStyleClass().remove("invalid");
        txtContact.getStyleClass().remove("invalid");


        /*Set default modules*/
        ObservableList<String> defaultModules = lstModules.getItems();
        defaultModules.addAll("Java-Fundamentals", "OOP", "Java-FX", "Web Developing", "Mobile App Development", "Data Bases", "Data Structures");

    }

    /*Add Contact Button*/
    public void btnAddContactOnAction(ActionEvent actionEvent) {


        String contact = txtContact.getText();
        txtContact.getStyleClass().remove("invalid");
        if(!(contactValidation(contact))){
            txtContact.getStyleClass().add("invalid");
            txtContact.requestFocus();
            txtContact.selectAll();
            return;
        }
        ObservableList<String> contactList = lstContactList.getItems();     //add contact number to the list view


        if (isAdd) {
            contactList.remove(index);
            isAdd=false;
        }
        contactList.add(contact);
        txtContact.requestFocus();
        txtContact.clear();

        btnRemove.setDisable(false);        //activate remove button
        lstContactList.setDisable(false);
    }

    /*Contact remove */
    public void btnRemoveOnAction(ActionEvent actionEvent) {

        ObservableList<String> contactNumbers = lstContactList.getItems();
        if(contactNumbers.isEmpty()){
            btnRemove.setDisable(true);
            return;
        }
        contactNumbers.remove(lstContactList.getSelectionModel().getSelectedIndex());
        txtContact.requestFocus();
        txtContact.clear();



    }
    /*All details save button*/
    public void btnSaveOnAction(ActionEvent actionEvent) {
        lstSummary.setDisable(false);
        txtName.getStyleClass().remove("invalid");
        lstSelectedModules.getStyleClass().remove("invalid");

        String name = txtName.getText();        //create string variables
        String id=txtId.getText();

        txtName.setDisable(false);

        if(!contactListViewValidation()){
            txtContact.getStyleClass().add("invalid");
            txtContact.selectAll();
            txtContact.requestFocus();
            return;
        }

        if(!nameValidation(name)){
            txtName.getStyleClass().add("invalid");
            txtName.selectAll();
            txtName.requestFocus();
            return;
        }
        ObservableList<String> currentModules = lstSelectedModules.getItems();
        if (currentModules.size() < 3) {
            lstSelectedModules.getStyleClass().add("invalid");
            btnAddModules.requestFocus();
            return;
        }

        ArrayList<String> contactNumber = new ArrayList<>();
        ArrayList<String> selectedModules = new ArrayList<>();

        ObservableList<String> contatcNumbersList = lstContactList.getItems();
        ObservableList<String> selectedModuleList = lstSelectedModules.getItems();

//        for (int i = 0; i < contatcNumbersList.size(); i++) {
//            contactNumber.add(contactNumber.get(i));
//        }
        contactNumber.addAll(contatcNumbersList);

        selectedModules.addAll(selectedModuleList);




        StudentDetails studentDetails = new StudentDetails(id, name,contactNumber,selectedModules);
        ObservableList<StudentDetails> summary = lstSummary.getItems();
        summary.add(studentDetails);




        txtName.clear();
        txtId.clear();
        txtContact.clear();
        ObservableList<String>selectedModule=lstSelectedModules.getItems();
        ObservableList<String>contactList=lstContactList.getItems();

        selectedModule.clear();
        contactList.clear();

        ++studentID;
        btnAddStudent.fire();


    }


    /*Add default modules to selected module*/
    public void btnAddModulesOnAction(ActionEvent actionEvent) {
        ObservableList<String> defaultModules = lstModules.getItems();
        ObservableList<String> selectedModules = lstSelectedModules.getItems();

        selectedModules.add(lstModules.getSelectionModel().getSelectedItem());
        defaultModules.remove(lstModules.getSelectionModel().getSelectedIndex());

        btnRemoveModules.setDisable(false);




    }

    public void btnRemoveModulesOnAction(ActionEvent actionEvent) {
        ObservableList<String> defaultModules = lstModules.getItems();
        ObservableList<String> selectedModules = lstSelectedModules.getItems();

        defaultModules.add(lstSelectedModules.getSelectionModel().getSelectedItem());
        selectedModules.remove(lstModules.getSelectionModel().getSelectedIndex());

    }


    /***************************************************************************************************/

    /*name Validations*/

    public boolean nameValidation(String name) {
        if(name.isEmpty()||name.isBlank())return false;
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i)==' ')continue;
            if(!Character.isLetter(name.charAt(i)))return false;
        }
        return true;
    }

    /*ID validation*/
    public boolean contactValidation(String number) {
        if((number.isBlank())||(number.isEmpty())||(number.charAt(3)!='-')||number.length()!=11)return false;

        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i)=='-')continue;
            else if (!Character.isDigit(number.charAt(i))) return false;
        }
        return true;
    }

    /*Contact Number List view validation*/

    public boolean contactListViewValidation() {
        ObservableList<String> contactList = lstContactList.getItems();
        return !contactList.isEmpty();

    }

    public void btnDeleteonAction(ActionEvent actionEvent) {
    }
}
