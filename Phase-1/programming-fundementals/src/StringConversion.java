public class StringConversion
{
    public static void main(String[] args) {

        int myNum=2;
        String myString;
        myString=Integer.toString(myNum);           //integer to String
        System.out.println(myString);


        String myString1="475.8769";
        double myDouble;
        myDouble=Double.parseDouble(myString1);
        System.out.println(myString1);

        String myString3="ergfgcvg";
        char myChar=myString3.charAt(2);
        System.out.println(myChar);
    }
}
