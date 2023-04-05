package inClassAssignment;

import java.util.Arrays;

public class Question01 {
    public static void main(String[] args) {
        var numbers = new int[]{12, 34, -7, 90, 0, 6788, 90,45455};
        var minMaxArray = findMinMax(numbers);
        System.out.println(Arrays.toString(minMaxArray));

    }

    public static int[] findMinMax(int[] numbs) {
        var minMaxArray = new int[2];
        int i = 1;
        int min = numbs[0];
        int max = numbs[0];

        do {
            if (min > numbs[i]) {
                min = numbs[i];
            }
            if (max < numbs[i]) {
                max = numbs[i];
            }
            ++i;

        } while (i < numbs.length );

        minMaxArray[0] = min;
        minMaxArray[1] = max;
        return minMaxArray;
    }
}
