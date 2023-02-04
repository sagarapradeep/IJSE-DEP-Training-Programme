package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class DuplicationFinderForInteger {
    public static void main(String[] args) {
        var numArray = new int[]{12, 34, 56, 77, 56, 55, 4, 34, 4, 4, 4};
        printTable(numArray);
    }

    public static void printTable(int[]numArrray) {

        String[] inputStrArray = inputStr(numArrray);
        String[] membersInArray = membersInArry(inputStrArray);


        String[] occurence = occurrence(inputStrArray,membersInArray);
        String[][]final2DArray=final2DArray(occurence,membersInArray);

        MyTableView.printTableCommand(new String[]{"Number","Occurrence"},final2DArray);

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

    public static String[] membersInArry(String[] inputStrArray) {

        String[] membersInArry = new String[inputStrArray.length];
        int k=0;

        for (int i = 0; i < inputStrArray.length; i++) {
            boolean condition=true;
            for (int j = 0; j < inputStrArray.length; j++) {
                if ((inputStrArray[i].equals(membersInArry[j]))) {
                    condition=false;
                    break;

                }
            }
            if (condition) {
                membersInArry[k] = inputStrArray[i];
                ++k;
            }

        }
        return membersInArry;

    }

    public static String[] occurrence(String[] inputStrArray,String[]membersInArry) {
        String[] occurence = new String[membersInArry.length];
        int k=0;
        for (String m : membersInArry) {
            int count=0;
            if (m == null) {
                break;
            }
            for (String i : inputStrArray) {
                if (i.equals(m)) {
                    ++count;
                }
            }
            occurence[k]=Integer.toString(count);
            ++k;
        }

        return occurence;


    }


    public static String[] inputStr(int[] inputIntArray) {
        String[] inputStrArry = new String[inputIntArray.length];
        for (int i = 0; i < inputIntArray.length; i++) {
            inputStrArry[i] = Integer.toString(inputIntArray[i]);

        }
        return inputStrArry;

    }

}


