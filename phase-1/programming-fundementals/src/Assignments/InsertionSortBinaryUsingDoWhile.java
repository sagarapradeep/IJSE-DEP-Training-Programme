package practice;

import java.util.Arrays;

public class InsertionSortBinaryUsingDoWhile {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100,20};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array) {
        int i = 1;
        do {
            int index = findIndex(array, i);
            move(array,i,index);
        } while (++i < array.length);
    }

    private static int findIndex(int[] array, int endIndex) {
        int leftIndex = 0;
        int rightIndex = endIndex;
        do {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[middleIndex] == array[endIndex]) return middleIndex;
            if (middleIndex == leftIndex) {
                if (array[middleIndex] < array[endIndex]) return rightIndex;
                else return leftIndex;
            }
            if (array[middleIndex] < array[endIndex]) leftIndex = middleIndex;
            else rightIndex = middleIndex;
        } while (true);
    }

    private static void move(int[] array, int numberFromIndex, int numberToIndex) {
        if (numberToIndex == numberFromIndex) return;
        int temp1 = array[numberFromIndex];
        int i = numberToIndex;
        do {
            int temp2 = array[i];
            array[i] = temp1;
            temp1 = temp2;
        } while (++i <= numberFromIndex);
    }
}
