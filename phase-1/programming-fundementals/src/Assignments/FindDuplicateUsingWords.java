package practice;

public class FindDuplicateUsingWords {
    public static void main(String[] args) {
        String input = "Gayashan Dananjaya Balasuriya Dananjaya Gayashan Gayashan ";
        printTable(input);
    }

    public static void printTable(String input) {
        String[] splitArray = splitArray(input);


//        String[] newArray = dynamicArray(new String[] {"def",""},"abc");


        String[] uniqueWordsArray = uniqueWords(splitArray);
        String[][] totalCount = totalCount(splitArray, uniqueWordsArray);
        String[][] filteredArray = filterArray(totalCount);
        CLITable.printTable(new String[]{"Word", "Count"}, filteredArray);
    }

    private static String[] splitArray(String input) {
        String str = "";
        String[] newArray = {};
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                if (str.length() == 0) continue;
                newArray = dynamicArray(newArray, str);
                str = "";
            }
            if (input.charAt(i) != ' '){ str += Character.toString(input.charAt(i));}
            if (i == input.length()-1) newArray = dynamicArray(newArray, str);
        }
        return newArray;
    }

    private static String[] uniqueWords(String[] array) {
        String[] newArray = {};
        loop1:
        for (int i = 0; i < array.length; i++) {
            loop2:
            for (int j = 0; j < newArray.length; j++) {
                if (array[i].equals(newArray[j])) continue loop1;
            }
            newArray = dynamicArray(newArray, array[i]);
        }
        return newArray;
    }

    private static String[][] totalCount(String[] splitArray, String[] uniqueArray) {
        String[][] newArray = new String[uniqueArray.length][2];
        for (int i = 0; i < uniqueArray.length; i++) {
            int count = 0;
            for (int j = 0; j < splitArray.length; j++) {
                if (uniqueArray[i].equals(splitArray[j])) count++;
            }
            newArray[i][0] = uniqueArray[i];
            newArray[i][1] = Integer.toString(count);
        }
        return newArray;
    }

    private static String[][] filterArray(String[][] totalCountArray) {
        String[][] newArray = {};
        for (int i = 0; i < totalCountArray.length; i++) {
            if (!(totalCountArray[i][1].equals("1"))) {
                newArray = dynamicArray2(newArray, totalCountArray[i]);
            }
        }
        return newArray;
    }

    private static String[] dynamicArray(String[] array, String str) {
        String[] newArray = new String[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = str;
        return newArray;
    }

    private static String[][] dynamicArray2(String[][] array, String[] strArray) {
        String[][] newArray = new String[array.length + 1][];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = strArray;
        return newArray;
    }
}
