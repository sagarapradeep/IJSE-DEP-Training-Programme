package lk.ijse.dep10;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDate2 {
    public static void main(String[] args) {
        String date = "2023-02-08 15:20";
        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm");
        try {
            Date utilDate=sdf.parse(date);
            System.out.println(utilDate);
        } catch (ParseException e) {
            System.out.println("Failed to convert the date!");
            e.printStackTrace();
        }
    }
}
