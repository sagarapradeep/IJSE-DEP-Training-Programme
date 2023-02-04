import java.util.Scanner;

public class IfStatement
{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scanner.nextInt();

        if(number>50) System.out.println("Number is greater than 50");
        else if(number>15) System.out.println("Number is greater than 15");
        else if (number>5) System.out.println("Number is greater than 5");
        else if (number>0) System.out.println("Number is greater than 0");
        else System.out.println("Number is negetive");
    }
}
