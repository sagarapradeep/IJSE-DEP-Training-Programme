package lk.ijse.dep10.oop;
public class TemplateLoader {

    static {
        System.out.println("Template loader called");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Template loader main method called");
//        MyTemplate.doSomething();
        Class.forName("lk.ijse.dep10.oop.MyTemplate");
    }
}
class MyTemplate{
    static {
        System.out.println("My template loaded");
    }

    public static void main() {
        System.out.println("Main method of MyTemplate called!");
    }

    static void doSomething() {

    }

}
