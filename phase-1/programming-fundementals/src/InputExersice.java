import java.util.Scanner;

public class InputExersice
{
    public static void main(String[] args) {
        System.out.println("..........Student Management System...........");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter student name: ");
        String name=scanner.nextLine();

        System.out.print("Enter your contact number: ");
        int contactNumber=scanner.nextInt();

        System.out.print("Enter your batch number: ");
        int batchNumber=scanner.nextInt();

//        System.out.println("Welcome "+name+ " "+contactNumber+" to batch "+ batchNumber);
        System.out.printf("Welcome %s (%s) to batch %s\n",name,contactNumber,batchNumber);

    }
}
