package lk.ijse.dep10.app.model;

import java.util.ArrayList;

public class StudentDetails {
    public String id;
    public String name;
    public ArrayList<String>contactNumbers;
    public ArrayList<String>selectedModules;

    public StudentDetails(String id, String name,ArrayList<String>contactNumbers,ArrayList<String>selectedModules) {
        this.name=name;
        this.id=id;
        this.contactNumbers=contactNumbers;
        this.selectedModules=selectedModules;

        System.out.println(selectedModules);
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s", id, name);
    }
}
