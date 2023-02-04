package practice;

public class LongestTextRecursion {
    public static void main(String[] args) {
        String[] array = {"ab", "abcd", "abcdefghi", "ab", "abcdef", "abc"};
        printText(array);
    }

    public static void printText(String[] array) {
        int[] maxArray = recursion(array, array.length, 0,0,0);
        System.out.println(array[maxArray[1]]);
        System.out.println(maxArray[1]);
        System.out.println(maxArray[0]);
    }

    public static int[] recursion(String[] array, int arrayLength, int i,int maxLength, int maxIndex) {
        if (i==arrayLength) return new int[]{maxLength, maxIndex};
        if (array[i].length() > maxLength) {
            maxLength = array[i].length();
            maxIndex = i;
        }
        return recursion(array, arrayLength, i + 1, maxLength, maxIndex);
    }

}
