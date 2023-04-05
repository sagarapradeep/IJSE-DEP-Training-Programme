package practice;

public class LongestTextUsingWhile {
    public static void main(String[] args) {
        String[] array = {"ab", "abcd", "abcdefghi", "ab", "abcdef", "abc"};
        printText(array);
    }

    public static void printText(String[] array) {
        int maxLength = 0;
        int index = 0;
        int maxIndex = 0;
        String maxString="";
        while (index < array.length) {
            if (array[index].length() > maxLength) {
                maxLength = array[index].length();
                maxString = array[index];
                maxIndex = index;
            }
            index++;
        }
        System.out.println(maxString);
        System.out.println(maxIndex);
        System.out.println(maxLength);
    }

}
