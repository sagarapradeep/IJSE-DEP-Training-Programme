import java.util.Scanner;
public class SwitchExercise {
    public static void main(String[] args) {
        System.out.println("Number of days calculator...................");
        System.out.print("\nEnter month here(eg: 1/january/JANUARY): ");
        var scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        short days = 0;

        switch (month.toLowerCase()) {

                case "december": case "12":
                days += 31;
                case "november":case "11":
                days += 30;
                case "october":case "10":
                days += 31;
                case "september":case "9":
                days += 30;
                case "august":case "8":
                days += 31;
                case "july":case "7":
                days += 31;
                case "june":case "6":
                days += 30;
                case "may":case "5":
                days += 31;
                case "april":case "4":
                days += 30;
                case "march":case "3":
                days += 31;
                case "february":case "2":
                days += 28;
                case "january":case "1":
                days += 31;
                System.out.printf("\n%s - %s days!", month.toUpperCase(), days);
                break;
                default:
                System.out.println("Invalid month");


        }


    }

}
