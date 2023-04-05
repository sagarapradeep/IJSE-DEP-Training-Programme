package lk.ijse.dep10.app;

public class Demo1 {
    public static void main(String[] args)  {


        myMethod1();


    }

    public static void myMethod1() {
        myMethod2();

    }
    public static void myMethod2()  {
//        System.out.println(10 / 0);
        try {
            Class.forName("abc");
        } catch (ClassNotFoundException e) {
            System.out.println(e);

        }


    }

}
