package inClassAssignment;

import java.util.Arrays;

public class Question07 {
    public static void main(String[] args) {
        var numbers = new int[]{12, 34, 900,45,2};

        System.out.println(Arrays.toString(sort(numbers)));
    }

    public static int[] sort(int[] numbs) {
        int min=0;
        int temp=0;
        for (int i = numbs.length - 1; i > 0; i--) {
            for (int j = numbs.length-1; j >numbs.length-i-1 ; j--) {
                if (numbs[j - 1] > numbs[j]) {
                    temp = numbs[j - 1];
                    numbs[j - 1] = numbs[j];
                    numbs[j]=temp;

                }

            }


        }
        return numbs;
    }
}
