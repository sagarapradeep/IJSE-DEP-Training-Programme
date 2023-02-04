package practice;

import java.util.Arrays;

public class InsertionSortLinearFor {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100,-200};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int index = findIndex(array, i);
            move(array,i,index);
        }
    }

    private static int findIndex(int[] array, int endIndex) {
        int number = array[endIndex];
        for (int i = 0; i <= endIndex; i++) {
            if (array[i] >= number) return i;
        }
        return 0;
    }

    private static void move(int[] array, int numberFromIndex, int numberToIndex) {
         if (numberFromIndex == numberToIndex) return;
        int temp1 = array[numberFromIndex];
        for (int i = numberToIndex; i <= numberFromIndex ; i++) {
            int temp2 = array[i];
            array[i] = temp1;
            temp1 = temp2;
        }
    }

}
