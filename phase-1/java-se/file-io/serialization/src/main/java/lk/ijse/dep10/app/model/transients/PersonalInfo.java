package lk.ijse.dep10.app.model.transients;

import java.io.Serializable;
import java.util.ArrayList;

public class PersonalInfo implements Serializable {

    private String name;
    private ArrayList<String> contacts;

    public PersonalInfo(String name, ArrayList<String> contacts) {
        this.name = name;
        this.contacts = contacts;
    }

    public PersonalInfo() {
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getContacts() {
        return contacts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContacts(ArrayList<String> contacts) {
        this.contacts = contacts;
    }
}
