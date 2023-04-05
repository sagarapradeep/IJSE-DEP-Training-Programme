package lk.ijse.dep10.model;

public class Student {
    public String id;
    public String name;
    public String address;

    @Override
    public String toString() {
        return String.format("%-10s%-20s%s", id, name, address);
    }



    public Student(String id, String name, String address) {
        this.id=id;
        this.name=name;
        this.address = address;
    }
}
