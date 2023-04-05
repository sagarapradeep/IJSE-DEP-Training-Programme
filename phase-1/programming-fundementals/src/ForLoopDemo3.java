public class ForLoopDemo3
{
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("[                                       ]");
            System.out.print("\u001b[31m  ");
            Thread.sleep(500);
        }
    }
}
