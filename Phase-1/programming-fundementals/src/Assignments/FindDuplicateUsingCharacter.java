package practice;

public class FindDuplicateUsingCharacter {
    public static void main(String[] args) {
        String str = "Gayashan Dananjaya";
        printTable(str);
    }

    public  static void printTable(String input) {
        String uniqueCharacterString = uniqueCharacters(input);
        String[][] numberOfOccurrenceArray = numberOfOccurrences(uniqueCharacterString, input);
        String[][] duplicateArray = duplicateArray(numberOfOccurrenceArray);
        CLITable.printTable(new String[] {"Character", "Number"}, duplicateArray);

    }

    private  static String uniqueCharacters(String input) {
        String str = "";
        for (int i = 0; i < input.length(); i++) {
            if (!(str.contains(Character.toString(input.charAt(i)))) && input.charAt(i) != ' ') str += input.charAt(i);
        }
        return str;
    }

    private static String[][] numberOfOccurrences(String characterList, String input) {
        String[][] occurrences = new String[characterList.length()][2];
        for (int i = 0; i < characterList.length(); i++) {
            int number = 0;
            for (int j = 0; j < input.length(); j++) {
                if (characterList.charAt(i) == input.charAt(j)) number++;
            }
            occurrences[i][1] = Integer.toString(number);
            occurrences[i][0] = Character.toString(characterList.charAt(i));
        }
        return occurrences;
    }

    private static String[][] duplicateArray(String[][] numberOfOccurrences) {
        int length = 0;
        for (String[] stringArray : numberOfOccurrences) {
            if (Integer.parseInt(stringArray[1]) > 1) length++;
        }
        int index = 0;
        String[][] duplicateArray = new String[length][2];
        for (int i = 0; i < numberOfOccurrences.length; i++) {
            if (Integer.parseInt(numberOfOccurrences[i][1]) > 1) {
                duplicateArray[index++] = numberOfOccurrences[i];
            }
        }
        return duplicateArray;
    }

}
