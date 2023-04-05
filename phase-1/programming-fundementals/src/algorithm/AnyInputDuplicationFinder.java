package algorithm;

import java.util.Arrays;
import java.util.Scanner;
import algorithm.MyTableView;

public class AnyInputDuplicationFinder {
    public static void main(String[] args) {
        printTable();
    }

    public static void printTable() {

        char[] input=input();
        String[] inputStrArray = inputStr(input);
        String[] membersInArray = membersInArry(inputStrArray);


        String[] occurence = occurrence(inputStrArray,membersInArray);
        String[][]final2DArray=final2DArray(occurence,membersInArray);

        MyTableView.printTableCommand(new String[]{"Number","Occurrence"},final2DArray);

    }


    /*Represent members and their occurrences in 2D array, only 1+ occurrences considered*/
    public static String[][] final2DArray(String[] occurrence, String[] membersInArray) {
        int count =0;                                           /*Take 2D array length*/
        for (int i = 0; i < membersInArray.length; i++) {
            if(membersInArray[i]==null)break;
            else if (!occurrence[i].equals("1")) {
                ++count;

            }

        }
        String[][] final2DArray = new String[count][2];     //copy members and occurrences to 2D Array
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

    public static String[] membersInArry(String[] inputStrArray) {      /*Take the members in input array to new array*/

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

    public static String[] occurrence(String[] inputStrArray,String[]membersInArry) {       /*Find occurences of each member*/
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


    public static char[] input() {              /*Take the input from user in String format*/
        var scanner = new Scanner(System.in);
        System.out.print("Enter amy input: ");
        String input = scanner.nextLine();
        char[] inputCharArray = input.toCharArray();        /*converted to char array and return*/
        return inputCharArray;
    }

    public static String[] inputStr(char[] inputCharArry) {     /*Covert char array to String array*/
        String[] inputStrArry = new String[inputCharArry.length];
        for (int i = 0; i < inputCharArry.length; i++) {
            inputStrArry[i] = Character.toString(inputCharArry[i]);

        }
        return inputStrArry;

    }


}
