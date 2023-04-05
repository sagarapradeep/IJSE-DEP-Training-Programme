package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateDemo3 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2020, 8, 4);
        LocalTime time = LocalTime.of(5, 3, 12);

        LocalDateTime dateTime = date.atTime(time);     //set date to time
        date.atStartOfDay();

        LocalDateTime dateTime1 = LocalDateTime.of(2020, 7, 12, 15, 8, 45);
        LocalDate date1 = dateTime1.toLocalDate();
        LocalTime time1 = dateTime1.toLocalTime();

        System.out.println(dateTime);
        System.out.println(date.atStartOfDay());


    }
}
