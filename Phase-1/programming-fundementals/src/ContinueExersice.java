import java.util.Scanner;

public class ContinueExersice {
    public static void main(String[] args) {
        String contactNumber;
        System.out.print("Enter contact Number: ");
        Scanner scanner = new Scanner(System.in);
        boolean validContact=true;
        contactNumber = scanner.nextLine();
        if (contactNumber.length() != 11 || contactNumber.charAt(3) != '-') {
            System.out.println("Invalid contact number");

        }
        else{
            char[] charArray = contactNumber.toCharArray();
            for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
                if (i==3)continue;

                validContact =Character.isDigit(charArray[i]);
                }
            if (validContact) {
                System.out.println("Valid Contact number");


            }
            else System.out.println("Invalid Contact number");

            }




            }




}
