package lk.ijse.dep10;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Conversion1 {
    public static void main(String[] args) throws ParseException {
        String strDate = "2021-01-02";
        String strTime = "6-9-55";
        String strDateTime = "2021-08-17 14-13-12";

        /*string date to util date via simple date format*/
        Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
        Date d2 = new SimpleDateFormat("kk-mm-ss").parse(strTime);
        Date d3 = new SimpleDateFormat("yyyy-MM-dd kk-mm-ss").parse(strDateTime);

        System.out.println("Date " + d1);
        System.out.println("Time " + d2);
        System.out.println("DateTime " + d3);
        System.out.println("--------------------------------------");

        /*string to local time,date and date and time*/
        LocalDate d4 = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalTime d5 = LocalTime.parse(strTime, DateTimeFormatter.ofPattern("hh-mm-ss"));
        LocalDateTime d6 = LocalDateTime.parse(strDateTime,DateTimeFormatter.ofPattern("yyyy-MM-dd kk-mm-ss"));

        System.out.println("Date " + d4);
        System.out.println("Time " + d5);
        System.out.println("DateTime " + d6);
        System.out.println("--------------------------------------");

        /*string to java.sql date,time,date and time*/
        java.sql.Date sqlDate = java.sql.Date.valueOf(strDate);
        Time sqlTime = Time.valueOf(strTime);
        Timestamp sqlTimeStamp = Timestamp.valueOf(strDateTime);

        System.out.println("Date " + sqlDate);
        System.out.println("Time " + sqlTime);
        System.out.println("DateTime " + sqlTimeStamp);
        System.out.println("--------------------------------------");

    }
}
