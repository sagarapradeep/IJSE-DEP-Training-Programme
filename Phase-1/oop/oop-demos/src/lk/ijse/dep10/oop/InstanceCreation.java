package lk.ijse.dep10.oop;

public class InstanceCreation {
    public static void main(String[] args) {
        Customer c01=new Customer();
        Customer c02 = new Customer();

    }
}

class Customer{
    static int id;

    static {
        System.out.println("Costumer static initializer 1");
    }

    public Customer() {
        System.out.println("Costumer constructor");
    }

    String name;

    static {
        System.out.println("Costumer static initializer 2");

        {
            System.out.println("Costumer instance initializer 2");
        }
    }

    String address = "Panadura";

    {
        System.out.println("Costumer instance initializer 2");
    }
}
