public class EqualsDemo
{
//    @Override
//    public boolean equals(Object obj) {
//        return true;


    public static void main(String[] args) {
        String str1 = "IJSE";
        String str2 = new String("IJSE");
//        System.out.println(str2==str1);
        System.out.println(str2.equals(str1));

        var demo1 = new EqualsDemo();
        var demo2 = new EqualsDemo();

        System.out.println(demo1.equals(demo2));
    }
}
