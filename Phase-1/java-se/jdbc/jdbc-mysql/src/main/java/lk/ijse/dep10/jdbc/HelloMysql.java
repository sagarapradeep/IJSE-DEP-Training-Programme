package lk.ijse.dep10.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class HelloMysql {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep10_hellodb", "root", "mysql");
            System.out.println(connection);

            Statement stm = connection.createStatement();
            String sql= "INSERT INTO Student VALUES (30,'Sagara','Senarath','Bomiriya','MALE','1998-03-09')";
            String updateSql = "update Student SET address='Mathara'WHERE address='Bomiriya'";
            //language=MySQL
            String deleteSql = "DELETE FROM Student WHERE address='Mathara'";

            int affectedRows = stm.executeUpdate(deleteSql);
            System.out.println(affectedRows);




            connection.close();
        } catch (SQLException e) {
            System.out.println("Connection lost");
            e.printStackTrace();
        }
    }
}
