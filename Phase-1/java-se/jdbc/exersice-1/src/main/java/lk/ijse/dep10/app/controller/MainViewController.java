package lk.ijse.dep10.app.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep10.app.controller.util.Student;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;

public class MainViewController {

    public AnchorPane root;
    @FXML
    private Button btnNewStudent;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnSave;

    @FXML
    private ComboBox<String> cmbGender;

    @FXML
    private DatePicker dtDateOfBirth;

    @FXML
    private TableView<Student> tblSummary;

    @FXML
    private TextField txtAddress;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtLastName;

    /*user defined values*/
    boolean isFirstNameValid;
    boolean isLastNameValid;
    boolean isAddressValid;
    boolean isDoBValid;
    boolean isGenderSelected;


    public void initialize() {
        /*create txt ID disable*/
        txtId.setDisable(true);


        /*table initalize*/
        tblSummary.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblSummary.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblSummary.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblSummary.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblSummary.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblSummary.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("dob"));

        /*set combo box values*/
        cmbGender.getItems().add("Male");
        cmbGender.getItems().add("Female");

        /*Read values form database*/
        readValuesFromDataBase();

        /*fire new student button when starts*/
        btnNewStudent.fire();




        /*fist name validation*/
        txtFirstName.textProperty().addListener((value, previous, current) -> {
            txtFirstName.getStyleClass().remove("invalid");
            if (!isTextValid(current)) {
                txtFirstName.getStyleClass().add("invalid");
                return;
            }
            isFirstNameValid = true;


        });

        txtLastName.textProperty().addListener((value, previous, current) -> {
            txtLastName.getStyleClass().remove("invalid");
            if (!isTextValid(current)) {
                txtLastName.getStyleClass().add("invalid");
                return;
            }
            isLastNameValid = true;

        });

        txtAddress.textProperty().addListener((value,previous,current)->{
            txtAddress.getStyleClass().remove("invalid");
            if (!isTextValid(current)) {
                txtAddress.getStyleClass().add("invalid");
                return;
            }
            isAddressValid = true;
        });

        dtDateOfBirth.valueProperty().addListener((value,previous,current)->{
            if(dtDateOfBirth.getValue()==null)return;
            dtDateOfBirth.getStyleClass().remove("invalid");
            if (!isDoBValid(current)) {
                dtDateOfBirth.getStyleClass().add("invalid");
                return;
            }
            isDoBValid = true;
        });

        cmbGender.valueProperty().addListener((value,previous,current)->{
            if(cmbGender.getValue()==null)return;
            cmbGender.getStyleClass().remove("invalid");
            if (cmbGender.getValue().isEmpty()) {
                cmbGender.getStyleClass().add("invalid");
            }
            isGenderSelected = true;
        });

