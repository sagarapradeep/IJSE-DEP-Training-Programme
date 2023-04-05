package inClassAssignment;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Question05 {
    public static void main(String[] args) {
        int inputNumber=12;
        var numbers = new int[]{12, 34, 45, 45, 67, 45, 56};
        var sortedNumbs = bubbleSort(numbers);
        var condition = find(sortedNumbs,inputNumber);
        System.out.println(condition);
    }

    public static int[] bubbleSort(int[] numbs) {
        final int Numb_Length = numbs.length;
        for (int i = 0; i < Numb_Length; i++) {
            for (int j = 0; j < Numb_Length - 1 - i; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    int temp = numbs[j + 1];
                    numbs[j + 1] = numbs[j];
                    numbs[j] = temp;
                }
            }
        }
        return numbs;
    }

    public static boolean find(int[] sortedNumbs,int inputNumber) {
        int start=0;
        int end=sortedNumbs.length-1;
        int middle;

        while (true) {
            middle=(start+end)/2;
            if (sortedNumbs[middle] == inputNumber) {
                return true;
            }
            if (middle == start) {
                return false;

            } else if (sortedNumbs[middle] > inputNumber) {
                middle=end;
            } else if (sortedNumbs[middle] < inputNumber) {
                middle=start;
            }

        }


    }
}
