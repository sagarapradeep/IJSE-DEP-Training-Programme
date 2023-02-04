import java.util.Arrays;
import java.util.Scanner;

public class LoopDemo3
{
    public static void main(String[] args) {
        boolean condition=true;
        Scanner scanner = new Scanner(System.in);
        String input;
        int[] array1 = new int[0];

        while (condition) {
            System.out.print("Enter number here (q to quite the program): ");
            input = scanner.nextLine();
            if (input.equals("q")) {
                condition = false;
            } else {
                int[] newArray = new int[array1.length + 1];
                int j=0;
                while (j < newArray.length - 1) {
                    newArray[j]=array1[j];
                    j++;
                }
                newArray[newArray.length-1]=Integer.parseInt(input);
                array1=newArray;


            }

        }
        System.out.println(Arrays.toString(array1));

    }

}
