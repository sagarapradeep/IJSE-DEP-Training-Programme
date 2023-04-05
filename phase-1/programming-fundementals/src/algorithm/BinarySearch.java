package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {                        //main method used to store array and take input
        int[] numbs = new int[]{-3, 2, 3, 5, 7,546,34,34,23,212,43,5,6,7,-23,34,66};
        System.out.print("Enter number to be searched:");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        printOutput(numbs, input);                      //call printOutput method

    }

    public static void printOutput(int[] numbs,int input) {             //print method
        int[] sortedNumArray = bubbleSort(numbs);                       //call method to sort the array
        String message = binarySearch(sortedNumArray,input);            //call binary search method
        System.out.println(message);                                        //get final message fom binary search method and print

    }

    public static int[] bubbleSort(int[] numbs) {
        final int Numb_Length=numbs.length;
        for (int i = 0; i < Numb_Length; i++) {                         //bubble sorting algorithm
            for (int j = 0; j < Numb_Length-1-i; j++) {
                if (numbs[j] > numbs[j + 1]) {
                    int temp = numbs[j+1];
                    numbs[j+1] = numbs[j];
                    numbs[j]=temp;
                }
            }
        }
        return numbs;
    }

    public static String binarySearch(int[] sortedArray,int input) {                //binary search method
        int start=0;
        int end = sortedArray.length-1;

        String message=null;
        while (true) {
            int middle = (start + end) / 2;
            if (input > sortedArray[end] || input < sortedArray[start]) {
                message=("Entered number not in the array! ");
                break;

            }else if (middle == start) {
                message=("Searched number not in the array!");
                break;
            }
            else if (sortedArray[middle] == input) {
                message=("Searched number index is "+ middle);
                break;
            } else if (sortedArray[middle] > input) {
                end=middle;
            } else if (sortedArray[middle] < input) {
                start = middle;
            }
        }
        return message;
    }
}
