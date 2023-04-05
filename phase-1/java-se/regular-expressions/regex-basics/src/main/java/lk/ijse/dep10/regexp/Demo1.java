package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {


        while (true) {
            System.out.print("Enter a NIC number: ");

            Scanner scanner = new Scanner(System.in);
            String nic = scanner.nextLine();

            if (isValidNic(nic.trim())){
                break;
            }else {
                System.out.println("Enter valid NIC");
            }

        }



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
