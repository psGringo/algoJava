package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode.com/problems/sort-the-people/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String[] sortPeople(String[] names, int[] heights) {
        Person[] people = new Person[heights.length];
        for (int i = 0; i < names.length; i++) {
            people[i] = new Person(names[i], heights[i]);
        }
        Arrays.sort(people, (x, y) -> {
            if (x.height() > y.height()) {
                return -1;
            } else if (x.height() < y.height()) {
                return 1;
            }
            return 0;
        });

        List<String> namesList = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            namesList.add(people[i].name());
        }
        return namesList.toArray(new String[namesList.size()]);
    }

}

record Person(String name, int height) {
}