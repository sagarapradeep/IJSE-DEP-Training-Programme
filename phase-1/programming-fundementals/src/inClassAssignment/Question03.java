package inClassAssignment;

import java.util.Arrays;

public class Question03 {
    public static void main(String[] args) {
        var numbers = new int[]{12, 34, 45, 56,98,-88};
        reverse(numbers);
        System.out.println(Arrays.toString(numbers));


    }

    public static void reverse(int[] numbers) {
        if (numbers.length % 2 == 0) {
            recursionReverseEvenLength(numbers, 0, numbers.length - 1);

        } else {
            recursionReverseOddLength(numbers,0,numbers.length-1);
        }
    }

    public static void recursionReverseEvenLength(int[] numbers,int start,int end) {
        if (start > end) {
            return;
        } else {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end]=temp;
        }
        recursionReverseEvenLength(numbers,++start,--end);
    }

    public static void recursionReverseOddLength(int[] numbers,int start,int end) {
        if (start == numbers.length/2) {
            return;
        } else {
            int temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end]=temp;
        }
        recursionReverseEvenLength(numbers,++start,--end);
    }
}
