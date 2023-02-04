package lk.ijse.dep10.oop;

public class Shadowing {

    static int x = 10;

    public static void main(String[] args) {
        String x = "Sagara";                    //shadowing outer scope identifier by inner scope identifier
        System.out.println(Shadowing.x);
    }
}
