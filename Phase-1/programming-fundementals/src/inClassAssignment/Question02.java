package inClassAssignment;

import java.util.Scanner;

public class Question02 {
    public static void main(String[] args) {
        var numbers = new int[]{12, 45, 77, 89, 55, 43, -44, 33, 22};
        var scanner = new Scanner(System.in);
        System.out.print("Enter number to search: ");
        int input = scanner.nextInt();
        int index=0;
        String message =null;
        String statement=findNumber(numbers, input,index,message);
        System.out.println(statement);
    }

    public static String findNumber(int[] numbers, int input, int index,String statement) {
        if (numbers[index] == input) {
            statement = "Fount at " + index;
            return statement;
        } else if ((index == numbers.length-1) ) {
            statement = "Not found!";
            return statement;

        }

        return findNumber(numbers, input, ++index, statement);

    }
}
