package practice;


public class BinarySearchUsingRecursion {
    public static void main(String[] args) {
        int[] array = new int[]{-10, 4, 10, 12, 24, 34, 34, 34, 38, 47, 47, 58, 62, 62, 73, 94, 100};
        printSearch(array,73);
    }

    public static void printSearch(int[] array, int number) {
        if (!rangeChecking(array, number)) {
            System.out.printf("The number %d is not within the limit", number);
            return;
        }
        int output = recursion(array, number, 0, array.length-1,-2);

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

    public static int recursion(int[] array, int number,int leftIndex, int rightIndex,int index) {
        int middleIndex = (leftIndex + rightIndex) / 2;
        if (array[rightIndex] == number) return rightIndex;
        if (array[middleIndex] == number) return middleIndex;
        if (array[middleIndex] < number) leftIndex = middleIndex + 1;
        else rightIndex = middleIndex - 1;
        if (leftIndex == middleIndex) return -1;
        index = recursion(array, number, leftIndex, rightIndex, index);
        return index;
    }
}
