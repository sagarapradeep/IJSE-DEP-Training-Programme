package practice;

public class ReverseStringFor {
    public static void main(String[] args) {
        String str = "AbCDeF";
        printReverse(str);
    }

    public static void printReverse(String str) {
        str = reverseString(str);
        System.out.println(str);
    }

    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        char temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = temp;
        }

        String newString = "";
        for (int i = 0; i < array.length; i++) {
            newString += array[i];
        }
        return newString;
    }

}
