public class LoopDemo12
{
    public static void main(String[] args) {
        var numbs = new int[]{10, 25, 30, 0, -25, -4, 15, 20};
        int min=0;
        int minIndex = 0;
        int max=0;
        int maxIndex=0;
        int i=1;


        /*using while loop*/
        while (i < numbs.length) {
            if(i==1)
            {
                min = numbs[0];
                max = numbs[0];
            }
            else {
                if(min>numbs[i])
                {
                    min = numbs[i];
                    minIndex=i;
                }
                if(max<numbs[i])
                {
                    max = numbs[i];
                    maxIndex=i;
                }

            }

            i++;
        }

        System.out.printf("Min value using while loop: %s, Min index: %s \n", min, minIndex);
        System.out.printf("Max value using while loop: %s, Max index: %s \n", max, maxIndex);
        System.out.println("\n");

        /*Uisng for loop*/

        for (int j = 1; j < numbs.length; j++) {
            if (j == 1) {
                min = numbs[j];
                max = numbs[j];
            }
            else {
                if (min > numbs[j]) {
                    min = numbs[j];
                    minIndex = j;
                }
                if (max < numbs[j]) {
                    max = numbs[j];
                    maxIndex = j;
                }


            }
        }
        System.out.printf("Min value using for loop: %s, Min index: %s \n", min, minIndex);
        System.out.printf("Max value using for loop: %s, Max index: %s \n", max, maxIndex);
    }
}
