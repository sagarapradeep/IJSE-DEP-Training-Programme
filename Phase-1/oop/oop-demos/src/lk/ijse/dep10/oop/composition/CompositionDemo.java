package lk.ijse.dep10.oop.composition;

import java.util.ArrayList;

public class CompositionDemo {
    public static void main(String[] args) {


    }
}

class Institute {
    ArrayList<Program2> programList;

    public Institute() {
        programList.add(new Program2("DEP", "5 Months"));
        programList.add(new Program2("CMJD", "6 Months"));
        programList.add(new Program2("GDSE", "2 Years"));
    }
}

class Program {
    String name;
    String duration;

    public Program(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }
}
