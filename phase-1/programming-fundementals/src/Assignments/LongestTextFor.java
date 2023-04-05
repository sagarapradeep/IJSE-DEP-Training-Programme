package practice;

public class LongestTextFor {
    public static void main(String[] args) {
        String[] array = {"ab", "abcd", "abcdefghi", "ab", "abcdef", "abc"};
        printText(array);
    }

    public static void printText(String[] array) {
        int maxLength = 0;
        int index = 0;
        String maxString="";
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > maxLength) {
                maxLength = array[i].length();
                maxString = array[i];
                index = i;
            }
        }
        System.out.println(maxString);
        System.out.println(index);
        System.out.println(maxLength);
    }

}
