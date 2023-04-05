package lk.ijse.dep10;

import java.util.Calendar;
import java.util.Date;

public class UtilDate {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);

        Calendar calender = Calendar.getInstance();
        calender.clear();
        calender.set(2012, 0, 17);

//        calender.set(2020, 0,1,0,0,0);

        Date d2 = calender.getTime();
        System.out.println(d2);


        System.out.println(calender.get(Calendar.MONTH));       //month
        System.out.println(calender.get(Calendar.YEAR));        //year
        System.out.println(calender.get(Calendar.DAY_OF_WEEK));
        System.out.println(calender.get(Calendar.DAY_OF_WEEK_IN_MONTH));
        System.out.println(calender.get(calender.MINUTE));
        System.out.println(calender.get(Calendar.HOUR_OF_DAY));
        System.out.println(calender.get(Calendar.HOUR));
        System.out.println(calender.get(Calendar.DAY_OF_YEAR));
        System.out.println(calender.get(Calendar.AM_PM));


    }
}
