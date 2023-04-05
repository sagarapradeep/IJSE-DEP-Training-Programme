package lk.ijse.dep10.assignment.controller;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.dep10.assignment.db.DBConnection;
import lk.ijse.dep10.assignment.model.Student;
import lk.ijse.dep10.assignment.model.util.Gender;

import java.sql.*;
import java.time.LocalDate;

public class StudentViewController {

    public Button btnDeleteStudent;
    public Button btnNewStudent;
    public Button btnSaveStudent;
    public RadioButton rdFemale;
    public RadioButton rdMale;
    public TableView<Student> tblStudents;
    public ToggleGroup tglGender;
    public TextField txtAddress;
    public DatePicker txtDOB;
    public TextField txtFirstName;
    public TextField txtId;
    public TextField txtLastName;
    public AnchorPane root;
    public Label lblId;
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblAddress;
    public Label lblDOB;
    public TextField txtSearch;


    public void initialize() {
        lblId.setLabelFor(txtId);
        lblFirstName.setLabelFor(txtFirstName);
        lblLastName.setLabelFor(txtLastName);
        lblAddress.setLabelFor(txtAddress);
        lblDOB.setLabelFor(txtDOB);

        btnDeleteStudent.setDisable(true);

        loadAllStudents();

        /*add listner to search text*/
        txtSearch.textProperty().addListener((ov,previous,current)->{
            Connection connection = DBConnection.getInstance().getConnection();
            try {
                Statement statement = connection.createStatement();
//                String sql = "SELECT *FROM Student WHERE first_name LIKE '%1$s'OR second_name LIKE '%1$s'OR address LIKE '%1$s'";
//
//                sql = String.format(sql, "%" + current + "%");

                String sql = "SELECT *FROM Student WHERE first_name='Sagara'OR 1=1--'";

                sql = String.format(sql, txtSearch.getText());
                ResultSet resultSet = statement.executeQuery(sql);

                ObservableList<Student> studentsList = tblStudents.getItems();
                studentsList.clear();

                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String fistName = resultSet.getString(2);
                    String lastName = resultSet.getString(3);
                    String address = resultSet.getString(4);
                    Gender gender = Gender.valueOf(resultSet.getString(5));
                    LocalDate dob = resultSet.getDate(6).toLocalDate();

                    studentsList.add(new Student(id, fistName, lastName, address, gender, dob));

                }


            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }


        });

