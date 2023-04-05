package lk.ijse.dep10;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class LocalDateDemo5 {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2020, 5, 4);
        LocalDate date2 = LocalDate.of(2018, 12, 30);


        Duration between = Duration.between(date2.atStartOfDay(), date1.atStartOfDay());
        System.out.println(between.toDays());
        System.out.println(between.toHours());

        System.out.println("--------------------------------------------");

        Period period = Period.between(date2, date1);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());

    }
}
