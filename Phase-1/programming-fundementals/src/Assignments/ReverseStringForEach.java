package practice;

import java.util.Arrays;

public class ReverseStringForEach {
    public static void main(String[] args) {
        String str = "abcD";
        printReverse(str);
    }

    public static void printReverse(String str) {
        str = reverse(str);
        System.out.println(str);
    }

    public static String reverse(String str) {
        char[] array = str.toCharArray();

        int index = 0;
        char temp;
        for (char item : array) {
            temp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = temp;
            if (index++ == array.length/2) break;
        }

        index = 0;
        String newString = "";
        for (char item : array) {
            newString += array[index++];
        }
        return newString;

    }

}
