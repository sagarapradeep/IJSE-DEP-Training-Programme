public class BreakStatement3
{
    public static void main(String[] args) {
        loop1:
        for (int i = 0; i < 6; i++) {
            loop2:
            for (int j = 0; j < 6; j++) {
                System.out.print("* ");
                if (i == 3 && j == 3) {
                    break loop1;

                }
            }
            System.out.println();
        }
    }

    /* ******
       ******
       *
    * */
}
