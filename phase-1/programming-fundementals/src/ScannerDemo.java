import java.util.Scanner;

public class ScannerDemo
{
    public static void main(String[] args) {
        var scanner =new Scanner(System.in);
        System.out.print("Enter Something: ");
        scanner.useDelimiter("-");          //use "-" instead of space to break tokens

        String token1=scanner.next();
        System.out.println(token1);

        String token2=scanner.next();
        System.out.println(token2);

    }
}
