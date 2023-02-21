package lk.ijse.dep10.oop.poly;

public class Override2 {
    public static void main(String[] args) {
        S s = new S();
        s.myMethod();



    }
}

class S{
    public static void myStaticMethod() {
        System.out.println("my static method - S");
    }
    public  void myMethod()throws RuntimeException  {
        System.out.println("my method - S");
    }

}

class T extends S{

    public static void myStaticMethod() {
        System.out.println("my static method - T");
    }
    public  void myMethod() {
        System.out.println("my method - T");
    }

}
