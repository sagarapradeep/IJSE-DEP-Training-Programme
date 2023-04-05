import java.math.BigDecimal;

public class CompareDemo {
    public static void main(String[] args) {

        BigDecimal bd1 = new BigDecimal(100);
        BigDecimal bd2 = new BigDecimal(120);
        BigDecimal bd3 = new BigDecimal(80);
        BigDecimal bd4 = new BigDecimal(200);
        BigDecimal bd5 = new BigDecimal(500);

        int i = bd1.compareTo(bd2);
        System.out.println(i);

    }
}
