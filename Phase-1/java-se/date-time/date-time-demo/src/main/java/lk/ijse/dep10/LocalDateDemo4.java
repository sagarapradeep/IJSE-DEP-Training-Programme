package lk.ijse.dep10;

import java.time.LocalDate;

public class LocalDateDemo4 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate localDate1 = today.plusDays(10);
        LocalDate localDate2 = today.minusDays(10);

        System.out.println(today.isBefore(localDate1));
        System.out.println(today.isAfter(localDate1));
        System.out.println(today.isEqual(localDate1));

    }

}
