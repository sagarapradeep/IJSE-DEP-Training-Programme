package lk.ijse.dep10.collections;

import java.util.HashSet;
import java.util.Objects;

public class HashSetDemo5 {
    public static void main(String[] args) {
        HashSet<Student> studentList = new HashSet<>();
        Student kasun = new Student(2, "Kasun");
        Student nimal = new Student(4, "Nimal");
        kasun.equals(nimal);
        studentList.add(kasun);
        studentList.add(nimal);
        studentList.add(new Student(2, "Nimal"));
        studentList.add(new Student(8, "Pradeep"));

        Student s001 = new Student(1, "Kasun");
        Student s002 = new Student(1, "Kasun");

        System.out.println(s001.hashCode());
        System.out.println(s002.hashCode());
    }
}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        Student s = (Student) obj;
        return (id == s.id && name.equals(s.name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
