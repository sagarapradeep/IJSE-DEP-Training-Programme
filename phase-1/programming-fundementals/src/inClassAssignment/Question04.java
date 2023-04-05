package inClassAssignment;

import java.util.Arrays;

public class Question04 {
    public static void main(String[] args) {
        String input = "something";
        int []charCodeArray=reverse(input);
        var reversedCharArray=intToCharArray(charCodeArray);

        System.out.println(Arrays.toString(reversedCharArray));

    }

    public static int[] reverse(String input) {
        var inputCharArray = strToCharArray(input);
        if (inputCharArray.length % 2 == 0) {
            recursionReverseEvenLength(inputCharArray, 0, inputCharArray.length - 1);
        } else {
            recursionReverseOddLength(inputCharArray, 0, inputCharArray.length - 1);
        }
        return charToIntArray(inputCharArray);

    }

    public static char[] strToCharArray(String input) {
        char[] inputCharArray = input.toCharArray();
        return inputCharArray;
    }

    public static void recursionReverseEvenLength(char[] numbers,int start,int end) {
        if (start > end) {
            return;
        } else {
            char temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end]=temp;
        }
        recursionReverseEvenLength(numbers,++start,--end);
    }

    public static void recursionReverseOddLength(char[] numbers,int start,int end) {
        if (start == numbers.length/2) {
            return;
        } else {
            char temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end]=temp;
        }
        recursionReverseEvenLength(numbers,++start,--end);
    }

    public static int[] charToIntArray(char[]inputCharArray) {

        var charCodeIntArray = new int[inputCharArray.length];
        int k=0;
        for (int i = 0; i < inputCharArray.length; i++) {
            k = inputCharArray[i];
            charCodeIntArray[i] = k;

        }
        return charCodeIntArray;
    }

    public static char[] intToCharArray(int[] CharCodeArray) {
        char[] reveresedCharArray = new char[CharCodeArray.length];

        for (int i = 0; i < reveresedCharArray.length; i++) {
            char letter = (char) CharCodeArray[i];
            reveresedCharArray[i]=letter;

        }
        return reveresedCharArray;

    }
}
