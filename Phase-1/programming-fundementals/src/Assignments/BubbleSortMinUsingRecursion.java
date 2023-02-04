package practice;

import java.util.Arrays;

public class BubbleSortMinUsingRecursion {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        recursion1(array,0);
        System.out.println(Arrays.toString(array));
    }

    public static void recursion1(int[] array,int i) {
        if (i == array.length-1) return;
        recursion2(array,i, array.length-1);
        recursion1(array, i+1);
    }

    public static void recursion2(int[] array, int i,int j) {
        if (i==j) return;
        if (array[j - 1] > array[j]) {
            int temp = array[j - 1];
            array[j - 1] = array[j];
            array[j] = temp;
        }
        recursion2(array,i,j-1);
    }

}
