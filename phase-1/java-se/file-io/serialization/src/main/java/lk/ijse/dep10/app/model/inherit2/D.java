package lk.ijse.dep10.app.model.inherit2;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class D extends C implements Externalizable {
    int d = 40;

    public D(int a, int b, int c, int d) {
        super(a, b, c);
        this.d = d;
    }

    public D() {

    }

    @Override
    public String toString() {
        return "D{" +
                "d=" + d +
                ", c=" + c +
                ", b=" + b +
                ", a=" + a +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(d);
        out.writeInt(c);
        out.writeInt(b);
        out.writeInt(a);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        d = in.readInt();
        c = in.readInt();
        b = in.readInt();
        a = in.readInt();

    }
}
