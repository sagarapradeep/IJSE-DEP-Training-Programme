package lk.ijse.dep10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpCapturing {
    public static void main(String[] args) {
        Pattern reExp = Pattern.compile("^GET (.+) (HTTP.+)$");
        Matcher matcher = reExp.matcher("GET /ijse/images HTTP/1.1");
        matcher.find();

        String group1 = matcher.group(1);
        String group2= matcher.group(2);
        System.out.println(group1);
        System.out.println(group2);


    }
}
