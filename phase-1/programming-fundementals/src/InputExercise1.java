import java.util.Scanner;

public class InputExercise1
{
    public static strictfp void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int Number_of_Subjects=4;

        System.out.print("Enter student name: ");
        String name=scanner.nextLine();

        System.out.print("Enter marks for pf: ");
        int marksPf=scanner.nextInt();

        System.out.print("Enter marks for dbms: ");
        int marksDbms=scanner.nextInt();

        System.out.print("Enter marks for oop: ");
        int marksOop=scanner.nextInt();

        System.out.print("Enter marks for networking: ");
        int marksNetworking=scanner.nextInt();

        int total=(marksPf+marksNetworking+marksDbms+marksOop);
        double average=(total)/Number_of_Subjects;


        System.out.printf("%s's total marks: %s\n%s's average %s",name,total,name,average);
    }
}
