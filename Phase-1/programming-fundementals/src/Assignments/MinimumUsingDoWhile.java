package practice;

public class MinimumUsingDoWhile {
    public static void main(String[] args) {
        int[] array = new int[] {-12, 10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printMin(array);
    }

    public static void printMin(int[] array) {
        int min;
        if (array.length > 0) {
            min = findMin(array);
            System.out.println(min);
        }else System.out.println("Empty list");
    }

    public static int findMin(int[] array) {
        int min = array[0];
        int i = 0;
        do {
            if (array[i] < min) min = array[i];
        } while (++i < array.length);
        return min;


    }

}
