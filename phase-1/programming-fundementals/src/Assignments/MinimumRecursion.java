package practice;

public class MinimumRecursion {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printMin(array);
    }

    public static void printMin(int[] array) {
        int min = recursive(array,0,array[0]);
        System.out.println(min);
    }

//    public static int findMin(int[] array) {
//
//    }

    private static int recursive(int[] array, int index, int assumedMin) {
        if (index == array.length) return assumedMin;
        assumedMin = recursive(array, index + 1, assumedMin);
        if (assumedMin > array[index]) assumedMin = array[index];
        return assumedMin;
    }


}
