package practice;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchUsingWhile {
    public static void main(String[] args) {
        int[] array = new int[] {10,24,34,47,73,38,62,58,34,24,47,62,34,94,100};
        System.out.println(Arrays.toString(array));
        System.out.print("Enter a number to search : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        numberSearch(array,number);
    }

    public static void numberSearch(int[] array, int number) {
        int i = 0;
        int[] indexList = {};
        while (i < array.length) {
            if (array[i] == number) {
                indexList = dynamicArray(indexList,i);
            }
            i++;
        }

        if (indexList.length > 0) {
            System.out.printf("The number %d is in the index of : ",number);
            System.out.println(Arrays.toString(indexList));
            return;

        }
        System.out.printf("The number %d is not in the list", number);
        return;
    }

    private static int[] dynamicArray(int[] array, int number) {
        int[] newArray = new int[array.length + 1];
        int i = 0;
        while (i < array.length) {
            newArray[i] = array[i];
            i++;
        }
        newArray[array.length] = number;
        return newArray;
    }
}
