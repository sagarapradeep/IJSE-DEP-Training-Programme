import java.util.Scanner;

public class IfvsSwitch
{
    public static void main(String[] args) {
        String myStr1="IJSE";
        String myStr2 = new String("IJSE").intern();
        boolean result =myStr2==myStr1;
        System.out.println(result);

        var scanner = new Scanner(System.in);
        System.out.print("Enter something:");
        var input = scanner.nextLine();
        result=!myStr1.equals(input);
        System.out.println(result);


    }
}
