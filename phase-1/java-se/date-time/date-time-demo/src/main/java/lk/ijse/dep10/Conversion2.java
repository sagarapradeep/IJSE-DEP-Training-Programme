package lk.ijse.dep10;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class Conversion2 {
    public static void main(String[] args) {

        /*java util date to java.sql date*/
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        java.sql.Time sqlTime = new Time(utilDate.getTime());

        java.sql.Timestamp sqlTimeStamp = new Timestamp(utilDate.getTime());

        /*java.sql to java.util*/
        utilDate = new Date(sqlDate.getTime());
        utilDate = new Date(sqlTime.getTime());
        utilDate = new Date(sqlTimeStamp.getTime());

    }
}
