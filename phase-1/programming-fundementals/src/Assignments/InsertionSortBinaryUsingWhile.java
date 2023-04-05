package practice;

import java.util.Arrays;

public class InsertionSortBinaryUsingWhile {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100,20,30};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int i = 1;
        while (i < array.length) {
            int index = findIndex(array, i);
            move(array, i, index);
            i++;
        }
    }

    private static int findIndex(int[] array, int endIndex) {
        int leftIndex = 0;
        int rightIndex = endIndex;
        while (true) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex]==array[endIndex]) return middleIndex;
            if (leftIndex == middleIndex) {
                if (array[endIndex] > array[middleIndex]) return rightIndex;
                else return middleIndex;
            }
            if (array[endIndex] > array[middleIndex]) leftIndex = middleIndex;
            else rightIndex = middleIndex;
        }
    }

    private static void move(int[] array, int numberFromIndex, int numberToIndex) {
        if (numberFromIndex == numberToIndex) return;
        int i = numberToIndex;
        int temp1 = array[numberFromIndex];
        while (i <= numberFromIndex) {
            int temp2 = array[i];
            array[i] = temp1;
            temp1 = temp2;
            i++;
        }
    }
}
