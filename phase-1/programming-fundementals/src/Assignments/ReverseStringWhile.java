package practice;

public class ReverseStringWhile {
    public static void main(String[] args) {
        String str = "abcDE";
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
        while (index < array.length / 2) {
            temp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length-1-index++] = temp;
        }

        index = 0;
        String newString = "";
        while (index < array.length) {
            newString += array[index++];
        }
        return newString;



    }

}
