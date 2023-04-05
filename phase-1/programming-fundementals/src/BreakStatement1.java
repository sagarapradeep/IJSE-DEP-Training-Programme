import java.util.Locale;
import java.util.Scanner;

public class BreakStatement1 {
    public static void main(String[] args) {
        var scanner=new Scanner(System.in);
        System.out.print("Enter the day: ");
        String day = scanner.nextLine();
        switch (day) {
            case "Monday":
                System.out.println("You entered Monday!");
                break;
            case "Tuesday":
                System.out.println("You entered Tuesday!");
                break;
            case "Wednesday":
                System.out.println("You entered Wednesday!");
                break;
            case "Thursday":
                System.out.println("You entered Thursday!");
                break;
            case "Friday":
                System.out.println("You entered Friday!");
                break;
            case "Saturday":
                System.out.println("You entered Saturday!");
                break;
            case "Sunday":
                System.out.println("You entered Sunday!");
                break;
            default:
                System.out.println("invalid day!");
        }
        System.out.println("After the switch statement!");
    }
}
