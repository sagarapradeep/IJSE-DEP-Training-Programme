package lk.ijse.dep10.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HashSetDemo2 {
    public static void main(String[] args) {
        List<String> cityList = Arrays.asList("Panadura", "Kaduwela", "Colombo", "Galle", "Galle", "Mathara", "Colombo");

        HashSet<String> mySet = new HashSet<>(cityList);

        System.out.println((mySet.size() < cityList.size()) ? "Duplicates" : "No duplicates");
    }
}
