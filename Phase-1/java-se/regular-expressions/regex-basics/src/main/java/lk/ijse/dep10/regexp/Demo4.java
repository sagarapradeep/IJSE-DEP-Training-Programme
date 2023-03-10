package lk.ijse.dep10.regexp;

import java.util.Arrays;
import java.util.Scanner;

public class Demo4 {
    public static void main(String[] args) {


        String someText = "My Nic is: 123456789V, her nic is 123411111V";
        someText=someText.replaceFirst("\\d{9}[vV]", "123");
        System.out.println(someText);

        someText = someText.replaceAll("\\d{9}[vV]", "xxx-xxx-xxx");
        System.out.println(someText);

        String someText2 = "I want to split in to words this senetetnce";
        String[] split = someText2.split("\\b");
        System.out.println(Arrays.toString(split));




    }

    private static boolean isValidNic(String nic) {

        return nic.toUpperCase().matches("\\d{9}V");
//        if(nic.length()!=10) return false;
//
//        if(!(nic.charAt(nic.length()-1)!='v'||nic.charAt(nic.length()-1)!='V'))return false;
//        char[] nicToCharArray = nic.toCharArray();
//
//        for (int i = 0; i < nicToCharArray.length - 1; i++) {
//            if (!Character.isDigit(nicToCharArray[i])) {
//                return false;
//
//            }
//
//        }
//        return true;
    }
}
