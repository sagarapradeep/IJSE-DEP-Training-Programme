import java.util.Scanner;

public class DoDemo {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num;
        boolean condition=true;
//        while (condition) {
//            System.out.print("Enter positive integer here: ");
//            num = scanner.nextInt();
//            if (num <= 0) {
//                System.out.println("Invalid number");
//
//            }
//            else condition=false;
//        }
//        System.out.printf("Input number %s",num);

        do {
            System.out.print("Enter positive number: ");
            num = scanner.nextInt();
            if (num <= 0) {
                System.out.println("Invalid number try again");
            }

        } while (!(num>0));

                System.out.printf("Input number %s",num);
    }
}
