package practice;

public class FindDuplicateUsingNumber {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 2,2,3};
        printDuplicates(array);
    }

    public static void printDuplicates(int[] array) {
        String[] columnNames = {"Number", "Repetitions"};
        int[] uniqueNumbers = uniqueNumbers(array);
        int[][] totalCount = totalCount(uniqueNumbers, array);
        int[][] filteredArray = filter(totalCount);
        String[][] data = intToString(filteredArray);
        CLITable.printTable(columnNames,data);
    }


    private static int[] uniqueNumbers(int[] array) {
        int[] newArray = {};
        loop1:
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < newArray.length; j++) {
                if (array[i]==newArray[j]) continue loop1;
            }
            newArray = dynamicArray(newArray, array[i]);
        }
        return newArray;
    }

    public static int[][] totalCount(int[] uniqueNumbersArray,int[] array) {
        int[][] totalCount = new int[uniqueNumbersArray.length][2];
        for (int i = 0; i < uniqueNumbersArray.length; i++) {
            int count = 0;
            for (int i1 : array) {
                if (uniqueNumbersArray[i]==i1) count++;
            }
            totalCount[i][0] = uniqueNumbersArray[i];
            totalCount[i][1] = count;
        }
        return totalCount;
    }

    private static int[][] filter(int[][] array) {
        int singles = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][1] == 1) singles++;
        }
        int[][] newArray = new int[array.length - singles][2];
        int j =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][1] != 1) {
                newArray[j] = array[i];
                j++;
            }
        }
        return newArray;
    }

    private static String[][] intToString(int[][] array) {
        String[][] newArray = new String[array.length][2];
        for (int i = 0; i < array.length; i++) {
            newArray[i][0] = Integer.toString(array[i][0]);
            newArray[i][1] = Integer.toString(array[i][1]);
        }
        return newArray;
    }


    public static int[] dynamicArray(int[] array,int number) {
        int[] newArray = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = number;
        return newArray;
    }

}
