package lk.ijse.dep10.oop.exersice;

public class Exercise3 {

    public static void main(String[] args) {
        Employee e001 = new Employee(2, "Nuwan", "Supuni", "2021");     //here
        e001.printEmployeeDetails();
    }
}
class Employee {
    int id;
    String name;
    Spouse spouse;

    {
        System.out.println("Employee Instance Initializer");
    }

    public Employee(int id, String name, String spouseName, String spouseContact) {
        this(id, name, new Spouse(spouseName, spouseContact));      //here
        System.out.println("Employee Constructor 1");
    }

    public Employee(int id, String name, Spouse spouse) {   // All Args Constructor
        super();        //here
        this.id = id;
        this.name = name;
        this.spouse = spouse;
        System.out.println("Employee Constructor 2");
    }

    void printEmployeeDetails(){
        System.out.printf("id=%s, name=%s, spouse's Name=%s, spouse's Contact=%s \n",
                this.id, name, this.spouse.name, spouse.contact);
    }

    static{
        System.out.println("Employee Template is being initialized");
    }
}

class Spouse{
    String name;
    String contact;

    public Spouse(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    static {
        System.out.println("Spouse Template is being initialized");
    }
}