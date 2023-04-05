public class OverLoadingDemo3{
    public static void main(String[] args) {
        int z=30;
        byte x=10;
        short y=20;
        float f = 10.0f;

//        myMethod(x, y, z, f);
    }

    public static void myMethod(Short x, float y, float z, float d) {
        System.out.println("A. my Method(short,Short,float,float)");

    }
    public static void myMethod(int x, float y, Double z, float d) {
        System.out.println("B. my Method(int,float,long,float)");

    }
    public static void myMethod(short x, Float y, double z, float d) {
        System.out.println("C. my Method(short,double,long,float)");

    }
//    public static void myMethod(short x, Short y, int z, float d) {
//        System.out.println("D. my Method(short,Short,int,float)");
//
//    }

//    public static void myMethod(Byte x, Short y, Integer z, Float d) {
//        System.out.println("E. my Method(Byte,Short,Integer,Float)");
//
//    }
}
