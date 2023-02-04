import java.util.Scanner;

public class ValidateNIC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        var nic = scanner.nextLine();

        if (nic.isBlank()) {
            System.out.println("Invalid NIC");
        }
    }
}
