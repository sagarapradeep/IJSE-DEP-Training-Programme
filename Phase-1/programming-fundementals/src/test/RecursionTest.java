package test;

public class RecursionTest {
    public static void main(String[] args) {
        recursion(0);

    }

    public static void recursion(int number) {
        if (number == 10) {
            return;
        }
        recursion(++number);
        System.out.println("Number " + number);
    }
}
