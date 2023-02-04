package practice;

import java.util.Arrays;

public class SelectionSortMinRecursion {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        recursion1(array,0);
        System.out.println(Arrays.toString(array));
    }

    public static void recursion1(int[] array,int i) {
        if (i == array.length-1) return;
        int j = i;
        int[] minDetails = recursion2(array, j, array[i], i);
        if (array[i] > minDetails[0]) {
            int temp = array[i];
            array[i] = minDetails[0];
            array[minDetails[1]] = temp;
        }
        recursion1(array, i+1);

    }

    public static int[] recursion2(int[] array, int j, int min, int minIndex) {
        if (j == array.length) return new int[]{min, minIndex};
        if (min > array[j]) {
            min = array[j];
            minIndex = j;
        }
        int[] minDetails = recursion2(array, j + 1, min, minIndex);
        return minDetails;
    }

}
