package inClassAssignment;

import java.util.Arrays;
import java.util.Scanner;

public class Question08 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        String input=scanner.nextLine().trim();
        String[] inputArray = input.split(" ");
        String[] inputLowerCaseArray = toLowerCase(inputArray);
        String[] membersInArray = membersInArry(inputLowerCaseArray);
        String[] occurences = occurrence(inputLowerCaseArray, membersInArray);
        String[][] final2DArray = final2DArray(occurences, membersInArray);
        printArray(final2DArray);
    }

    public static String[] toLowerCase(String[] inputArray) {
        String[] inputLowerCaseArray = new String[inputArray.length];
        for (int i = 0; i < inputLowerCaseArray.length; i++) {
            inputLowerCaseArray[i] = (inputArray[i]).toLowerCase();
        }
        return inputLowerCaseArray;
    }

    public static String[] membersInArry(String[] inputLowerCaseArray) {

        String[] membersInArry = new String[inputLowerCaseArray.length];
        int k=0;

        for (int i = 0; i < inputLowerCaseArray.length; i++) {
            boolean condition=true;
            for (int j = 0; j < inputLowerCaseArray.length; j++) {
                if ((inputLowerCaseArray[i].equals(membersInArry[j]))) {
                    condition=false;
                    break;

                }
            }
            if (condition) {
                membersInArry[k] = inputLowerCaseArray[i];
                ++k;
            }

        }
        return membersInArry;

    }

    public static String[] occurrence(String[] inputLowerCaseArray,String[]membersInArry) {
        String[] occurence = new String[membersInArry.length];
        int k=0;
        for (String m : membersInArry) {
            int count=0;
            if (m == null) {
                break;
            }
            for (String i : inputLowerCaseArray) {
                if (i.equals(m)) {
                    ++count;
                }
            }
            occurence[k]=Integer.toString(count);
            ++k;
        }

        return occurence;

    }
    public static String[][] final2DArray(String[] occurrence, String[] membersInArray) {
        int count =0;
        for (int i = 0; i < membersInArray.length; i++) {
            if(membersInArray[i]==null)break;
            else if (!occurrence[i].equals("1")) {
                ++count;

            }
        }
        String[][] final2DArray = new String[count][2];
        int k=0;
        for (int i = 0; i < occurrence.length; i++) {
            if(occurrence[i]==null)break;
            if(!occurrence[i].equals("1"))
            {
                final2DArray[k][0] = membersInArray[i];
                final2DArray[k][1] = occurrence[i];
                ++k;

            }
        }
        return final2DArray;
    }

    public static void printArray(String[][] final2DArray) {
        if (final2DArray.length == 0) {
            System.out.println("No duplications");
        } else {
            for (int i = 0; i < final2DArray.length; i++) {
                System.out.printf("%s   -  %s", final2DArray[i][0], final2DArray[i][1]);
            }
        }
    }
}
