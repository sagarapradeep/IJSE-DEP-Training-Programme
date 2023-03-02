package lk.ijse.dep10.app.model;

import java.io.Serializable;

public class Customer implements Serializable {
    String id;
    String name;
    static String city;
    private static final long serialVersionUID = 256656281953434871L;




    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.city = address;
    }


    public void print() {
        String message= "Costumer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + city + '\'' +
                '}';
        System.out.println(message);
    }
}
