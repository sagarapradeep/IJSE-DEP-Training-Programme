package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class AgeCalculatingApp {
    public static void main(String[] args) {

        Calendar cal = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();


        Scanner scanner = new Scanner(System.in);
        Date utilBirthDay;
        Date currentDate = new Date();
        SimpleDateFormat cdf = new SimpleDateFormat("yyyy:MM:dd");

        while (true) {
            try {
                System.out.print("Date format YYY:MM:dd\n ");
                System.out.print("Enter birthDay here: ");
                String birthDay = scanner.nextLine();
                utilBirthDay = cdf.parse(birthDay);
                if (currentDate.before(utilBirthDay)) {
                    System.out.println("Enter valid birthday!");
                    continue;
                }
                break;
            } catch (ParseException e) {
                System.out.println("Enter valid format");
            }
        }

        cal.setTime(utilBirthDay);
        Date newDate;
        int year=0;
        int month=0;
        int day=0;

        int gapYear;
        int gapMouth;
        int gapDay;

        while (true) {
            cal.add(Calendar.YEAR, 1);
            newDate = cal.getTime();
            ++year;

            if (newDate.after(currentDate)) {

                cal.add(Calendar.YEAR ,- 1);
                newDate = cal.getTime();
                gapYear=year-1;
                break;
            }
        }

        while (true) {
            cal.add(Calendar.MONTH, +1);
            newDate = cal.getTime();

            if (newDate.after(currentDate)) {

                cal.add(Calendar.MONTH ,- 1);
                newDate = cal.getTime();


                gapMouth = month;

                break;
            }
            ++month;
        }
        System.out.println(newDate);
        while (true) {
            cal.add(Calendar.DAY_OF_MONTH, +1);
            newDate = cal.getTime();

            if (newDate.after(currentDate)) {

                cal.add(Calendar.DAY_OF_MONTH, -1);
                newDate = cal.getTime();
                gapDay = day;

                break;
            }
            ++day;
        }
        System.out.printf("%s-%s-%s", gapYear, gapMouth, gapDay);








    }
}
