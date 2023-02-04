package method;

public class MethodDemo1 {
    public static void main(String[] args) {
        myMethod();
        print("hello world");
        print("Ijse");
    }
    public static void myMethod() {
        System.out.println("IJSE");
        System.out.println("----------------");
        System.out.println("DEP 10");

    }

    public static void print(String something) {
        System.out.println("----------------------------");
        System.out.println(something.toUpperCase());
        System.out.println("----------------------------");
    }
}
