package string;

public class StringFormatting
{
    public static void main(String[] args) {
        int iD=182;
        //S001 , S010, S1234

        String studentID= String.format("S%03d", iD);
        System.out.println(studentID);

        double price=257637.23;
        String priceStatement=String.format("Rs %,.2f",price);
        System.out.println(priceStatement);
    }
}
