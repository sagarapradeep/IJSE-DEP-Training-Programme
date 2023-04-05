package lk.ijse.dep10;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateDemo {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalTime now = LocalTime.now();
        System.out.println(now);

        LocalDateTime todayTime = LocalDateTime.now();
        System.out.println(todayTime);

        LocalDate today2 = LocalDate.of(2020, 1, 1);
        System.out.println(today2);

        LocalTime time2 = LocalTime.of(12, 12, 30);
        System.out.println(time2);
    }
}
