package org.atanu.java.ds.string;

public class StringProblem3 {

    public static boolean checkRotatedSol1(String X, String Y) {

        if (X.length() != Y.length()) {
            return false;
        }

        String str = X + X;

        System.out.println(str);

        if (str.indexOf(Y) != -1) {
            return true;
        }

        System.out.println(str);
        return false;
    }

    public static boolean checkRotatedSol2(String X, String Y) {

        if (X.length() != Y.length()) {
            return false;
        }

        int m = X.length();

        for (int i = 0; i < m; i++) {

            X = X.substring(1) + X.charAt(0);

            if (X.compareTo(Y) == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String X = "ABCD";
        String Y = "DABP";

        if (checkRotatedSol1(X, Y)) {
            System.out.println("Given Strings can be derived from each other");
        } else {
            System.out.println("Given Strings can not be derived from each other");
        }

        if (checkRotatedSol2(X, Y)) {
            System.out.println("Given Strings can be derived from each other");
        } else {
            System.out.println("Given Strings can not be derived from each other");
        }
    }

}
