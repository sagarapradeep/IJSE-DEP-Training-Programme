package practice;

import java.util.Arrays;

public class InsertionSortBinaryRecursion {
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
        int numberToIndex = findIndex(array, index);
        move(array, index, numberToIndex);
        sortRecursion(array, index + 1);
    }

    private static int findIndex(int[] array, int endIndex) {
        int leftIndex = 0;
        int rightIndex = endIndex;
        int numberToIndex = findIndexRecursion(array, endIndex, leftIndex, rightIndex,-1);
        return numberToIndex;

    }

    private static int findIndexRecursion(int[] array, int endIndex, int leftIndex, int rightIndex,int answer) {
        int middleIndex = (leftIndex + rightIndex) / 2;
        if (array[middleIndex]==array[endIndex]) return middleIndex;
        if (middleIndex == leftIndex) {
            if (array[middleIndex] < array[endIndex]) return rightIndex;
            else return middleIndex;
        }
        if (array[middleIndex] < array[endIndex]) leftIndex = middleIndex;
        else rightIndex = middleIndex;
        answer = findIndexRecursion(array, endIndex, leftIndex, rightIndex, answer);
        return answer;
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
