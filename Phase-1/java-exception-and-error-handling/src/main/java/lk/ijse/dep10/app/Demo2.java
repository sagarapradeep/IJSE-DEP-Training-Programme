package lk.ijse.dep10.app;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter your ID here: ");
        String id = scanner.nextLine().strip();

        if(id.length()!=10){
            System.out.println("Invalid ID");
            return;
        }
        String subId = id.substring(0, id.length() - 1);
        if (isInt(subId) && (id.endsWith("v") || id.endsWith("V"))) {
            System.out.println("Valid NIC number");
            return;
        }
        System.out.println("Invalid NIC number");

    }

    public static boolean isInt(String subId) {
        try {
            Integer.parseInt(subId);

        } catch (RuntimeException r) {
            r.printStackTrace();
            return false;
        }
        return true;
    }
}
