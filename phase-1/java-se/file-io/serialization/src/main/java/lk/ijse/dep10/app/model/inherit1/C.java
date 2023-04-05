package lk.ijse.dep10.app.model.inherit1;

public class C extends B{
    public int c = 30;

    public C(int a, int b, int c) {
        super(a, b);
        this.c = c;
    }

    public C() {
        System.out.println("C()");
    }

    @Override
    public String toString() {
        return String.format("A:%s B:%S C:%S ", a, b, c);
    }
}
