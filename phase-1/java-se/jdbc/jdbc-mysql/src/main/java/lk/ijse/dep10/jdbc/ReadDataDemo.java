package lk.ijse.dep10.jdbc;

import java.sql.*;

public class ReadDataDemo {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://dep10.lk:3306/dep10_hellodb", "root", "mysql");

            String sql = "SELECT *FROM Student";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fistName = resultSet.getString(2);
                String lastname = resultSet.getString(3);
                String gender = resultSet.getString("gender");
                Date dob = resultSet.getDate("dob");


                System.out.printf("%5s%10s%10s%6s%19s \n",id,fistName,lastname,gender,dob);
            }

//            resultSet.next();
//            int id = resultSet.getInt(1);
//            System.out.println(id);
//            String fistName = resultSet.getString(2);
//            System.out.println(fistName);


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
