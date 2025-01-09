package org.example;


public class Main {
    public static void main(String[] args) {
        maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba");
    }

    public static int maxRepeating(String sequence, String word)
    {
        int a = word.length();
        int count = 0;
        StringBuilder sc = new StringBuilder(word);
        while(sequence.indexOf(sc.toString()) != -1)
        {
            count++;
            sc.append(word);
        }
        return count;
    }


    public static int maxRepeating2(String sequence, String word) {
        // Start from the maximum possible repetitions and decrement
        for (int k = sequence.length() / word.length(); k > 0; --k) {
            String repeatedWord = word.repeat(k); // Construct the word repeated 'k' times
            if (sequence.contains(repeatedWord)) { // Check if 'sequence' contains the repeated 'word'
                return k; // If found, return the current repetition count 'k'
            }
        }
        return 0; // If no repetition is found, return 0
    }

}
