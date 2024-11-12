package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

    }

    public int minElement(int[] nums) {
        int res=Integer.MAX_VALUE;
        for(int num : nums){
            res = Math.min(res, getSumDigits(num));
        }
        return res;
    }

    private int getSumDigits(int num) {
        int sum = 0;
        while(num != 0){
            sum += num%10;
            num/=10;
        }
        return sum;
    }
}