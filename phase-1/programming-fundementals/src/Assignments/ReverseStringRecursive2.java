package practice;

public class ReverseStringRecursive2 {
    public static void main(String[] args) {
        String str = "abcDe";
        printReverse(str);
    }

    public static void printReverse(String str) {
        str = reverseString(str);
        System.out.println(str);
    }

    public static String reverseString(String str) {
        char[] array = str.toCharArray();
        if (array.length == 0) return "String is empty";
        str = recursiveReverse(array, 0, "");
        return str;
    }

    private static String recursiveReverse(char[] array, int index, String str) {
        if (index == array.length) return "";
        str += recursiveReverse(array, index + 1, str);
        str += array[index];
        return str;
    }
}
