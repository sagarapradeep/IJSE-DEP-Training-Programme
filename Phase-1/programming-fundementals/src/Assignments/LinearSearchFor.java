package practice;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearchFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = {1,2,3,4,7,3,6,5867,342,234,45,67,34,94,100};
        System.out.println(Arrays.toString(nums));
        System.out.print("Enter a number to search : ");
        int input = scanner.nextInt();
        numberSearch(nums,input);

    }

    public static void numberSearch(int[] array, int number) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.out.printf("The number %d is in the index of %d",number,i);
                return;
            }
        }
        System.out.printf("The number %d is not in the list",number);
        return;
    }

}
