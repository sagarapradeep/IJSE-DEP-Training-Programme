package lk.ijse.dep10.app.db;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection instance;
    private final Connection connection;

    private DBConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep10_students", "root", "mysql");
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, "Failed to connect the data base").showAndWait();
            System.exit(2);
            throw new RuntimeException(e);
        }

    }

    public static DBConnection getInstance() {
        return (instance==null)?instance=new DBConnection():instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
