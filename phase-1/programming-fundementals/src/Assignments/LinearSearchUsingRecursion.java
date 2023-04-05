package practice;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchUsingRecursion {
    public static void main(String[] args) {
        int[] array = new int[] {10,24,34,47,73,38,62,58,34,24,47,62,34,94,100};
        System.out.println(Arrays.toString(array));
        System.out.print("Enter a number to search : ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        searchNumber(array,number);
//        int[] abc = removeArray(new int[]{1,2,3,4,5,90});
//        System.out.println(Arrays.toString(abc));
    }

    public static void searchNumber(int[] array, int number) {
        int[] index = recursion(array, number, 0);
        if (index.length == 0) {
            System.out.printf("The number %d is not in the list", number);
            return;
        }
        System.out.printf("The number %d is in the index of : ", number);
        System.out.println(Arrays.toString(index));
    }

    private static int[] recursion(int[] array, int number, int index) {
        int[] indexArray = {};
        if (array.length == 0) return indexArray;
        indexArray = recursion(removeArray(array), number, index + 1);
        if (array[0] == number) indexArray = addArray(indexArray, index);
        return indexArray;
    }

//    private static int[] removeArray(int[] array) {    // this class is replaced with "removeArray" and "addRecursive"
//        int[] newArray = new int[array.length - 1];
//       for (int i = 1; i < array.length; i++) {
//            newArray[i - 1] = array[i];
//        }
//        return newArray;
//    }
    private static int[] removeArray(int[] array) {
        int[] newArray = new int[array.length - 1];
        if (newArray.length == 0) return newArray;
        newArray = addRecursive(array, newArray, 1);
        return newArray;
    }

    private static int[] addRecursive(int[] oldArray, int[] newArray, int index) {
        newArray[index - 1] = oldArray[index];
        if (oldArray.length == index + 1) return newArray;
        index++;
        newArray = addRecursive(oldArray, newArray, index);
        return newArray;
    }

//    private static int[] addArray(int[] array, int number) {   //this is replaced with "addArray" and "addRecursive2"
//        int[] newArray = new int[array.length + 1];
//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
//        newArray[array.length] = number;
//        return newArray;
//    }

    private static int[] addArray(int[] array, int number) {
        int[] newArray = new int[array.length + 1];
        if (array.length != 0) newArray = addRecursive2(array, newArray, 0);
        newArray[array.length] = number;
        return newArray;
    }

    private static int[] addRecursive2(int[] oldArray, int[] newArray, int index) {
        newArray[index] = oldArray[index];
        if (index == oldArray.length - 1) return newArray;
        newArray = addRecursive2(oldArray, newArray, index + 1);
        return  newArray;
    }

}