        /* Setup keyboard shortcuts */
        Platform.runLater(() -> {
            root.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_ANY), () -> btnNewStudent.fire());
            root.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_ANY), () -> btnSaveStudent.fire());
            root.getScene().getAccelerators().put(new KeyCodeCombination(KeyCode.F1), () -> tblStudents.requestFocus());
        });


        /*Column mapping*/
        tblStudents.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblStudents.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tblStudents.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tblStudents.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblStudents.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("gender"));
        tblStudents.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));


        /*set listner to table*/
        tblStudents.getSelectionModel().selectedItemProperty().addListener((ov, previous, current) -> {
            btnDeleteStudent.setDisable(current == null);
            if (current == null) return;
            txtId.setText(String.valueOf(current.getId()));
            txtFirstName.setText(current.getFirstName());
            txtLastName.setText(current.getLastName());
            txtAddress.setText(current.getAddress());
            tglGender.selectToggle(current.getGender() == Gender.MALE ? rdMale : rdFemale);

            txtDOB.setValue(current.getDateOfBirth());

        });


    }

    private void loadAllStudents() {
        try {
            Connection connection = DBConnection.getInstance().getConnection();

            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT *FROM Student");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("second_name");
                String address = resultSet.getString("address");
                Gender gender = Gender.valueOf(resultSet.getString("gender"));
                Date dob = resultSet.getDate("dob");

                Student student = new Student(id, firstName, lastName, address, gender, dob.toLocalDate());
                tblStudents.getItems().add(student);

            }

            /*--------------------------------------------------------*/

//            Platform.runLater(() -> btnNewStudent.fire());
            /*can replace with*/
            Platform.runLater(btnNewStudent::fire);
            /*----------------------------------------------*/

        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to load data from data base").showAndWait();
            Platform.exit();
        }
    }


    public void btnDeleteStudentOnAction(ActionEvent event) {
        Connection connection = null;
        try {
            connection = DBConnection.getInstance().getConnection();
            Statement stm = connection.createStatement();
            String sql = "DELETE FROM Student WHERE id=%d ";
            sql = String.format(sql, tblStudents.getSelectionModel().getSelectedItem().getId());
            stm.executeUpdate(sql);



        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Failed to delete the selected Student try again");
        }
        tblStudents.getItems().remove(tblStudents.getSelectionModel().getSelectedItem());
        if(tblStudents.getItems().isEmpty()) btnNewStudent.fire();
    }


    public void btnNewStudentOnAction(ActionEvent event) {

        ObservableList<Student> studentList = tblStudents.getItems();
        int newId = studentList.isEmpty() ? 0 : (studentList.get(studentList.size() - 1).getId() + 1);

        txtId.setText(String.valueOf(newId));
        txtFirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
        txtDOB.setValue(null);
        tglGender.selectToggle(null);
        tblStudents.getSelectionModel().clearSelection();

        txtFirstName.requestFocus();
    }


    public void btnSaveStudentOnAction(ActionEvent event) {
        if (!isDataValid()) return;

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            Student student = new Student(Integer.parseInt(txtId.getText()),
                    txtFirstName.getText(), txtLastName.getText(), txtAddress.getText(),
                    tglGender.getSelectedToggle() == rdMale ? Gender.MALE : Gender.FEMALE, txtDOB.getValue());
            Student selectedStudent = tblStudents.getSelectionModel().getSelectedItem();

            if (selectedStudent == null) {
                String sql = "INSERT INTO Student VALUES (%d,'%s','%s','%s','%s','%s')";
                sql = String.format(sql, student.getId(), student.getFirstName(), student.getLastName(),
                        student.getAddress(), student.getGender(), student.getDateOfBirth());
                statement.executeUpdate(sql);
                tblStudents.getItems().add(student);

            }else {
                String sql = "UPDATE Student SET first_name='%s', second_name='%s', address='%s',gender='%s',dob='%s'";
                sql = String.format(sql, selectedStudent.getId(),
                        selectedStudent.getFirstName(), selectedStudent.getLastName(),
                        selectedStudent.getAddress(), selectedStudent.getGender(), selectedStudent.getDateOfBirth());
                statement.executeUpdate(sql);

                ObservableList<Student> students = tblStudents.getItems();
                int index = students.indexOf(selectedStudent);
                students.set(index, selectedStudent);
                tblStudents.refresh();
            }






            btnNewStudent.fire();


        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "failed to save the student try again").showAndWait();

        }


    }

    private boolean isDataValid() {

        boolean isDataValid = true;

        for (Node node : new Node[]{txtFirstName, txtLastName, txtAddress, rdMale, rdFemale, txtDOB}) {
            node.getStyleClass().remove("invalid");
        }


        String firstName = txtFirstName.getText();
        String lastname = txtLastName.getText();
        String address = txtAddress.getText();
        Toggle selectedToggle = tglGender.getSelectedToggle();
        LocalDate dob = txtDOB.getValue();


        if (dob == null || !(dob.isAfter(LocalDate.of(1980, 1, 1))
                && dob.isBefore(LocalDate.of(2010, 1, 1)))) {
            txtDOB.requestFocus();
            txtDOB.getStyleClass().add("invalid");
            isDataValid = false;
        }

        if (selectedToggle == null) {
            isDataValid = false;
            rdMale.requestFocus();

        }

        if (address.strip().length() < 3) {
            isDataValid = false;
            txtAddress.getStyleClass().add("invalid");
            txtAddress.requestFocus();
            txtAddress.selectAll();
        }

        if (!lastname.matches("[A-za-z]+")) {
            isDataValid = false;
            txtLastName.getStyleClass().add("invalid");
            txtLastName.requestFocus();
            txtLastName.selectAll();
        }

        if (!firstName.matches("[A-za-z]+")) {
            isDataValid = false;
            txtFirstName.getStyleClass().add("invalid");
            txtFirstName.requestFocus();
            txtFirstName.selectAll();
        }
        return isDataValid;

    }

    public void tblStudentsOnKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.DELETE) {
            btnDeleteStudent.fire();
        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
    }


}
