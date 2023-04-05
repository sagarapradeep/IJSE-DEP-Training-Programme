package lk.ijse.dep10.clienta.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import lk.ijse.dep10.clienta.db.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientViewController {

    public Button btnReadRecords2;
    public Button btnRepeatableRead1;
    public Button btnRepeatableRead2;
    @FXML
    private Button btnReadRecords1;

    @FXML
    private Button btnReadValue;

    @FXML
    private ComboBox<String> cmbTransactionLevel;

    public void initialize() {
        btnReadRecords1.setDisable(false);
        btnReadRecords2.setDisable(true);

        cmbTransactionLevel.getItems().add("READ UNCOMMITTED");
        cmbTransactionLevel.getItems().add("READ COMMITTED");
        cmbTransactionLevel.getItems().add("REPEATABLE READ");
        cmbTransactionLevel.getItems().add("SERIALIZABLE");
        cmbTransactionLevel.getSelectionModel().select(2);

        cmbTransactionLevel.getSelectionModel().selectedItemProperty().addListener((pv,current,value)->{
            if(current==null) return;
            Connection connection = DBConnection.getInstance().getConnection();

            try {
                switch (current) {
                    case "READ UNCOMMITTED":
                        connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);

                    case "READ COMMITTED":
                        connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

                    case "REPEATABLE READ":
                        connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

                    case "SERIALIZABLE":
                        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
                }

            } catch (SQLException e) {
                throw new RuntimeException();

            }

        });

    }

    @FXML
    void btnReadRecords1OnAction(ActionEvent event) {

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT *FROM Customer");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                System.out.printf("id = %s ,Name = %s ,  Address= = %s\n", id, name, address);
            }


            btnReadRecords1.setDisable(true);
            btnReadRecords2.setDisable(false);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnReadRecords2OnAction(ActionEvent actionEvent) {

        Connection connection = DBConnection.getInstance().getConnection();
        try {
            connection.setAutoCommit(false);
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery("SELECT *FROM Customer");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                System.out.printf("Name = %s ,Name = %s , Address= = %s\n", id,name, address);
            }
            connection.commit();
            connection.setAutoCommit(true);
            btnReadRecords2.setDisable(true);
            btnReadRecords1.setDisable(false);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnReadValueOnAction(ActionEvent event) throws SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        if (!connection.getAutoCommit()) {
            connection.rollback();
            connection.setAutoCommit(true);
            btnReadRecords1.setDisable(false);
            btnReadRecords2.setDisable(true);
        }

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT *FROM Customer WHERE id=1");

            resultSet.next();
            String name = resultSet.getString("name");
            String address = resultSet.getString("address");

            System.out.printf("Name = %s , Address= = %s\n", name, address);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void btnRepeatableRead1OnAction(ActionEvent actionEvent) {
        Connection connection = DBConnection.getInstance().getConnection();
        try {
            Statement statement = connection.createStatement();
//            statement.executeQuery("")

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnRepeatableRead2OnAction(ActionEvent actionEvent) {
    }
}
