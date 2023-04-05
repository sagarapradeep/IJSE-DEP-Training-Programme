package lk.ijse.dep10.app.model.inherit1;

public class A {
    public int a = 10;

    public A(int a) {
        this.a = a;
    }
    public A() {
        System.out.println("A()");
    }

    @Override
    public String toString() {
        return String.format("A:%s", a);
    }
}
