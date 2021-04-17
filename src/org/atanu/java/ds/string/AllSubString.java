package org.atanu.java.ds.string;

public class AllSubString {

    public static void printAllSubString(String str) {

        for (int i = 0; i < str.length(); i++) {

            for (int j = i; j < str.length(); j++) {

                System.out.println(str.substring(i, j + 1));
            }
        }
    }

    public static void main(String[] args) {

        printAllSubString("abcdef");

    }

}
