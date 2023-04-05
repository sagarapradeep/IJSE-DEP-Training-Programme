package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class Conversion3 {
    public static void main(String[] args) {
        Date utilDate = new Date();

        /*util date to local date*/
        LocalDate localDate = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalTime localTime = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        LocalDateTime localDateTime = utilDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

    }
}
