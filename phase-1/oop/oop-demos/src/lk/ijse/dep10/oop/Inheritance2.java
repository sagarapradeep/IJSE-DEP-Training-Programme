package lk.ijse.dep10.oop;

public class Inheritance2 {
    public static void main(String[] args) {
        new Child().print();
    }
}

class Parent {
    int x=10;
    static int y = 5;
    void print() {
        System.out.println(x);
        System.out.println(y);
    }

}

class Child extends Parent {

    int x=20;
    int y=7;

}
