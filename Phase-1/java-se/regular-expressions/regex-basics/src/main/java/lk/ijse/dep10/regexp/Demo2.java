package lk.ijse.dep10.regexp;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {


        while (true) {
            System.out.print("Enter contact Number: ");

            Scanner scanner = new Scanner(System.in);
            String contact = scanner.nextLine();

            if (isContactValid(contact.trim())) {
                break;
            } else {
                System.out.println("Enter valid Contact Number");
            }

        }


    }

    private static boolean isContactValid(String contact) {
        return contact.matches("([+](94)|0)\\d{2}-\\d{7}");

//        String contactNumber;
//        if(!(contact.length()==13||contact.length()==11)) return false;
//
//        if (contact.length() == 13) {
//            if (contact.charAt(0) != '+') {
//                return false;
//            }
//            contactNumber = contact.substring(1, 3) + contact.substring(6);
//        }else{
//            contactNumber = contact.substring(0, 3) + contact.substring(4);
//        }
//
//        for (char c : contactNumber.toCharArray()) {
//            if (!Character.isDigit(c)) {
//                return false;
//            }
//        }
//        return true;

    }
}
