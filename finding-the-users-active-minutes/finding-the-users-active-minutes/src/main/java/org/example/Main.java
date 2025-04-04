package org.example;

import java.util.HashMap;
import java.util.HashSet;

// 1817. Finding the Users Active Minutes
public class Main {
    public static void main(String[] args) {

    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int minute = logs[i][1];
            map.computeIfAbsent(id, x -> new HashSet<>()).add(minute);

//            for (int j = 0; j < logs[i].length; j++) {
//                if (map.containsKey(id)) {
//                    var set = map.get(id);
//                    set.add(logs[i][1]);
//                } else {
//                    var set = new HashSet<Integer>();
//                    set.add(logs[i][1]);
//                    map.put(id, set);
//                }
//            }
        }

        int[] res = new int[k];

        // UAM
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            int uam = entry.getValue().size();
            if (uam <= k) { // just check bounds
                res[uam - 1]++;
            }
        }

        return res;
    }
}