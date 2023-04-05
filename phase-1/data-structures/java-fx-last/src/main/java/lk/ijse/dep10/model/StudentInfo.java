package lk.ijse.dep10.model;

import lk.ijse.dep10.util.Gender;

import java.util.ArrayList;

public class StudentInfo {
    public String id;
    public String name;
    public Gender gender;
    public ArrayList<String> contacts;
    public ArrayList<String> modules;

    public StudentInfo(String id, String name, Gender gender, ArrayList<String> contacts, ArrayList<String> modules) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.contacts = contacts;
        this.modules = modules;
    }
}
