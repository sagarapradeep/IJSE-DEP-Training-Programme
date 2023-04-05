public class Demo {
    public static void main(String[] args) throws InterruptedException {

        A a = new A();
        B b = new B();
        b.a=a;
        a = null;
        b = null;
        System.gc();

        System.out.println("Before exist");
        Thread.sleep(1000);

    }
}

class A {

    public static void main(String[] args) {

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + " about to destroy");
    }
}

class B {
    public A a;

    @Override
    protected void finalize() throws Throwable {
        System.out.println(this + " about to destroy");
    }
}

class C {

}
