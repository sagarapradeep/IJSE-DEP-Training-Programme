package practice;

import java.util.Arrays;

public class SelectionSortMaxDoWhile {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int i = array.length - 1;
        do {
            int max = array[i];
            int maxIndex = i;
            int j = i;
            do {
                if (max < array[j]) {
                    max = array[j];
                    maxIndex = j;
                }
            } while (--j >= 0);
            int temp = array[i];
            array[i] = max;
            array[maxIndex] = temp;
        } while (--i > 0);
    }

}
