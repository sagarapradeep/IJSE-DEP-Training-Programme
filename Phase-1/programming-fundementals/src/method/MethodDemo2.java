package method;

import java.util.Arrays;
import java.util.Scanner;

public class MethodDemo2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);


        String name=nameValidate("Enter student name: ");
        int totalMarks = 0;

        for (String arg : new String[]{"pf", "dbms", "oop"}) {
            totalMarks += requestMarks(arg);

        }

        System.out.println( name+"'s Total marks: " +totalMarks);
        System.out.println( name+"'s average marks: " +(totalMarks)/3.0);


    }

    /*marks validation method */
    public static boolean isValidMark(String input) {
        char[] charArray = input.toCharArray();
        for (char c : charArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        int marks = Integer.parseInt(input);

        return marks >= 0 && marks <= 100;
    }

    /*user input and valid mark return method*/
    public static int requestMarks(String subject) {
        var scanner = new Scanner(System.in);
        boolean validInput = false;
        String input = null;
        do {
            System.out.printf("Enter marks for %s : ", subject);
            input = scanner.nextLine().trim();
            validInput = isValidMark(input);
            if (!validInput) System.out.println("Invalid marks, try again !");
        } while (!validInput);

        return Integer.parseInt(input);

    }

    public static String nameValidate(String message) {
        boolean isValidName = false;
        var scanner = new Scanner(System.in);
        String name=null;
        while (!isValidName) {
            System.out.print(message);
            name = scanner.nextLine().trim();
            char[] chaArray = name.toCharArray();
            if (chaArray.length > 4) {
                int i=0;
                for (i = 0; i < chaArray.length; i++) {
                    if (!(Character.isLetter(chaArray[i]) || chaArray[i] == ' ')) {
                        System.out.println("Invalid name !");
                        break;
                    }
                }
                if (i==chaArray.length) {
                    isValidName=true;
                }
            }
            else {
                System.out.println("Invalid name !");
            }
        }
        return name;

    }
}
