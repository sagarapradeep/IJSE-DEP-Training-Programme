package practice;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchUsingForEach {
    public static void main(String[] args) {
        int[] array = new int[] {10,24,34,47,73,38,62,58,34,24,47,62,34,94,100};
        System.out.println(Arrays.toString(array));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to search : ");
        int number = scanner.nextInt();
        numberSearch(array,number);
    }

    public static void numberSearch(int[] array, int number) {
        int[] indexList ={};
        int index = 0;
        for (int i : array) {
            if (i != number){
                index++;
                continue;
            }

            indexList = dynamicArray(indexList, index);
            index++;
        }
        if (indexList.length == 0) {
            System.out.printf("The number %d is not in the list", number);
            return;
        }
        System.out.printf("The number %d is in the list at the index of : ", number);
        System.out.println(Arrays.toString(indexList));
    }

    private static int[] dynamicArray(int[] array, int number) {
        int[] newArray = new int[array.length + 1];
        int j = 0;
        for (int i : array) {
            newArray[j] = i;
            j++;
        }
        newArray[array.length] = number;
        return newArray;
    }

}
