public class Conversion
{
    public static void main(String[] args) {
        boolean flag1=true;         //Identity conversion
        boolean flag2=flag1;
        int num1=10;
        int num2=num1;
        double d1=90.56;
        double d2=d1;
        String name ="IJSE";
        String name2=name;


        byte b1=10;     //Narrowing conversion
        short s1=10;        //Narrowing conversion(casting)
        int i1=10;          //Identity conversion
        long l1=10;         //Widening conversion

        float myFloat=10;
        double myDouble=10;         //
        myDouble=l1;
        myDouble=23;

        double num4=0.3;
        double num5=0.2;
        double result = num4-num5;
        System.out.println(result);

        int myNum=500;
        byte myByte=(byte) myNum;
        System.out.println(myByte);


    }
}
