package lk.ijse.dep10;

public class Demo {

    public static void main(String[] args) {
        System.out.println("Hello Lombok");

        Student s1 = new Student(1, "Kamal", "Colombo");
        Student s2 = new Student(1, "Kamal", "Colombo");

        System.out.println(s1);

        System.out.println("S1 = S2 " + (s1 == s2));

        System.out.println("S1 equals S2 " + s1.equals(s2));

        System.out.println("S1 hashcode S2 " + (s1.hashCode() == s2.hashCode()));

        System.out.println("-----------------------------------------");
        System.out.printf("id =%s, name=%s, address=%s\n", s1.getId(), s1.getName(), s1.getAddress());
        System.out.printf("id =%s, name=%s, address=%s\n", s2.getId(), s2.getName(), s2.getAddress());

        s2.setId(2);
        s2.setName("Nuwan");
        s2.setAddress("Mathale");
        System.out.printf("id=%s, name=%s,address=%s", s2.getId(), s2.getName(), s2.getAddress());
    }
}
