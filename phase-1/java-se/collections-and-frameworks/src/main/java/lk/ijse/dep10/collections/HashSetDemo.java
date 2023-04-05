package lk.ijse.dep10.collections;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> mySet = new HashSet<>();
        mySet.add("IJSE");
        mySet.add("IJSE");
        mySet.add("SLIT");
        mySet.add("NSBM");
        mySet.add("IJSE");
        mySet.add("NIBM");
        mySet.add("IJSE");

        System.out.println(mySet.size());
    }

}
