package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/
//:eetCode 2337
public class MovePiecesToObtainAString {

    //Just traverse both the strings and check whether relative charcters ('R' or 'L') are equal or not,
    //if they are equal,
    //then check their relative positions to see whether start can be converted to target or not

    //e.g. '-R' and 'R-' => here, relative characters 'R' and 'R' are equal
    //but index of 'R' in start is greater than index of 'R' in target, since 'R' can't move left,
    //hence we return false for this test case

    //Video : https://www.youtube.com/watch?v=313W6T134SE&t=540s
    public boolean canChange(String start, String target) {

        int iStart = 0;
        int iTarget = 0;
        if (start.length() != target.length()) {
            return false;
        }
        int n = start.length();

        while (iStart < n || iTarget < n) {

            while (iStart < n && start.charAt(iStart) == '_') {
                iStart++;
            }

            while (iTarget < n && target.charAt(iTarget) == '_') {
                iTarget++;
            }

            //Return true if one of them reaches end
            if (iStart == n || iTarget == n) {
                return iStart == n && iTarget == n; // Return if both pointer reaches end
            }
            //Return false if either of them reaches end
            //Or the character does not match
            if (start.charAt(iStart) != target.charAt(iTarget)) {
                return false;
            }

            //We have come here means both the charactere are same
            //Now check the relative position

            if (iStart < n && start.charAt(iStart) == 'L' && iStart < iTarget) {
                return false;
            }

            if (iStart < n && start.charAt(iStart) == 'R' && iStart > iTarget) {
                return false;
            }

            iStart++;
            iTarget++;

        }

        return iStart == n && iTarget == n; // Return if both pointer reaches end
    }

    public static void main(String[] args) {
        String start = "_L__R__R_", target = "L______RR";
        boolean canChange = new MovePiecesToObtainAString().canChange(start, target);
        System.out.println(canChange);
    }
}
