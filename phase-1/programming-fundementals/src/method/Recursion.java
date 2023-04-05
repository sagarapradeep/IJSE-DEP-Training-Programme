package method;

public class Recursion {
    public static void main(String[] args) {

        printIjse(0);

    }
    public static void printIjse(int iteration) {
        if(iteration==3) return;
        System.out.println("IJSE");
        printIjse(++iteration);
    }
}