        /*Set listner to selection property*/
        tblSummary.getSelectionModel().selectedItemProperty().addListener((value,previous,current)->{
            txtId.setText(current.getId() + "");
            txtFirstName.setText(current.getFirstName());
            txtLastName.setText(current.getLastName());
            txtAddress.setText(current.getAddress());
            cmbGender.setValue(current.getGender());

            dtDateOfBirth.setValue(current.getDob());


        });



    }

    private void readValuesFromDataBase() {
        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://dep10.lk:3306/dep10_hellodb", "root", "mysql");

            String sql = "SELECT *FROM  Student ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String address = resultSet.getString(4);
                String gender = resultSet.getString(5);
                Date dob = resultSet.getDate(6);

                Student student = new Student(id, firstName, lastName, address, gender, dob);
                ObservableList<Student> students=tblSummary.getItems();
                students.add(student);

            }
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load data from data base").showAndWait();
            Platform.exit();
        }
    }

    private boolean isDoBValid(LocalDate current) {
        String year = current.getYear()+"";

        return year.matches("(200[0-9])|(19(8|9)[0-9])");
    }

    private boolean isTextValid(String name) {
        return name.matches("[A-Za-z]{5,}");
    }

    @FXML
    void btnNewStudentOnAction(ActionEvent event) {
        isFirstNameValid = false;
        isLastNameValid = false;
        isAddressValid = false;
        isDoBValid = false;
        isGenderSelected = false;
//


        txtFirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
        cmbGender.setValue(null);

        dtDateOfBirth.setValue(null);

        txtFirstName.requestFocus();
        txtFirstName.getStyleClass().remove("invalid");
        txtLastName.getStyleClass().remove("invalid");
        txtAddress.getStyleClass().remove("invalid");
        cmbGender.getStyleClass().remove("invalid");
        dtDateOfBirth.getStyleClass().remove("invalid");



        generateNewId();

    }

    private void generateNewId() {
        ObservableList<Student> students = tblSummary.getItems();
        if (students.isEmpty()) {
            txtId.setText("0");
            return;
        }
        int newId = students.get(students.size() - 1).getId() + 1;
        txtId.setText(Integer.toString(newId));

    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        if (tblSummary.getSelectionModel().getSelectedItem() == null) return;

        Student selectedStudent = tblSummary.getSelectionModel().getSelectedItem();

        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://dep10.lk:3306/dep10_hellodb", "root", "mysql");

            StringBuilder stringBuilder = new StringBuilder("DELETE FROM Student WHERE id=").append(selectedStudent.getId());

            Statement statement = connection.createStatement();
            statement.executeUpdate(stringBuilder.toString());

            ObservableList<Student> students = tblSummary.getItems();
            students.remove(selectedStudent);

//            tblSummary.getSelectionModel().clearSelection();
            connection.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        btnNewStudent.fire();


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        if (!isFirstNameValid) {
            txtFirstName.requestFocus();
            return;
        } else if (!isLastNameValid) {
            txtLastName.requestFocus();
            return;
        } else if (!isAddressValid) {
            txtAddress.requestFocus();
            return;
        } else if (cmbGender.getSelectionModel().isEmpty()) {
            cmbGender.requestFocus();
            return;
        } else if (dtDateOfBirth.getValue() == null||!isDoBValid) {
            dtDateOfBirth.requestFocus();
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        String firstName = txtFirstName.getText();
        String lastName = txtLastName.getText();
        String address = txtAddress.getText();
        String gender = cmbGender.getValue();
        Date dob = Date.valueOf(dtDateOfBirth.getValue());

        if (tblSummary.getSelectionModel().getSelectedItem() != null) {
            try {
                Connection connection = DriverManager.getConnection
                        ("jdbc:mysql://dep10.lk:3306/dep10_hellodb", "root", "mysql");

                StringBuilder stringBuilder = new StringBuilder("UPDATE Student SET first_name=")
                        .append("'"+firstName+"'")
                        .append(",last_name=")
                        .append("'"+lastName+"'")
                        .append(",address=")
                        .append("'"+address+"'")
                        .append(",gender=")
                        .append("'"+gender+"'")
                        .append(",dob=")
                        .append("'"+dob+"'")
                        .append(" WHERE id=")
                        .append(id);

                System.out.println(stringBuilder.toString());
                Statement statement = connection.createStatement();
                statement.executeUpdate(stringBuilder.toString());

                connection.close();





            } catch (SQLException e) {
                e.printStackTrace();
            }

            btnNewStudent.fire();
            return;
        }


        Student newStudent = new Student(id, firstName, lastName, address, gender, dob);


        try {
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://dep10.lk:3306/dep10_hellodb", "root", "mysql");
            String sql = "INSERT INTO Student (id,first_name,last_name,address,gender,dob)VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, address);
            preparedStatement.setString(5, gender);
            preparedStatement.setDate(6, dob);

            preparedStatement.executeUpdate();
            tblSummary.getItems().add(newStudent);

            connection.close();



        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to save to data base re  try!");

        }
        btnNewStudent.fire();


    }

    @FXML
    void cmbGenderOnAction(ActionEvent event) {
        dtDateOfBirth.requestFocus();

    }

    @FXML
    void dtDateOfBirthOnAction(ActionEvent event) {
        btnSave.requestFocus();

    }

    @FXML
    void txtAddressOnAction(ActionEvent event) {
        cmbGender.requestFocus();

    }

    @FXML
    void txtFirstNameOnAction(ActionEvent event) {
        txtLastName.requestFocus();

    }

    @FXML
    void txtLastNameOnAction(ActionEvent event) {
        txtAddress.requestFocus();

    }

}
