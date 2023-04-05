package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate3 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(2020, 3, 5);
        Date d1 = cal.getTime();

        cal.clear();
        cal.set(2020, 7, 8);
        Date d2 = cal.getTime();

        cal.clear();
        cal.set(2019, 8, 9);
        Date d3 = cal.getTime();

        System.out.println(d1.before(d3));
        System.out.println(d1.after(d3));
        System.out.println(d1.equals(d3));

    }
}
