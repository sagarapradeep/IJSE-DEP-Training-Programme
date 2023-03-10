package lk.ijse.dep10.app;

import java.io.Closeable;
import java.io.IOException;

public class Demo4 {
    public static void main(String[] args) throws Exception {
        try (MyResource1 myResource1 = new MyResource1();
             MyResource2 myResource2 = new MyResource2()) {
            System.out.println(myResource1);
            System.out.println(myResource2);
        }
    }
}

    class MyResource1 implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("Resource 1 is about to close");

        }
    }

class MyResource2 implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("Resource 2 is about to close");

    }
}

