package lk.ijse.dep10.collections;

import java.util.LinkedHashSet;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {

        TreeSet<String> mySet = new TreeSet<>();

        mySet.add("IJSE");
        mySet.add("SLIT");
        mySet.add("IJSE");
        mySet.add("NISBM");
        mySet.add("NSBM");

        System.out.println(mySet);

        TreeSet<Integer> ints = new TreeSet<Integer>();
        ints.add(12);
        ints.add(22);
        ints.add(-90);
        ints.add(1);
        ints.add(2);
        ints.add(120);

        System.out.println(ints);
    }
}
