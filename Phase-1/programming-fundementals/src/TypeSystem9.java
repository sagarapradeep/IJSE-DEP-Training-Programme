public class TypeSystem9
{
    public static strictfp void main(String[] args) {

        float f=90.57f;  //need f for float because decimal points default double

        float  f2=23.3444453453454f;
        double d1=f2;
        System.out.println(d1);             //Not same as f12's number. Double and floats are not precision

        double result = 3.57+.3463490210;
        System.out.println(result);

        double result1=0.2-0.3;
        System.out.println(result1);
    }
}
