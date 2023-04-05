package practice;

public class MaximumRecursion {
    public static void main(String[] args) {
        int[] array = new int[] {112, 10,24,34,47,73,380, -10, 62,58,34,24,47,62,34,94,100};
        printMax(array);
    }

    public static void printMax(int[] array) {
        int max = findMax(array);
        System.out.println(max);
    }

    public static int findMax(int[] array) {
        int max = recursive(array, 0, array[0]);
        return max;
    }

    private static int recursive(int[] array, int index, int max) {
        if (index == array.length) return max;
        if (array[index] > max) max = array[index];
        max = recursive(array, index + 1, max);
        return max;
    }

}
