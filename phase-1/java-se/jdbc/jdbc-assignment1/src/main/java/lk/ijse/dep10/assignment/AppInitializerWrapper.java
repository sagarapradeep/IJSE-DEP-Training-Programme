package lk.ijse.dep10.assignment;

import java.sql.SQLException;

public class AppInitializerWrapper {

    public static void main(String[] args) {
        try {
            AppInitializer.main(args);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
