package test;

import java.lang.reflect.Array;
import java.util.Arrays;

import algorithm.MyTableView;

public class DuplicationFinderUsingDynamicArray {

    public static void main(String[] args) {
        var input = new int[]{12, 12, 91,78,90,90,12,90,12,-1,2,-1};
        var inputStrArray = inputToStrArray(input);
        var final2DArray = occurrenceAndMembers(inputStrArray);
        printArray(final2DArray);
    }

    public static String[] inputToStrArray(int[] input) {
        var inputStrArray = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            inputStrArray[i] = input[i] + "";
        }
        return inputStrArray;
    }

    public static String[][] occurrenceAndMembers(String[] inputToStrArray) {
        var members = new String[0];
        var occurrence = new String[0];
        int k=0;

        for (int i = 0; i < inputToStrArray.length; i++) {
            int count = 1;
            boolean condition = true;
            for (int j = i+1; j < inputToStrArray.length; j++) {
                if (inputToStrArray[i].equals(inputToStrArray[j])) {
                    ++count;
                }
            }
            for (int j = 0; j < members.length; j++) {
                if (members[j] == null) {
                    break;
                } else if (members[j].equals(inputToStrArray[i])) {
                    condition=false;
                    break;
                }
            }
            condition = condition && (count > 1);
            if (condition) {

                members = dynamicArray(inputToStrArray[i], members);
                occurrence = dynamicArray(Integer.toString(count), occurrence);
                ++k;
            }
        }
        var final2DArray = final2DArray(occurrence, members);
        return final2DArray;
    }

    public static String[] dynamicArray(String element,String[]tempArray) {
        var dynamicArray = new String[tempArray.length + 1];
        for (int i = 0; i < tempArray.length; i++) {
            dynamicArray[i] = tempArray[i];
        }
        dynamicArray[dynamicArray.length - 1] = element;
        return dynamicArray;
    }

    public static String[][] final2DArray(String[] occurrence, String[] members) {
        String[][] final2DArray = new String[occurrence.length][2];
        for (int i = 0; i < final2DArray.length; i++) {
            final2DArray[i][0] = members[i];
            final2DArray[i][1] = occurrence[i];
        }
        return final2DArray;

    }

    public static void printArray(String[][] final2DArray) {
        MyTableView.printTableCommand(new String[]{"Numbers","Occurrences"},final2DArray);

    }

}



