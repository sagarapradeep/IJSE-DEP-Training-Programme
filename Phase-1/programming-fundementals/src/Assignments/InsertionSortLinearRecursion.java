package practice;

import java.util.Arrays;

public class InsertionSortLinearRecursion {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100,20};
        printSort(array);
    }

    public static void printSort(int[] array) {
        sortRecursion(array,1);
        System.out.println(Arrays.toString(array));
    }

    public static void sortRecursion(int[] array,int index) {
        if (index == array.length) return;
        int numberToIndex = findIndexRecursion(array, index,0);
        move(array, index, numberToIndex);
        sortRecursion(array, index + 1);
    }

    private static int findIndexRecursion(int[] array, int endIndex, int checkingIndex) {
        if (array[endIndex] <= array[checkingIndex]) return checkingIndex;
        checkingIndex = findIndexRecursion(array, endIndex, checkingIndex + 1);
        return checkingIndex;
    }

    private static void move(int[] array, int numberFromIndex, int numberToIndex) {
        int temp1 = array[numberFromIndex];
        moveRecursion(array, numberFromIndex,numberToIndex,temp1);
    }

    private static void moveRecursion(int[] array,int numberFromIndex,int numberToIndex,int temp1) {
        if (numberFromIndex < numberToIndex) return;
        int temp2 = array[numberToIndex];
        array[numberToIndex] = temp1;
        temp1 = temp2;
        moveRecursion(array,numberFromIndex,numberToIndex+1,temp1);
    }
}
