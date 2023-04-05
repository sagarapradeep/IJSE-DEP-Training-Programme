public class OverLoadingDemo2 {
    public static void main(String[] args) {
        long x = 10;
        myMethod(x);

    }


    public static void myMethod(int x) {
        System.out.println("My method int");

    }

    public static void myMethod(double x) {
        System.out.println("My method double");

    }
//    public static void myMethod(long x) {
//        System.out.println("My method long");
//
//    }
    public static void myMethod(float x) {
        System.out.println("My method float");

    }

}
