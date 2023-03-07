package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Conversion5 {
    public static void main(String[] args) {
        Date utilDate = new Date();

        LocalDate localDate = new java.sql.Date(utilDate.getTime()).toLocalDate();
        LocalTime localTime = new java.sql.Time(utilDate.getTime()).toLocalTime();
        LocalDateTime localDateTime = new java.sql.Timestamp(utilDate.getTime()).toLocalDateTime();


    }
}
