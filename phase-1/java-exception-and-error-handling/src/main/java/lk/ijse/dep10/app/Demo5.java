package lk.ijse.dep10.app;

import java.util.Scanner;

public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter number here: ");
            System.out.println("Result: " + results(scanner));

        }
    }

    public static int results(Scanner scanner) {
        try {
            int x = scanner.nextInt();
            return (100 / x);
        } catch (Exception e) {
            System.out.println("Something went wrong!");
            return -1;
        } finally {
            System.out.println("Finally");
        }


    }
}
