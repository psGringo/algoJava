package org.example;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
//        findJudge(2, new int[][]{{1, 2}, {2, 3}});
    }

    public int findJudge(int n, int[][] trust) {
        int[] hash=new int[n+1];
        for(int []arr:trust){
            hash[arr[0]]--;
            hash[arr[1]]++;
        }
        int count=0;
        for(int i=1;i<=n;i++)
            if(hash[i]==n-1) // everybody trust judje except himself, so n-1
                return i;

        return -1;
    }

    public static int findJudge2(int n, int[][] trust) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < trust.length; i++) {
            int[] x = trust[i];
            set.add(x[0]);
        }

        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}