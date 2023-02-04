package algorithm;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        var numbers = new int[]{12, 21, 34, 33, 44, -78, 4, 1, -1,0, 90};

//        for (int i = 0; i < numbers.length - 1; i++) {                  //bubble sort
//            for (int j = 0; j < numbers.length - i-1; j++) {
//                if (numbers[j] > numbers[j + 1]) {
//                    int temp=numbers[j];
//                    numbers[j] = numbers[j + 1];
//                    numbers[j + 1] = temp;
//                }
//            }
//        }
//
//
//        for (int i = 0; i < numbers.length; i++) {                  //selection sort
//            int min = numbers[i];
//            int minIndex = i;
//            for (int j = i+1; j < numbers.length; j++) {
//                if (min > numbers[j]) {
//                    min = numbers[j];
//                    minIndex = j;
//                }
//
//            }
//            int tempNumber = numbers[i];
//            numbers[i] = min;
//            numbers[minIndex] = tempNumber;
//        }



        /*Insertion sort*/

        for (int i = 1; i < numbers.length; i++) {
            int minIndex=0;
            int selectedNum = numbers[i];
            if (numbers[i - 1] > numbers[i]) {
                for (int j = 0; j < i; j++) {
                    if (numbers[i] < numbers[j]) {
                        minIndex = j;
                        break;

                    }
                }
                for (int j = i; j > minIndex; j--) {
                    numbers[j] = numbers[j - 1];
                }
                numbers[minIndex] = selectedNum;
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
