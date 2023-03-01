package lk.ijse.dep10.app.model;

import java.io.Serializable;

public class Customer implements Serializable {
    String id;
    String name;
    String address;
    private static final long serialVersionUID = 256656281953434871L;




    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    public void print() {
        String message= "Costumer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
        System.out.println(message);
    }
}
