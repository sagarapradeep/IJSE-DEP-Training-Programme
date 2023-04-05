package practice;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchUsingDoWhile {
    public static void main(String[] args) {
        int[] array = new int[] {10,24,34,47,73,38,62,58,34,24,47,62,34,94,100};
        System.out.println(Arrays.toString(array));
        System.out.print("Enter a number to search : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        searchNumber(array,number);
    }

    public static void searchNumber(int[] array, int number) {
        int[] index = {};
        int i = 0;
        if (array.length != 0) {
            do {
                if (array[i] == number) index = dynamicArray(index, i);
            } while (++i < array.length);
            if (index.length > 0) {
                System.out.printf("The number %d is in the index of : ",number);
                System.out.println(Arrays.toString(index));
                return;
            }
            System.out.printf("The number %d is not in the list",number);
        }
        System.out.println("Empty list");
    }

    private static int[] dynamicArray(int[] array, int number) {
        int[] newArray = new int[array.length + 1];
        if (array.length > 0) {
            int i = 0;
            do {
                newArray[i] = array[i];
            } while (++i < array.length);
        }
        newArray[array.length] = number;
        return newArray;
    }

}
