package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/?envType=problem-list-v2&envId=vthevgcm
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * LeetCode 1233 — Remove Sub-Folders from the Filesystem
     *
     * Idea:
     * 1) Sort paths lexicographically so that every subfolder appears
     *    immediately after its parent (e.g., "/a" before "/a/b", "/a/b/c").
     * 2) Walk left → right and keep a path only if it is NOT prefixed by
     *    (lastKept + "/"). Using the trailing "/" avoids false matches like
     *    "/a" being a prefix of "/ab".
     *
     * Time:  O(n log n) for sort + O(total length) scan
     * Space: O(n) for the result
     */
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> res = new ArrayList<>();

        for (String f : folder) {
            if (res.isEmpty()) {
                res.add(f);
            } else {
                String parentPrefix = res.get(res.size() - 1) + "/";
                if (!f.startsWith(parentPrefix)) {
                    res.add(f);
                }
                // else: f is a subfolder of the last kept path → skip
            }
        }
        return res;
    }
}