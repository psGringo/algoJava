package org.example;


import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
       checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
    }

    public static boolean checkIfPangram(String sentence) {
        Set<Character> set = new HashSet<>();
        for (char c : sentence.toCharArray()) {
            set.add(c);
        }

        for (int i = 97; i <= 122; i++) {
            if (!set.contains((char) i)) {
                return false;
            }
        }

        return true;
    }

}