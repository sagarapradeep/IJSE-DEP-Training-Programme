public class TypeSystem4
{
    public static void main(String[] args) {
        boolean myBoolean=false;
        byte myByte = 10;
        short myShort=20;
        char myChar= 'A';
        int myInt=40;
        long myLong=10;
        float myFloat=10;
        double myDouble=20;

        System.out.println("hdebh");

        String myString =new Integer(myInt).toString();
        System.out.println(myString);

        myString =myShort+"";
        System.out.println(myString);

        myString =myByte+"";                //Before java 8
        System.out.println(myString);

        myString=new Short(myShort).toString();   //After java 8
        System.out.println(myString);

        myString=Integer.toString(myInt);  //Java 11

    }
}
