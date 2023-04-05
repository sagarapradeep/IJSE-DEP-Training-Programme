package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SimpleDayCalculatingApp {
    public static void main(String[] args) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy:MM:dd");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy:MM:dd");

        Date utilDate1;
        Date utilDate2;
        Scanner scanner = new Scanner(System.in);


        while (true) {
            try {
                System.out.print("Date Format: YYYY:MM:DD\n");
                System.out.print("Enter date 1: ");
                String date1 = scanner.nextLine();
                utilDate1=sdf1.parse(date1);
                break;
            } catch (ParseException e) {
                System.out.println("Enter date according to the format");
                continue;
            }

        }


        while (true) {
            try {
                System.out.print("Date Format: YYYY:MM:DD\n");
                System.out.print("Enter date 2: ");
                String date2 = scanner.nextLine();
                utilDate2=sdf2.parse(date2);
                if (utilDate1.after(utilDate2)) {
                    System.out.println("Enter date after date 1");
                    continue;
                }
                break;
            } catch (ParseException e) {
                System.out.println("Enter date according to the format");
                continue;
            }

        }

        System.out.println("Date Difference ="+(utilDate2.getTime() - utilDate1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
