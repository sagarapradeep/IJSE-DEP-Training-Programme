import java.util.Arrays;

public class LoopDemo13
{
    public static void main(String[] args) {
        var numbs = new int[]{10, 25, 30, 0, -25, -4, 15, 20};
        var newNumbs = new int[numbs.length];

        int max=0;
        int maxIndex=0;
        int i=numbs.length-1;
        int j=0;

        /*using while loop*/
        while (i>=0) {
            j=i-1;
            max = numbs[i];
            maxIndex = i;
            while (j >= 0) {
                if (max < numbs[j]) {
                    max = numbs[j];
                    maxIndex=j;
                }

                j--;
            }
            int tempNum = numbs[i];
            numbs[i]=max;
            numbs[maxIndex]=tempNum;

            i--;
        }

        System.out.printf("Using while loop %s",Arrays.toString(numbs));

        /*using for loop*/

        for (int k = numbs.length-1; k <= 0; k--) {
            max = numbs[k];
            maxIndex = k;
            for (int l = k - 1; l <= 0; l++) {
                if (max < numbs[l]) {
                    max = numbs[l];
                    maxIndex = l;
                }
                l--;
            }
            int tempNum = numbs[i];
            numbs[i] = max;
            numbs[maxIndex]=tempNum;

            k--;
            
        }
        System.out.printf("\nUsing for loop %s",Arrays.toString(numbs));

    }
}
