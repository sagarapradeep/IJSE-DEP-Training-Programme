package test;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicArray {
    public static void main(String[] args) {
        boolean condition =true;
        String[] array1 = new String[0];
        var scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter number here(Q/q to quiet): ");
            String input = scanner.nextLine().trim();
            if ("q".equals(input) || "Q".equals(input)) {
                break;
            } else {
                var newStrArray = new String[array1.length + 1];
                for (int i = 0; i < array1.length; i++) {
                    newStrArray[i] = array1[i];
                }
                newStrArray[newStrArray.length - 1] = input;
                array1 = newStrArray;

                }
            }
        System.out.println(Arrays.toString(array1));


    }

}

