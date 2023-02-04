package practice;

public class LongestTextForEach {
    public static void main(String[] args) {
        String[] array = {"ab", "abcd", "abcdefghi", "ab", "abcdef", "abc"};
        printText(array);
    }

    public static void printText(String[] array) {
        int maxLength = 0;
        int index = 0;
        int maxIndex = 0;
        String maxString="";
        for (String s : array) {
            if (s.length() > maxLength) {
                maxString = s;
                maxLength = s.length();
                maxIndex = index;
            }
            index++;
        }
        System.out.println(maxString);
        System.out.println(maxIndex);
        System.out.println(maxLength);
    }

}
