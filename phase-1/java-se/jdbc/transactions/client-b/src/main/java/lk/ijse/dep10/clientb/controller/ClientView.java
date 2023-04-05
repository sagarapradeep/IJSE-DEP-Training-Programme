package lk.ijse.dep10.clientb.controller;

import com.github.javafaker.Faker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import lk.ijse.dep10.clientb.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientView {

    @FXML
    private Button btnAddNewRecords;

    @FXML
    private Button btnCommitTransaction;

    @FXML
    private Button btnRollbackTransaction;

    @FXML
    private Button btnStartTransaction;

    @FXML
    private Button btnUpdateValue;

    private Connection connection;

    public void initialize() {
        btnUpdateValue.setDisable(true);
        btnAddNewRecords.setDisable(true);
        btnCommitTransaction.setDisable(true);
        btnRollbackTransaction.setDisable(true);

        connection = DBConnection.getInstance().getConnection();

    }

    @FXML
    void btnStartTransactionOnAction(ActionEvent event) {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        btnUpdateValue.setDisable(false);
        btnAddNewRecords.setDisable(false);
        btnCommitTransaction.setDisable(false);
        btnRollbackTransaction.setDisable(false);
        btnStartTransaction.setDisable(true);

    }

    @FXML
    void btnAddNewRecordsOnAction(ActionEvent event) {
        try {
            PreparedStatement stm = connection.prepareStatement("INSERT INTO Customer(name, address) VALUES (?,?)");

            Faker faker = new Faker();

            stm.setString(1, faker.name().fullName());
            stm.setString(2, faker.address().cityName());
            stm.executeUpdate();

            System.out.println("New customer record has been added!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnUpdateValueOnAction(ActionEvent event) {
        try {
            PreparedStatement stm = connection.prepareStatement("UPDATE Customer SET name=?,address=? WHERE id=1");
            Faker faker = new Faker();
            String name = faker.name().fullName();
            String address = faker.address().cityName();

            stm.setString(1, name);
            stm.setString(2, address);
            stm.executeUpdate();

            System.out.printf("Customer id=%s has been updated with name=%s, address=%s \n",1, name, address);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnCommitTransactionOnAction(ActionEvent event) throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);

        btnStartTransaction.setDisable(false);
        btnUpdateValue.setDisable(true);
        btnAddNewRecords.setDisable(true);
        btnCommitTransaction.setDisable(true);
        btnRollbackTransaction.setDisable(true);

        System.out.println("transaction has been rollbacked!");

    }

    @FXML
    void btnRollbackTransactionOnAction(ActionEvent event) {

    }

}
