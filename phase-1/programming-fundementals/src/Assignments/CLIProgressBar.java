package practice;

public class CLIProgressBar {
    public static void main(String[] args) throws InterruptedException {
        System.out.print("Progress : [");
        String str = "";

        for (int i = 0; i < 20; i++) {
            System.out.print("\u001b[42m");
            for (int j = 0; j < 20; j++) {
                System.out.print(" ");
                if (i==j) System.out.print("\u001b[0m");
            }
            str = String.format("]  "+"%-3d" + "/" + "%-3d",i+1,20);
            System.out.print(str);
            Thread.sleep(400);
            System.out.print("\b".repeat(30));
        }

        System.out.print("\b".repeat(12));
        System.out.print("Completed...!");


    }
}
