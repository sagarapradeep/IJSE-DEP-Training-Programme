import java.util.Scanner;

public class StandardStreams

{
    public static void main(String[] args) {
//        System.err.println("IJSE");             //standard error
//
//        System.out.print("IJSE\n");
//        Scanner scanner=new Scanner(System.in);     //creat scanner object in heap memory.through system.in gives scanner to scan location
//        String input=scanner.nextLine();        //call nextline method in scanner object
//        System.out.println(input);


        Scanner scanner =new Scanner(System.in);
        System.out.print("Enter your name :");
        String name=scanner.nextLine();
        System.out.println("Hi "+name);
    }
}
