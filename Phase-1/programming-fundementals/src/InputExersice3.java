import java.util.Scanner;

public class InputExersice3
{
    public static strictfp void main(String[] args) {
        System.out.print("Enter your marks(split via ,): ");

        int[] marks=new int[5];
        var scanner =new Scanner(System.in);
        scanner.useDelimiter(",");

        marks[0] = scanner.nextInt();
        marks[1] = scanner.nextInt();
        marks[2] = scanner.nextInt();
        marks[3] = scanner.nextInt();

//        scanner.useDelimiter(",|\n");
        scanner.useDelimiter("");               //change delimiter to ""
        marks[4] = Integer.parseInt(scanner.nextLine());
//        System.out.println(marks[4]);



        int totalMarks=marks[0]+marks[1]+marks[2]+marks[3]+marks[4];
        double average =totalMarks/marks.length;

        System.out.printf("Total marks %s\nAverage marks %s",totalMarks,average);





    }
}
