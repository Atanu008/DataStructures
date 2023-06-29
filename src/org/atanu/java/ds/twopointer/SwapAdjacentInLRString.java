package org.atanu.java.ds.twopointer;

public class SwapAdjacentInLRString {

    //There are three kinds of characters, ‘L’, ‘R’, ‘X’.
    //Replacing XL with LX = move L to the left by one
    //Replacing RX with XR = move R to the right by one
    //If we remove all the X in both strings, the resulting strings should be the same.

    //We first compare two strings with X removed. This checks relative position between Ls and Rs are correct.

    //Then we find the indices for each occurence of L and check the condition in the above figure. Then we do the same for R.

    //Its exactly same as //https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/
    //LeetCode 2337

    public boolean canTransform(String start, String end) {
        int iStart = 0;
        int iTarget = 0;
        if (start.length() != end.length()) {
            return false;
        }
        int n = start.length();

        while (iStart < n || iTarget < n) {

            while (iStart < n && start.charAt(iStart) == 'X') {
                iStart++;
            }

            while (iTarget < n && end.charAt(iTarget) == 'X') {
                iTarget++;
            }

            //Return true if one of them reaches end
            if (iStart == n || iTarget == n) {
                return iStart == n && iTarget == n; // Return if both pointer reaches end
            }
            //Return false if either of them reaches end
            //Or the character does not match
            if (start.charAt(iStart) != end.charAt(iTarget)) {
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
        String start = "RXXLRXRXL", end = "XRLXXRRLX";
        boolean canTransform = new SwapAdjacentInLRString().canTransform(start, end);
        System.out.println(canTransform);
    }
}
