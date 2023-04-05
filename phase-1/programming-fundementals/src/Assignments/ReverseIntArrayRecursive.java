package practice;

import java.util.Arrays;

public class ReverseIntArrayRecursive {
    public static void main(String[] args) {
//        int[] array = new int[] {12, 10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        int[] array = new int[] {12, 10,24,30};
        printArray(array);
    }

    public static void printArray(int[] array) {
        reverseArray(array);
        System.out.println(Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        recursive(array,0);
    }

    public static void recursive(int[] array, int index) {
        if (index == array.length/2) return;
        int temp = array[index];
        array[index] = array[array.length-1-index];
        array[array.length-1-index] = temp;
        recursive(array,index + 1);
    }

}
