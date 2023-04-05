package algorithm;

import java.util.Arrays;
public class InsertionSort
{
    public static void main(String[] args) {
        int[] numbs = new int[]{12, 3, 4, 1, 33, 7867, -66,-9868,345,0,-66,456,345};

        for (int i = 1; i < numbs.length; i++) {
            int tempNumber=0;
            int tempIndex=0;
            if (numbs[i-1] > numbs[i]) {
                tempNumber = numbs[i];
                tempIndex = 0;
                for (int j = 0; j < i; j++) {
                    if (numbs[j] >= tempNumber) {
                        tempIndex=j;
                        for (int k = i ; k >j ; k--) {
                            numbs[k] = numbs[k-1];
                        }
                        break;
                    }
                }
                numbs[tempIndex]=tempNumber;


            }
        }
        System.out.println("Insertion sorted array"+Arrays.toString(numbs));

    }

}
