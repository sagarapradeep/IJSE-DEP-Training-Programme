package lk.ijse.dep10.app.model.inherit2;

public class C extends B{
    int c = 30;

    public C(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public C() {

    }

    @Override
    public String toString() {
        return "C{" +
                "c=" + c +
                ", b=" + b +
                ", a=" + a +
                '}';
    }
}
