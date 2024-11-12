package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public boolean canAliceWin(int[] nums) {
      int singlesSum = 0;
      int doublesSum = 0;
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] < 10) {
              singlesSum += nums[i];
          } else {
              doublesSum += nums[i];
          }
      }
      return doublesSum != singlesSum;
    }
}