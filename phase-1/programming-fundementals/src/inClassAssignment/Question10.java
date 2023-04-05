package inClassAssignment;
import string.StringDemo2;
import java.util.Arrays;
import java.util.Scanner;

public class Question10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two digit number here: ");
        int input = scanner.nextInt();
        boolean condition = isPalindrome(input);
        System.out.printf("Is %s palindrome? = %s",input,condition);
    }
    public static boolean isPalindrome(int num) {
        var numArray1=new int[0];
        int i=0;
        while (num != 0) {
            var numArray2 = new int[numArray1.length + 1];
            for (int j = 0; j < numArray1.length; j++) {
                numArray2[j] = numArray1[j];
            }
            numArray2[numArray2.length-1]=num%10;
            numArray1 = numArray2;
            num=num/10;
        }
        var reverseArray = revereseArray(numArray1);
        var isSame = isSame(reverseArray, numArray1);
        return isSame;

    }
    public static int[] revereseArray(int[] number) {
        int temp=0;
        var reverseArray = new int[number.length];
        for (int i = 0; i < reverseArray.length; i++) {
            reverseArray[i] = number[reverseArray.length - 1 - i];
        }
        return reverseArray;

        }
        

    public static boolean isSame(int[] revereseArray,int[]numberArray) {
        boolean condition=true;
        for (int i = 0; i < revereseArray.length; i++) {
            if (revereseArray[i] != numberArray[i]) {
                condition=false;
                break;
            }
        }
        return condition;

    }
}
