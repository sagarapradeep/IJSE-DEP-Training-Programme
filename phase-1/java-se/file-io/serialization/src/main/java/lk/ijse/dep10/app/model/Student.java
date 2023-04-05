package lk.ijse.dep10.app.model;

import java.io.*;

public class Student implements Serializable{
    public String id;
    public String name;
    public String address;

    public Student(String id, String name, String address) {
        this.name=name;
        this.id=id;
        this.address=address;



    }
}
