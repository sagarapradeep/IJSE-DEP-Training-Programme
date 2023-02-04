package lk.ijse.dep10.oop.exersice;

public class Exercise2 {
    public static void main(String[] args) {
        Student s001;
        System.out.println(s001=new Student(1, "kasun", "123"));
        Student s002 = new Student();
        s002.name = s001.name;
        System.out.println(s002);

    }
}

class Student{
    int id;
    String name;
    String contactNumber;

    public Student() {          //no arg contructor

    }

    public Student(int sId, String sName,String sContacts) {        //full arg constructor

        id = sId;
        name =sName;
        contactNumber=sContacts;

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                '}';
    }
}
