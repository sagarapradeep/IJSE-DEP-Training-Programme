package lk.ijse.dep10.oop;

import javax.swing.*;
import java.util.Scanner;

public class HelloOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyClass myClass = new MyClass();
        String myStr = new String();

        JFrame myFrame = new JFrame("My Frame");

        myFrame.setSize(500, 500);
        myFrame.setVisible(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
