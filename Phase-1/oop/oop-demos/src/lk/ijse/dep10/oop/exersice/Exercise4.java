package lk.ijse.dep10.oop.exersice;

public class Exercise4 {
    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.printDetails();

    }
}

class Teacher{
    String nic;
    String name;
    String contact;

    public Teacher() {

    }

    public Teacher(String nic, String name, String contact) {
        this.nic = nic;
        this.name = name;
        this.contact = contact;
    }

    void  printDetails() {
        String name = "Nuwan";
        System.out.printf("nic = %s, name = %s, contact = %s",nic,name,contact);
    }

}
