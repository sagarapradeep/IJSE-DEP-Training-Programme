package practice;

import java.util.Arrays;

public class BubbleSortMaxRecursion {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        recursion1(array,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void recursion1(int[] array,int i) {
        if (i == 0) return;
        recursion2(array, i, 0);
        recursion1(array,i-1);
    }

    public static void recursion2(int[] array, int i, int j) {
        if (i == j) return;
        if (array[j] > array[j + 1]) {
            int temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
        }
        recursion2(array,i,j+1);
    }

}
