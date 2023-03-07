package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo2 {
    public static void main(String[] args) {
        String strDate = "16-12-2014";
        LocalDate date = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(date.getYear());

        String strTime = "13:12:57";
        LocalTime time = LocalTime.parse(strTime, DateTimeFormatter.ofPattern("kk:mm:ss"));
        System.out.println(time.getHour());

        String strDateandTime = "16-12-2014 15";

    }
}
