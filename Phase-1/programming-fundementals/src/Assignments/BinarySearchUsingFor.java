package practice;

public class BinarySearchUsingFor {
    public static void main(String[] args) {
        int[] array = new int[]{-10, 4, 10, 12, 24, 34, 34, 34, 38, 47, 47, 58, 62, 62, 73, 94, 100};
        printSearch(array,100);
    }

    public static void printSearch(int[] array, int number) {
        if (!rangeChecking(array, number)) {
            System.out.printf("The number %d is not within the limit", number);
            return;
        }
        int output = search(array, number);

        if (output == -1) {
            System.out.printf("The number %d is not in the list", number);
        } else {
            System.out.printf("The number %d is in the index of %d",number, output);
        }
    }

    public static boolean rangeChecking(int[] array, int number) {
        if (number > array[array.length-1] || number < array[0]) return false;
        else return true;
    }

    public static int search(int[] array, int number) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        for (; true; ) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (array[rightIndex] == number) return rightIndex;
            if (array[middleIndex] == number) return middleIndex;
            if (array[middleIndex] < number) {
                leftIndex = middleIndex+1;
            } else rightIndex = middleIndex-1;
            if (leftIndex == middleIndex) return -1;
        }
    }

}
