package practice;

import java.util.Arrays;

public class SelectionSortMaxFor {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int max = array[array.length-1-i];
            int maxIndex = array.length - 1 - i;
            int temp;
            for (int j = 0; j < array.length-i; j++) {
                if (max < array[array.length - 1 - i - j]) {
                    max = array[array.length-1-i-j];
                    maxIndex = array.length - 1 - i - j;
                }
            }
            temp = array[array.length - 1 - i];
            array[array.length - 1 - i] = max;
            array[maxIndex] = temp;
        }
    }

}
