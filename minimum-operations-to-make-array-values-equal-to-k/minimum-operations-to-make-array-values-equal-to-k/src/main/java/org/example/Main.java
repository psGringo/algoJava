package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int minOperations(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) set.add(num);

        int min = set.iterator().next();
        if (min < k) return -1;
        return set.size() + (min == k ? -1 : 0);
    }
}