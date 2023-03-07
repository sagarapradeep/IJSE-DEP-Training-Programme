package lk.ijse.dep10;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Conversion4 {
    public static void main(String[] args) {

        Date sqlDate = Date.valueOf("2020-02-18");
        Time sqlTime = Time.valueOf("12:02:18");
        Timestamp sqlTimeStamp = Timestamp.valueOf("2020-02-18 12:45:23");

        LocalDate localDate = sqlDate.toLocalDate();
        LocalTime localTime = sqlTime.toLocalTime();
        LocalDateTime localDateTime = sqlTimeStamp.toLocalDateTime();

        Date sqlDate2 = Date.valueOf(localDate);
        Time sqlTime2 = Time.valueOf(localTime);
        Timestamp sqlTimeStamp2 = Timestamp.valueOf(localDateTime);


    }
}
