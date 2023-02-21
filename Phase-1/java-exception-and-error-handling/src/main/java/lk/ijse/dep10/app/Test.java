package lk.ijse.dep10.app;

public class Test {
    public static void main(String[] args) {
        int x=10;
        short y=3;
        double z=5.7;

        myMethod(x, y, z);
    }

    public static void myMethod(int x, Short y, Double z) {
        System.out.println("Wrapper Class");
    }

    public static void myMethod(int x, short y, Number z) {
        System.out.println("Wrapper Class");

    }
}
