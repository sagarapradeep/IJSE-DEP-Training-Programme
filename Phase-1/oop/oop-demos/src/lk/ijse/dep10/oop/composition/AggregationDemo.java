package lk.ijse.dep10.oop.composition;

import java.util.ArrayList;

public class AggregationDemo {
    public static void main(String[] args) {


    }
}

class Institute2 {
    ArrayList<Program2> programList;

    public Institute2(ArrayList<Program2> programList) {
        this.programList =programList;
    }
}

class Program2 {
    String name;
    String duration;

    public Program2(String name, String duration) {
        this.name = name;
        this.duration = duration;
    }
}
