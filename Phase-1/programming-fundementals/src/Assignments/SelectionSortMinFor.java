package practice;

import java.util.Arrays;

public class SelectionSortMinFor {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int temp;
        for (int j = 0; j < array.length-1; j++) {
            int min = array[j];
            int index = j;
            for (int i = j; i < array.length; i++) {
                if (array[i] < min) {
                    min = array[i];
                    index = i;
                }
            }
            temp = array[j];
            array[j] = array[index];
            array[index] = temp;
        }

    }

}
