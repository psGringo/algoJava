package org.example;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    public int countElements(int[] nums) {
          int min = Integer.MAX_VALUE;
          int max = Integer.MIN_VALUE;
          for (int num : nums) {
              if (num < min) {
                  min = num;
              }
              if (num > max) {
                  max = num;
              }
          }

          List<Integer> list = new ArrayList<>();
          for (int num : nums) {
              if (num != min && num != max) {
                  list.add(num);
              }
          }
          return list.size();
    }
}