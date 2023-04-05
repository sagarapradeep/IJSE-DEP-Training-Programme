public class BreakStatement
{
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration " + i);
            if(i==3)break;
        }
    }
}
