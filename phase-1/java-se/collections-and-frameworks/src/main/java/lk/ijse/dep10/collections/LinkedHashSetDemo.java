package lk.ijse.dep10.collections;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {

        LinkedHashSet<String> mySet = new LinkedHashSet<>();

        mySet.add("IJSE");
        mySet.add("SLIT");
        mySet.add("IJSE");
        mySet.add("NISBM");
        mySet.add("NSBM");

        System.out.println(mySet);

    }
}
