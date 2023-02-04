package practice;

import java.util.Arrays;

public class SelectionSortMaxRecursion {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,4,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printSort(array);
    }

    public static void printSort(int[] array) {
        recursion1(array, array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void recursion1(int[] array,int i) {
        if (i == 0) return;
        int[] maxDetails = recursion2(array, i,array[i], i);
        int temp = array[i];
        array[i] = maxDetails[0];
        array[maxDetails[1]] = temp;
        recursion1(array, i-1);
    }

    public static int[] recursion2(int[] array,int j,int max, int maxIndex) {
        if (j < 0 ) return new int[]{max, maxIndex};
        int[] maxDetails = recursion2(array, j - 1, max, maxIndex);
        if (maxDetails[0] < array[j]) {
            maxDetails[0] = array[j];
            maxDetails[1] = j;
        }
        return maxDetails;
    }

}
