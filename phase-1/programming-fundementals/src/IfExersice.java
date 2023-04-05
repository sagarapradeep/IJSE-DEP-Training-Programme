import java.util.Scanner;

public class IfExersice
{
    public static void main(String[] args) {
        System.out.print("Enter student name: ");

        Scanner scanner=new Scanner(System.in);
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age =scanner.nextInt();

        if(age<=18)System.err.println("Invalid age");
        if(age>40)System.err.println("Invalid age");
//        else System.out.println("Successfully added");

        if (age>18)
        {
            if(age<=40) System.out.printf("User %s successfully added!",name);
        }
    }
}
