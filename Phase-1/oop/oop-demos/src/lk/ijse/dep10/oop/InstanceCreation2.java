package lk.ijse.dep10.oop;

public class InstanceCreation2 {
    static String name = "Kasun";
    public static void main(String[] args) {
        Student s001 = new Student();
        name = "Ruwan";
        Name n1 = new Name();
        Student s002 = new Student();
        s002.name = n1;
        n1.lastName = "Kamal";
        s001.name = s002.name;
        s001.name.lastName = "Sampath";
        System.out.println(s001.name.firstName);
        System.out.println(s001.name.lastName);
        System.out.println(s001.school);
        System.out.println(s002.name.firstName);
        System.out.println(s002.name.lastName);
        System.out.println(s002.school);

        s002.school = "IJSE";
        new Student();
    }
}

class Name{
    String firstName;
    public Name() {
        System.out.println(firstName + " " + lastName);
    }
    String lastName = InstanceCreation2.name;
    {
        firstName = "Ruwan";
    }
    String getMySchool(){
        return "Institute of Software Engineering";
    }
}

class Student{
    int id;
    Name name = new Name();
    static String school = "IJSE";
    public Student() {
        System.out.println(id + ", " + name.firstName + ", " + name.lastName + ", " + school);
    }
    {
        name.firstName = "Sampath";
        school = name.getMySchool();
    }
    static {
        school = "ESOFT";
    }
}
