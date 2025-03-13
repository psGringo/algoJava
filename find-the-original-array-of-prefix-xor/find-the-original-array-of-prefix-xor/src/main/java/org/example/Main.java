package org.example;


public class Main {
    public static void main(String[] args) {

    }


//    Why Does This Work?
//    XOR has a property:
//    𝑥 ^ x = 0
//
//    So, when we apply XOR between consecutive elements of pref[], the previous prefix cancels out, leaving us with arr[i].



    public int[] findArray(int[] pref) {
         int[] result = new int[pref.length];
         result[0] = pref[0];
         for (int i = 1; i < pref.length; i++) {
             result[i] = pref[i] ^ pref[i - 1];
         }
         return result;
    }

}