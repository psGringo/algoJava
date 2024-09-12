package org.example;

/**
 * https://leetcode.com/problems/defanging-an-ip-address/description/
 */
public class Main {
    public static void main(String[] args) {
        var res = defangIPaddr("255.100.50.0");
    }

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}

