package lk.ijse.dep10.app;

import java.sql.SQLException;

public class Demo3 {
    public static void main(String[] args) throws Exception {
        myMethod1();


    }

    public static void myMethod1() throws ClassNotFoundException {
        System.out.println("Entering myMethod 1");

        try {
            myMethod3();
        } catch (RuntimeException r) {
            System.out.println("AVC");
        }
    }

    public static void myMethod2() {
        System.out.println("Entering myMethod 2");
        System.out.println("Leaving myMethod 2");

    }

    public static void myMethod3() {
        System.out.println("Entering myMethod 3");
        System.out.println("Leaving myMethod 3");

    }
}
