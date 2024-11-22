package org.example;


public class Main {
    public static void main(String[] args) {

    }

    /**
     * Logic
     * The main observation here is that any string consisting of the same letters is a palindrome.
     * Since we're working with subsequences and the only characters in the string are 'a' and 'b', we know we can get rid of all palindromes in at most 2 steps.
     *
     *
     * It's quite easy to trip over this problem since it looks like we have to do all sorts of stuff to the string to get our answer. Actually, once you identify the main trick behind this question, it's really quite a simple algorithm!
     *
     * What is a Subsequence?
     * This is quite important to understand. Below are the main string sub-types (literally) that could be mentioned in a question.
     *
     * Substring: A contiguous sequence of characters in a string.
     * Subsequence: Any sequence of characters in a string where their relative order is maintained.
     * In particular, this question is asking to remove subsequences in the string. Therefore, we don't actually care where these subsequences are as long as they maintain their original relative ordering in the string. For example, a subsequence of "leetcode" could be "toe".
     *
     * The Major Observation:
     * What makes a subsequence a palindrome? Well of course it's when the string is the same forwards and backwards. Is "a" a palindrome? Yes. Is "aa" a palindrome? Yes. What about "aaaaaaaaa"? Yes!
     *
     * @param s
     * @return
     */
    public int removePalindromeSub(String s) {
         return isPalindrome(s) ? 1 : 2;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }


}