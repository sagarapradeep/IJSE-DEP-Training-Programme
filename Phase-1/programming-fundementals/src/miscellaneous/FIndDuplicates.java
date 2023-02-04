package miscellaneous;
import string.TableDemo;

import java.util.Arrays;

public class FIndDuplicates {
    public static void main(String[] args) {
        var numbs=new int[]{-5,-2,3,22,5,74,5,2,3,10,25,71,80};
        var numb=new int[]{5,6,6,1,8,7,4};

        String[] numbString = intToString(numbs);
        String[] elementsInArray=elementsInArray(numbString);


        String[] occurances = occurances(numbString, elementsInArray);
        String[][] finalArray = finalStringArray(elementsInArray,occurances);

        System.out.println(Arrays.deepToString(occurances));
        System.out.println(Arrays.deepToString(elementsInArray));

        printTable1(new String[]{"N","O"},finalArray);

    }

    public static void printTable1(String[] data,String[][] finalArray) {
        TableDemo.printTable(data,finalArray);

    }

    public static  String[] intToString(int[] numbs) {
        String[] numbString = new String[numbs.length];
        for (int i = 0; i < numbs.length; i++) {
            numbString[i] = Integer.toString(numbs[i]);

        }
        return numbString;

    }

    public static String[] elementsInArray(String[] numbString) {
        String[] elementsInInput = new String[numbString.length];
        int k = 0;

        for (int i = 0; i < numbString.length; i++) {
            boolean condition = true;


            for (int j = 0; j < numbString.length; j++) {
                if (elementsInInput[j] == null) continue;
                if ((elementsInInput[j]).equals(numbString[i])) {
                    condition = false;
                    break;

                }
            }
            if (condition == true) {
                elementsInInput[k] = numbString[i];
                ++k;
            }

        }

        return elementsInInput;

    }

    public static String[] occurances(String[]numbsString, String[]elementsInArray) {
        String[] occurances = new String[elementsInArray.length];
        int k=0;
        for (String e : elementsInArray) {
            if(e==null) break;
            int count=0;
            for (String i : numbsString) {
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
    public static String[][] finalStringArray(String[] elementsInArray, String[] Occurances) {
        int count =0;
        for (String c : Occurances) {
            if((c==null)) break;
            else{
                if(c.equals("1"))continue;;
                ++count;

            }

        }
        System.out.println("Count " + count);

        String[][] final2DArray = new String[count][2];
        int j=0;
        for (int i = 0; (i < Occurances.length&&j!=count); i++) {
            final2DArray[j][0] = elementsInArray[i];
            final2DArray[j][1] = Occurances[i];
            ++j;

        }
        return final2DArray;

    }


}
