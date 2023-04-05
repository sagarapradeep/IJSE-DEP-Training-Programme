package inClassAssignment;

import java.util.Arrays;

public class Question06 {
    public static void main(String[] args) {
        var numbers = new int[]{12, 34, 45, 45, 67, 45, 56};
        System.out.println(Arrays.toString(sort(numbers)));

    }

    public static int[] sort(int[] numbs) {
        int i = numbs.length-1;
        int j = 0;
        int max=0;
        int maxIndex=0;
        do {
            max = numbs[i];
            j=i-1;
            do {
                if (max < numbs[j]) {
                    max = numbs[j];
                    maxIndex=j;
                }
                --j;

            } while (j>-1);
            int temp=numbs[maxIndex];
            numbs[maxIndex]=numbs[i];
            numbs[i]=temp;

            --i;
        } while (i>0);

        return numbs;
    }
}
