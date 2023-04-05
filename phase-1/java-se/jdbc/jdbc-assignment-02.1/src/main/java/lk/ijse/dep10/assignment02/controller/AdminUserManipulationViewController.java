package lk.ijse.dep10.assignment02.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.dep10.assignment02.db.DBConnection;
import lk.ijse.dep10.assignment02.util.DateAndTime;
import lk.ijse.dep10.assignment02.util.Role;
import lk.ijse.dep10.assignment02.util.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.BreakIterator;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AdminUserManipulationViewController {

    public Button btnNewUser;
    public Button btnBack;
    public Label lblLoggedUser;
    public Label lblDateAndTime;
    public String loggedUser;
    public Label lblMain5;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnSave;
    @FXML
    private TableView<User> tblSummary;
    @FXML
    private TextField txtFullName;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUserName;
    private BreakIterator time;

    public void initialize() {


        Platform.runLater(() -> btnNewUser.fire());

        DateAndTimeCounter();

        tblSummary.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("fullName"));
        tblSummary.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("userName"));
        tblSummary.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("password"));
        tblSummary.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("role"));

        tblSummary.getSelectionModel().selectedItemProperty().addListener((ov, previous, current) -> {
            if (current == null) {
                Platform.runLater(() -> txtUserName.setDisable(false));
                ;
                return;
            }
            txtUserName.setDisable(true);
            txtUserName.setText(current.getUserName());
            txtPassword.setText(current.getPassword());
            txtFullName.setText(current.getFullName());
        });


        loadAllData();
    }

    private void DateAndTimeCounter() {

        new Thread(()->{
            DateAndTime.setDateAndTime(lblDateAndTime);
        }).start();

    }

    private void loadAllData() {
        ObservableList<User> usersList = tblSummary.getItems();

        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT *FROM Users";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                User user = new User(resultSet.getString(2),
                        resultSet.getString(1),
                        resultSet.getString(3), Role.valueOf(resultSet.getString(4)));
                usersList.add(user);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void initData(String userName) {
        this.loggedUser = userName;
        lblLoggedUser.setText(userName);


    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {
        if (tblSummary.getSelectionModel().getSelectedItem() == null) {
            return;
        }

        User user = tblSummary.getSelectionModel().getSelectedItem();
        if (user.getRole() == Role.ADMIN) {
            new Alert(Alert.AlertType.ERROR, "Couldn't delete Admin").showAndWait();
            tblSummary.getSelectionModel().clearSelection();
            return;
        }
        String userName = user.getUserName();
        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM Users WHERE user_name='%s'";
            sql = String.format(sql, userName);

            statement.executeUpdate(sql);
            tblSummary.getItems().remove(user);
            tblSummary.getSelectionModel().clearSelection();
            tblSummary.refresh();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        btnNewUser.fire();

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        if (!isDataValid()) return;


        try {
            Connection connection = DBConnection.getInstance().getConnection();
            Statement statement = connection.createStatement();

            String fullName = txtFullName.getText();
            String userName = txtUserName.getText();
            String password = txtPassword.getText();
            User selectedUser = tblSummary.getSelectionModel().getSelectedItem();




            if (selectedUser != null) {
                selectedUser.setFullName(fullName);
                selectedUser.setPassword(password);
                String sql = "UPDATE Users SET full_name='%s',password='%s' WHERE user_name='%s'";
                sql = String.format(sql, fullName, password, userName);
                statement.executeUpdate(sql);
                ObservableList<User> userList = tblSummary.getItems();
                int selectedIndex = userList.indexOf(selectedUser);

                userList.set(selectedIndex, selectedUser);
                tblSummary.refresh();


            } else {
                String sql = "INSERT INTO Users VALUES ('%s','%s','%s','%s')";
                sql = String.format(sql, userName, fullName, password, Role.USER);
                statement.executeUpdate(sql);

                User user = new User(fullName, userName, password, Role.USER);
                tblSummary.getItems().add(user);

            }


            btnNewUser.fire();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean isDataValid() {
        boolean dataValid = true;

        if (txtPassword.getText().isBlank() || txtPassword.getText().isBlank() || txtPassword.getText().length() < 4) {
            dataValid = false;
            txtPassword.requestFocus();
            txtPassword.selectAll();
        }
        if (txtUserName.getText().isEmpty() || txtUserName.getText().isBlank() || txtUserName.getText().length() < 3) {
            dataValid = false;
            txtUserName.requestFocus();
            txtUserName.selectAll();
        }
        if (txtFullName.getText().isBlank() || txtFullName.getText().isEmpty() || txtFullName.getText().length() < 6) {
            dataValid = false;
            txtFullName.requestFocus();
            txtFullName.selectAll();
        }

        return dataValid;
    }

    @FXML
    void txtFullNameOnAction(ActionEvent event) {

    }

    @FXML
    void txtPasswordOnAction(ActionEvent event) {

    }

    @FXML
    void txtUserNameOnAction(ActionEvent event) {

    }

    public void btnNewUserOnAction(ActionEvent actionEvent) {
        txtUserName.setDisable(false);
        txtPassword.clear();
        txtUserName.clear();
        txtFullName.clear();
        txtFullName.requestFocus();

    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) btnBack.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/view/AdminView.fxml"));
            stage.setScene(new Scene(fxmlLoader.load()));
            AdminViewController ctrl = fxmlLoader.getController();
            ctrl.initData(loggedUser);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
