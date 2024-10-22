package org.example;


import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode.com/problems/destination-city/description/
 */
public class Main {
    public static void main(String[] args) {

    }

    public String destCity(List<List<String>> paths) {
        HashSet<String> setStartPoint = new HashSet<>();
        for (List<String> path : paths) {
            setStartPoint.add(path.get(0));
        }
        for (List<String> path : paths) {
            if (!setStartPoint.contains(path.get(1))) {
                return path.get(1);
            }
        }
        return null;
    }
}