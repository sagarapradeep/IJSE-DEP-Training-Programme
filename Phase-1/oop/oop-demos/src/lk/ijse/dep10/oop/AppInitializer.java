package lk.ijse.dep10.oop;

public class AppInitializer {
    static int x=10;

    public AppInitializer() {

    }

    static{
        System.out.println("x" + x);
//        System.out.println("Y" + y);
        System.out.println("Static Initializer 1");
    }
    public static void main(String[] args) {
        System.out.println("Inside the mainmethod");
        System.out.println("Main method about to exit");
    }
    static int y=20;
    static {
        System.out.println("Static Initializer 2");
    }
}
