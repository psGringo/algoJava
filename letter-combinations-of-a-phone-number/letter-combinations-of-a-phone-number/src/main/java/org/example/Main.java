package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 */
public class Main {
    public static void main(String[] args) {
        letterCombinations("23");
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> combinations = new ArrayList<>();
        combinations.add("");

        if (digits == "") {
            return combinations;
        }

        for (int i = 0; i < digits.length(); i++) {
            List<String> localRes = addDigit(combinations, digits.charAt(i), map);
            combinations = localRes;
        }

        return combinations;
    }

    private static List<String> addDigit(List<String> combinations, char digit, HashMap<Integer, String> lettersMap) {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < combinations.size(); i++) {
            var combinations2 = addDigit(combinations.get(i), digit,lettersMap);
            results.addAll(combinations2);
        }
        return results;
    }

    private static List<String> addDigit(String input, char digit, HashMap<Integer, String> lettersMap) {
        List<String> res = new ArrayList<>();
        String letters = lettersMap.get(Character.digit(digit, 10));
        for (int i = 0; i < letters.length(); i++) {
            res.add(input + letters.charAt(i));
        }

        return res;
    };

    /*
    * public class Solution {
    public IList<string> LetterCombinations(string digits) {
        var result = new List<string>();
        var arr = new char[digits.Length];
        if(digits == "")
            return result;

        GenerateArrays(arr, 0, digits, result);
        return result;
    }

    public void GenerateArrays(char[] arr, int index, string digits, List<string> result)
    {
        if (index == arr.Length)
        {
            var res = new string(arr);
            result.Add(res);
            return;
        }

        var digit = digits[index];
        var chars = GetChars(digit);

        foreach(char c in chars)
        {
            arr[index] = c;
            GenerateArrays(arr, index + 1, digits, result);
        }
    }


    public char[] GetChars(char digit){
        if(digit == '2')
            return new []{'a','b','c'};
        if(digit == '3')
            return new []{'d','e','f'};
        if(digit == '4')
            return new []{'g','h','i'};
        if(digit == '5')
            return new []{'j','k','l'};
        if(digit == '6')
            return new []{'m','n','o'};
        if(digit == '7')
            return new []{'p','q','r', 's'};
        if(digit == '8')
            return new []{'t','u','v'};
        if(digit == '9')
            return new []{'w','x','y', 'z'};

        throw new Exception(digit.ToString());
    }
}
    * */

}