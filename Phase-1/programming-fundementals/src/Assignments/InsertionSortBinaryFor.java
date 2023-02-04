package practice;

import java.util.Arrays;

public class InsertionSortBinaryFor {
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
            int numberToIndex = findIndex(array, i);
            move(array, i, numberToIndex);
        }
    }

    private static int findIndex(int[] array,int numberFromIndex) {
        int leftIndex = 0;
        int rightIndex =numberFromIndex;
        for (; true; ) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex]==array[numberFromIndex]) return middleIndex;
            if (middleIndex == leftIndex) {
                if (array[numberFromIndex] > array[middleIndex]) return rightIndex;
                else return middleIndex;
            }
            if (array[middleIndex] < array[numberFromIndex]) leftIndex = middleIndex;
            else rightIndex = middleIndex;
        }
    }

    public static void move(int[] array, int numberFromIndex, int numberToIndex) {
        if (numberFromIndex == numberToIndex) return;
        int temp1 = array[numberFromIndex];
        for (int i = numberToIndex; i <= numberFromIndex ; i++) {
            int temp2 = array[i];
            array[i] = temp1;
            temp1 = temp2;
        }
    }

}
