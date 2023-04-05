package practice;

public class MinimumUsingWhile {
    public static void main(String[] args) {

        int[] array = new int[] {10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printMin(array);
    }

    public static void printMin(int[] array) {
        int min = findMin(array);
        System.out.println(min);
    }

    public static int findMin(int[] array) {
        int min = array[0];
        int iteration = 0;
        while (iteration < array.length) {
            if (min > array[iteration]) min = array[iteration];
            iteration++;
        }
        return min;
    }

}
