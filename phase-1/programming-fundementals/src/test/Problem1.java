package test;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        var numbers = new int[]{12, 23, 44, 5, 66, 34, 23, 66, -1, 56, 33};
        System.out.print("Enter specific number here: ");
        var scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String statement = recursion(numbers, input,0);
        printOutput(statement);
    }

    /*Using for loop*/
    public static String linearSearchForLoop(int[] numbers, int input) {
        int index = 0;
        boolean condition = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == input) {
                index = i;
                condition = true;
                break;
            }
        }
        if (condition) return Integer.toString(index);
        else return "Number not in array";
    }

    /*Using while loop*/
    public static String linearSearchWhileLoop(int[] numbers, int input) {
        int index = 0;
        boolean condition = false;
        int i = 0;
        while ((i < numbers.length)) {
            if (numbers[i] == input) {
                index = i;
                condition = true;
                break;
            }
            ++i;
        }
        if (condition) return Integer.toString(index);
        else return "Number not in array";
    }


    /*Using Do while loop*/
    public static String linearSearchDoWhileLoop(int[] numbers, int input) {
        int i = 0;
        boolean condition = false;
        int index = 0;

        do {
            if (numbers[i] == input) {
                index = i;
                condition = true;
                break;
            }
            ++i;


        } while (i < numbers.length);
        if (condition) return Integer.toString(index);
        else return "Number not in array";
    }


    /*Using enhanced for loop*/
    public static String linearSearchEnhancedForLoop(int[] numbers, int input) {
        int i = 0;
        boolean condition = false;
        int index = 0;

        for (int n : numbers) {
            if (n == input) {
                index = i;
                condition = true;
                break;
            }

        }
        if (condition) return Integer.toString(index);
        else return "Number not in array";
    }

    /*Using recursion*/
    public static String recursion(int[] numbers, int input,int index) {
        if (numbers[index] == input) {
            return Integer.toString(index);
        } if (index == numbers.length-1) {
            return "Number not in array";
        }

        return recursion(numbers, input, ++index);
    }

    /*Print output*/
    public static void printOutput(String statement) {
        System.out.println(statement);
    }
}
