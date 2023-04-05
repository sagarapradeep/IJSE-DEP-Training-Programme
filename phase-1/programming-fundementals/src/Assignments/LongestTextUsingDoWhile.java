package practice;

public class LongestTextUsingDoWhile {
    public static void main(String[] args) {
        String[] array = {"ab", "abcd", "abcdefghi", "ab", "abcdef", "abc"};
        printText(array);
    }

    public static void printText(String[] array) {
        int maxLength = 0;
        int index = 0;
        int maxIndex = 0;
        String maxString="";

        do {
            if (maxLength < array[index].length()) {
                maxLength = array[index].length();
                maxString = array[index];
                maxIndex = index;
            }
        } while (++index < array.length);
        System.out.println(maxString);
        System.out.println(maxIndex);
        System.out.println(maxLength);
    }

}
