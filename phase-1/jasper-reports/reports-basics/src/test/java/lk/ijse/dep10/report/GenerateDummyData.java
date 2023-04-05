package lk.ijse.dep10.report;

import com.github.javafaker.Faker;
import lk.ijse.dep10.app.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GenerateDummyData {
    public static void main(String[] args) throws SQLException {
        Faker faker = new Faker();


        Connection connection = DBConnection.getInstance().getConnection();

        PreparedStatement stm = connection.prepareStatement("INSERT INTO Customer (name, address) VALUES (?,?)");

        for (int i = 0; i < 200; i++) {
            stm.setString(1, faker.name().fullName());
            stm.setString(2, faker.address().cityName());
            stm.executeUpdate();
        }

        System.out.println("200 Customers has been added!");


    }
}
