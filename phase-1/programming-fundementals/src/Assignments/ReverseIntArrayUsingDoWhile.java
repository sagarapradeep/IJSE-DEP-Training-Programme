package practice;

import java.util.Arrays;

public class ReverseIntArrayUsingDoWhile {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
//        int[] array = new int[] {12, 10,24,30};
        printReverse(array);
    }

    public static void printReverse(int[] array) {
        if (array.length == 0) {
            System.out.println("Empty list");
            return;
        }
        reverseArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int index = 0;
        int temp = array[0];
        do {
            temp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = temp;
        } while (++index < array.length/2);
    }

}
