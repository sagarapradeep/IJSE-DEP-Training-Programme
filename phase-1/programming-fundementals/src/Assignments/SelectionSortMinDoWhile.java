package practice;

import java.util.Arrays;

public class SelectionSortMinDoWhile {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int i = 0;
        int temp = 0;

        do {
            int j = i;
            int min = array[i];
            int minIndex = i;
            do {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            } while (++j < array.length);
            temp = array[i];
            array[i] = min;
            array[minIndex] = temp;
        } while (++i < array.length - 1);
    }

}
