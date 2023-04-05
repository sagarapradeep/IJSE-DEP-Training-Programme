package practice;

public class MinimumForEach {
    public static void main(String[] args) {
        int[] array = new int[] {10,24,34,47,73,38,62,58,0, -10, 34,24,47,62,34,94,100};
        printMin(array);
    }

    public static void printMin(int[] array) {
        int min = findMinimum(array);
        System.out.println(min);
    }

    public static int findMinimum(int[] array) {
        int min = array[0];
        for (int item : array) {
            if (min > item) min = item;
        }
        return min;
    }

}
