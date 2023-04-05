package lk.ijse.dep10.dp;

public class SingletonDemo {
    public static void main(String[] args) {
        Earth earth1 = Earth.getInstance();


    }
}

class Earth {
//    private static final Earth earth;

    private static final Earth earth = new Earth();


    private Earth() {}

    public static Earth getInstance() {
        return earth;
//        return (earth == null) ? new Earth() : earth;
    }

}
