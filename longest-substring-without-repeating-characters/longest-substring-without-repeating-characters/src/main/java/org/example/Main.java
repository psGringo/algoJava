package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class Main {
    public static void main(String[] args) {
        lengthOfLongestSubstringTwoPointers("pwwkew");
    }


    public static int lengthOfLongestSubstringTwoPointers(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            int sizeBefore = set.size();
            set.add(s.charAt(right));
            int sizeAfter = set.size();
            if (sizeBefore != sizeAfter) {
                right++;
            } else {
                max = Math.max(max, set.size());
                set.remove(s.charAt(left));
                left++;
            }
        }
        return Math.max(max, set.size());
    }


    public static int lengthOfLongestSubstring(String s) {

        int currIndex = 0;
        int endIndex = s.length() - 1;
        HashSet<Character> chars = new HashSet<>();
        int substrLength = 0;
        int maxSubstrLenth = 0;

        while (currIndex <= endIndex) {

            for (int i = currIndex; i <= endIndex; i++) {
                if (!chars.contains(s.charAt(i))) {
                    substrLength++;
                    chars.add(s.charAt(i));
                    if (substrLength > maxSubstrLenth) {
                        maxSubstrLenth = substrLength;
                    }
                } else {
                    chars.clear();
                    substrLength = 0;
                    break;
                }

            }
            currIndex++;
        }

        return maxSubstrLenth;
    }

}