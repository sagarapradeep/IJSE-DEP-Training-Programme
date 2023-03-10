package lk.ijse.dep10.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo5 {
    public static void main(String[] args) {
        String text = "Hi, my Phone number is: 076-9047694, My home number is 011-4996043";
        text += "her number is 088-1234567";

        Pattern pattern = Pattern.compile("\\d{3}-\\d{7}");
        Matcher matcher = pattern.matcher(text);


        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println("Number " + text.substring(start, end));

        }


    }
}
