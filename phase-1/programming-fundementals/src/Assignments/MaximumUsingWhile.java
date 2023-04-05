package practice;

public class MaximumUsingWhile {
    public static void main(String[] args) {
        int[] array = new int[] {12, 10,24,34,47,73,38, -10, 62,58,34,24,47,62,34,94,100};
        printMax(array);
    }

    public static void printMax(int[] array) {
        if (array.length == 0) {
            System.out.println("Empty list");
            return;
        }
        int max = findMax(array);
        System.out.println(max);
    }

    public static int findMax(int[] array) {
        int i = 0;
        int max = array[0];
        while (i < array.length) {
            if (max < array[i]) max = array[i];
            i++;
        }
        return max;
    }

}
