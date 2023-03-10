package lk.ijse.dep10.oop.test;

public class Demo {
    public static void main(String[] args) {
        TopLevelClass instance1 = new TopLevelClass();
        AnotherTopLevelClass instance2 = new AnotherTopLevelClass();

        new TopLevelClass.StaticNestedClass();
        instance1.new RegularInnerClass();

    }
}

class TopLevelClass {
    public static void main(String[] args) {
        new TopLevelClass().new RegularInnerClass();
        new StaticNestedClass();
    }
    class RegularInnerClass {

    }

    static class StaticNestedClass {
    }


}

class AnotherTopLevelClass {

}
