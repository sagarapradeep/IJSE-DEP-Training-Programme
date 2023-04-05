package lk.ijse.dep10.app.model.inherit1;

public class B extends A{
    public int b = 20;

    public B(int a, int b) {
        super(a);
        this.b = b;
    }
    public B() {
        System.out.println("B()");
    }


    @Override
    public String toString() {
        return String.format("A:%s B:%S ", a, b);
    }
}
