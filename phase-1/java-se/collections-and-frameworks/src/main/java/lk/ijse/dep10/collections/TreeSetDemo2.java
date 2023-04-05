package lk.ijse.dep10.collections;

import java.util.TreeSet;

public class TreeSetDemo2 {
    public static void main(String[] args) {


        TreeSet<Customer> customers = new TreeSet<>();
        customers.add(new Customer(1, "Sagara"));
        customers.add(new Customer(4, "Nimal"));
        customers.add(new Customer(2, "Amal"));
        customers.add(new Customer(100, "Ranil"));

        System.out.println(customers);


    }
}


class Customer implements Comparable<Customer> {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }



    @Override
    public int compareTo(Customer o) {
        if(id==o.id) return 0;
        if(id>o.id) return 1;
        return -1;
    }
}
