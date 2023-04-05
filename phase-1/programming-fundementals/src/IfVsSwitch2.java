import java.util.Scanner;

public class IfVsSwitch2
{
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Enter month: ");
        String something = scanner.nextLine();

        if (something == "Jan") {
            System.out.println();
        }
    }
}
