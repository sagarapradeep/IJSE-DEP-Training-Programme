public class Operators3
{
    public static void main(String[] args) {
        int a=5;
        int b = 2;
        int result=20;

        a+=a++ + b + --b + ~a + a*b +10;

        b=(a>(a+ ++b))?a++:(b=b+10);

        System.out.println("a"+a);
        System.out.println("b"+b);


        result %=((a++ + ++b)*2);


        System.out.println(result);
    }
}
