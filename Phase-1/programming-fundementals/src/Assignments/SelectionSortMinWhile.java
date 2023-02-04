package practice;

import java.util.Arrays;

public class SelectionSortMinWhile {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int index1 = 0;
        int temp;
        while (index1 < array.length - 1) {
            int index2 = index1;
            int min = array[index1];
            int minIndex = index1;
            while (index2 < array.length) {
                if (array[index2] < min) {
                    min = array[index2];
                    minIndex = index2;
                }
                index2++;
            }
            temp = array[index1];
            array[index1] = min;
            array[minIndex] = temp;
            index1++;
        }
    }

}
