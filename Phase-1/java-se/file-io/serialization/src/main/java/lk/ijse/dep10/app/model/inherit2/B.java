package lk.ijse.dep10.app.model.inherit2;

public class B extends A{
    int b = 20;

    public B(int a, int b) {
        super(a);
        this.b = b;
    }

    public B() {

    }

    @Override
    public String toString() {
        return "B{" +
                "b=" + b +
                ", a=" + a +
                '}';
    }
}
