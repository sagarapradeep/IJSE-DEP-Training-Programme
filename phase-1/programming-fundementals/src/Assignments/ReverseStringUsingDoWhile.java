package practice;

public class ReverseStringUsingDoWhile {
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
        do {
            char temp = array[index];
            array[index] = array[array.length - index - 1];
            array[array.length - index - 1] = temp;

        } while (++index < array.length / 2);

        index = 0;
        String newString = "";

        do {
            newString += array[index];
        } while (++index < array.length);

        return newString;
    }
}
