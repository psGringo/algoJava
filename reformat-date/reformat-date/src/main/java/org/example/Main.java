package org.example;


import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        reformatDate("20th Oct 2052");
    }

    public static String reformatDate(String date) {

        HashMap<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "01");
        monthMap.put("Feb", "02");
        monthMap.put("Mar", "03");
        monthMap.put("Apr", "04");
        monthMap.put("May", "05");
        monthMap.put("Jun", "06");
        monthMap.put("Jul", "07");
        monthMap.put("Aug", "08");
        monthMap.put("Sep", "09");
        monthMap.put("Oct", "10");
        monthMap.put("Nov", "11");
        monthMap.put("Dec", "12");

        String[] dateParts = date.split(" ");
        String year = dateParts[2];
        String month = monthMap.get(dateParts[1]);
        String day = parseDate(dateParts[0]);

        return String.format("%s-%s-%s", year, month, day);
    }

    private static String parseDate(String date) {
        StringBuilder sb = new StringBuilder();
        for (char c : date.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }

        if (sb.length() == 1) {
            sb.append('0');
            return sb.reverse().toString();
        }

        return sb.toString();
    }
}