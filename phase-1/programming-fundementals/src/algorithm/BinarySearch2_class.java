package algorithm;

import java.util.Scanner;

public class BinarySearch2_class
{
    public static void main(String[] args) {
        int[] numbs = new int[]{-3, 2, 3, 5, 7, 8, 10, 11};
        System.out.print("Enter number to be searched: ");
        var scanner = new Scanner(System.in);
        int search = scanner.nextInt();

        if (search > numbs[numbs.length - 1] || search < numbs[0]) {
            System.out.println("Not found! ");
            return;

        }
        int start=0;
        int end=numbs.length;

        while (start<end) {
            int middle=(start+end)/2;

            if (numbs[middle] == search) {
                System.out.printf("%s Found!",middle);
                return;
            } else if (numbs[middle]<search) {
                start=middle+1;

            }else{
                end=middle;
            }
        }
        System.out.println("Not found!");

    }
}
