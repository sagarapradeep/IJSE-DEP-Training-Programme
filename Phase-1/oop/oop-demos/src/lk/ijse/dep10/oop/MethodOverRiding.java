package lk.ijse.dep10.oop;

public class MethodOverRiding {
    public static void main(String[] args) {
//        new Sub().myStaticMethod();

        Sub sub = new Sub();

        Super mySuper = sub;
        mySuper.myStaticMethod();

        System.out.println(mySuper);
//        mySuper.myStaticMethod();

    }
}

class Super{
    public static void myStaticMethod() {
        System.out.println("Super: My Static Method");
    }

}

class Mediator extends Super {

}

class Sub extends Mediator{
    public static void myStaticMethod() {
        System.out.println("Sub: My Static Method");
    }

}
