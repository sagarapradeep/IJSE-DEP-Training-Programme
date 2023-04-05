package lk.ijse.dep10.app.connection;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection instance;
    private final Connection connection;

    private DBConnection() {
        try {
            File file = new File("application.properties");
            Properties properties = new Properties();
            FileReader fileReader = new FileReader(file);
            properties.load(fileReader);
            fileReader.close();

            String host = properties.getProperty("sql.host");
            String port = properties.getProperty("sql.port");
            String user = properties.getProperty("sql.user");
            String password = properties.getProperty("sql.password");
            String database = properties.getProperty("sql.database");


            String url = ("jdbc:mysql://" + host + ":" + port + "/" + database + "?createDatabaseIfNotExist=true&allowMultiQueries=true");
            connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    public static DBConnection getInstance() {
        return (instance == null) ? instance = new DBConnection() : instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
