package org.example;


import java.util.HashSet;

/**
 * https://leetcode.com/problems/unique-email-addresses/description/
 */
public class Main {
    public static void main(String[] args) {
        numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"});
    }

    public static int numUniqueEmails(String[] emails) {
        // m.y+name@email.com
        // m.y+name@email.com
        HashSet<String> uniqueEmails = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String email : emails) {
            String[] emailParts = email.split("@");
            String localNamePart = emailParts[0].replaceAll("\\.", "");
            int indexOfPlus = localNamePart.indexOf('+');
            if (indexOfPlus != -1) {
                localNamePart = localNamePart.substring(0, indexOfPlus);
            }
            String domainPart = emailParts[1];
            sb.append(localNamePart);
            sb.append('@');
            sb.append(domainPart);
            uniqueEmails.add(sb.toString());
            sb.setLength(0);
        }
        return uniqueEmails.size();
    }
}