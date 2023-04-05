package lk.ijse.dep10.myapp;

import java.util.Scanner;

public class AppInitializer {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        System.out.print("Enter your name here: ");
        var name = scanner.nextLine().trim();
        System.out.printf("Your name is %s", name);
    }
}
