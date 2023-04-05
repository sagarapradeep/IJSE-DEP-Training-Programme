package lk.ijse.dep10.app.model;

import com.mysql.cj.jdbc.Blob;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private String address;
    private java.sql.Blob picture;

    public Student(int id, String name, String address, Blob picture) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.picture = picture;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public java.sql.Blob getPicture() {
        return picture;
    }

    public void setPicture(java.sql.Blob picture) {
        this.picture = picture;
    }
}
