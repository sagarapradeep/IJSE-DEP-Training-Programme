import java.util.Scanner;

public class SwitchStatement {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter your grade: ");
        char grade = scanner.next().charAt(0);

        //if statement
//        if (grade=='A'||grade=='a') System.out.println("A Pass!");
//        else if (grade=='B'||grade=='b') System.out.println("B Pass!");
//        else if (grade=='C'||grade=='c') System.out.println("C Pass!");
//        else if (grade=='S'||grade=='s') System.out.println("S Pass!");
//        else if (grade=='F'||grade=='f') System.out.println("Your fail!");
//        else System.out.println("Invalid grade! ");

        //switch statement
        switch (grade){
            case 'A': case 'a':
                System.out.println("A Pass!");
                break;
            case 'B': case 'b':
                System.out.println("B Pass!");
                break;
            case 'C': case 'c':
                System.out.println("C Pass!");
                break;
            case 'S': case 's':
                System.out.println("S Pass!");
                break;
            case 'F': case 'f':

                System.out.println("Fail!");
                break;

            default:
                System.out.println("Invalid grade!");
        }

    }
}
