package algorithm;

import java.util.Arrays;
import java.util.Scanner;
import string.TableDemo;

public class DuplicationFinderFinal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter any input here: ");
        String input = scanner.nextLine();
        printTableDemo(input);

    }

    public static void printTableDemo(String input) {
        char[] inputCharArray = inputCharArray(input);
        String[] inputStringArray = inputCharArrayToString(inputCharArray);

        String[] elementsInInput = elementsInInput(inputStringArray);

        String[] occurances = occurances(inputStringArray, elementsInInput);

        String[][] finalArray = finalArray(elementsInInput, occurances);

        TableDemo.printTable(new String[]{"C","O"},finalArray);

    }

    public static char[] inputCharArray(String input) {
        char[] inputCharArray = input.toCharArray();
        return inputCharArray;
    }

    public static String[] inputCharArrayToString(char[] characterArray) {
        String[] inputCharArrayToString = new String[characterArray.length];
        for (int i = 0; i < characterArray.length; i++) {
            inputCharArrayToString[i] = Character.toString(characterArray[i]);
        }
        return inputCharArrayToString;
    }

    public static String[] elementsInInput(String[] inputStringArray) {
        String[] elementsInInput = new String[inputStringArray.length];
        int k = 0;

        for (int i = 0; i < inputStringArray.length; i++) {
            boolean condition = true;


            for (int j = 0; j < inputStringArray.length; j++) {
                if (elementsInInput[j] == null) continue;
                if ((elementsInInput[j]).equals(inputStringArray[i])) {
                    condition = false;
                    break;

                }
            }
            if (condition == true) {
                elementsInInput[k] = inputStringArray[i];
                ++k;
            }

        }

        return elementsInInput;
    }

//
    public static String[] occurances(String[] inputStringArray, String[] elementsInInput) {
        String[] occurances = new String[elementsInInput.length];
        int k=0;
        for (String e : elementsInInput) {
            if(e==null) break;
            int count=0;
            for (String i : inputStringArray) {
                if (e.equals(i)) {
                    count+=1;

                }
            }
            occurances[k] = Integer.toString(count);
            ++k;

        }
        return occurances;

    }
//
    public static String[][] finalArray(String[] elementsInInput, String[] occurances) {
        int count =0;
        for (String c : occurances) {
            if((c==null)) break;
            else{
                if(c.equals("1"))continue;;
                ++count;

            }

        }

        String[][] final2DArray = new String[count][2];
        int j=0;
        for (int i = 0; (i < occurances.length&&j!=count); i++) {
            if (occurances[i] == null && occurances.equals("1")) {
                continue;
            }
            else{
                final2DArray[j][0] = elementsInInput[i];
                final2DArray[j][1] = occurances[i];
                ++j;

            }
        }
        return final2DArray;

        }


    }





