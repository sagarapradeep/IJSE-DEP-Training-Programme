package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Domo3 {
    public static void main(String[] args) {


        while (true) {
            System.out.print("Enter a date of dob (yyyy-mm-dd): ");
            Scanner scanner = new Scanner(System.in);
            String dob = scanner.nextLine();

            if (isValidDOB(dob.trim())){
                break;
            }else {
                System.out.println("Enter valid dob");
            }

        }



    }

    private static boolean isValidDOB(String dob) {
        return dob.matches("(19\\d{2}|2\\d{3})-(0[1-9]|1[0-2])-(0[1-9]|[1-2]\\d|3[0-1])");


//        if(dob.length()!=10) return false;
//        if (!(dob.charAt(4) == '-' && dob.charAt(7) == '-')) {
//            return false;
//        }
//        for (char c : dob.toCharArray()) {
//            if(c=='-') continue;
//            if(!Character.isDigit(c)) return false;
//        }
//
//        int year = Integer.parseInt(dob.substring(0, 4));
//        int month = Integer.parseInt(dob.substring(5, 7));
//        int day = Integer.parseInt(dob.substring(8));
//
//        if (year > 1990 || (month < 1 || month > 12) || (day < 1 || day > 31)) {
//            return false;
//        }
//        return true;
    }
}
