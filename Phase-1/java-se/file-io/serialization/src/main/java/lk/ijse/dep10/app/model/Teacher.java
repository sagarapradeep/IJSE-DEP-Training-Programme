package lk.ijse.dep10.app.model;

import java.io.Serializable;

public class Teacher implements Serializable {
    int id;
    String name;
    private static final long serialVersionUID = 5850949654190980014L;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
