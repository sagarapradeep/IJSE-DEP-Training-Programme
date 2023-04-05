package lk.ijse.dep10.app.model.inherit1;

import java.io.Serializable;

public class D extends C implements Serializable {
    int d = 40;

    public D(int a, int b, int c, int d) {
        super(a, b, c);
        this.d = d;
    }

    public D() {
        System.out.println("D()");
    }

    @Override
    public String toString() {
        return String.format("A:%s B:%S C:%S D:%S", a, b, c, d);

    }
}
