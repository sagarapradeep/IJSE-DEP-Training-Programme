package lk.ijse.dep10.app.controller.util;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Student implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String gender;
    private Date dob;

    public Student(int id, String firstName, String lastName, String address, String gender, Date dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.dob = dob;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob.toLocalDate();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDob(String dob) {
        this.dob = Date.valueOf(dob);
    }
}
