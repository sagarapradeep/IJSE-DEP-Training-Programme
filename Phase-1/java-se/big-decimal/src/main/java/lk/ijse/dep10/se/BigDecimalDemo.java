package lk.ijse.dep10.se;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double d1 = 0.4;
        double d2 = 0.5;

        BigDecimal bd3 = BigDecimal.valueOf(d1);
        BigDecimal bd4 = BigDecimal.valueOf(d2);
        BigDecimal dResult = bd3.add(bd4);
        System.out.println(dResult);


        BigDecimal bd1 = new BigDecimal("0.2");
        BigDecimal bd2 = new BigDecimal("0.3");
        BigDecimal result = bd1.subtract(bd2);
        System.out.println(result);

    }
}
