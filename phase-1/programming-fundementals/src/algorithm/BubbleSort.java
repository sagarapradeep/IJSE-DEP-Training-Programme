package algorithm;

import java.util.Arrays;

public class BubbleSort
{
    public static void main(String[] args) {
        int[] numbs=new int[]{12,5,4,3,34,45,23};
        int[] numb=new int[]{12,5,4,4,345,45,23};

        for (int i = 0; i < numbs.length; i++) {
            for (int j = 0; j < numb.length-1-i; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    int temp = numbs[j+1];
                    numbs[j+1] = numbs[j];
                    numbs[j]=temp;

                }
            }

        }
//        System.out.println(Arrays.toString(numb));


        int i=0;
        do{
            System.out.println(i);
            int j=0;
            do{

                if (numb[j] > numb[j + 1]) {
                    int temp = numb[j+1];
                    numb[j+1] = numb[j];
                    numb[j]=temp;
                }
                j++;
            }while(j<numb.length-1-i);

            ++i;
        }while(i<numb.length-1);

        System.out.println(Arrays.toString(numb));

    }

}
