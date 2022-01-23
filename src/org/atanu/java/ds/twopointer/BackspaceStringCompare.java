package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/backspace-string-compare/
//LeetCode 844
//Stack Solution is present in Stack

//The time complexity of the above algorithm will be O(M+N)O(M+N)
//where ‘M’ and ‘N’ are the lengths of the two input strings respectively.
public class BackspaceStringCompare {
    //To compare the given strings, first, we need to apply the backspaces.
    //An efficient way to do this would be from the end of both the strings.
    //We can have separate pointers, pointing to the last element of the given strings.
    //We can start comparing the characters pointed out by both the pointers to see if the strings are equal.
    //If, at any stage, the character pointed out by any of the pointers is a backspace (’#’),
    //we will skip and apply the backspace until we have a valid character available for comparison.
    public boolean backspaceCompare(String s, String t) {

        int index1 = s.length() - 1;
        int index2 = t.length() - 1;

        while (index1 >= 0 || index2 >= 0) {

            int i1 = getIndexOfNextValidChar(s, index1);
            int i2 = getIndexOfNextValidChar(t, index2);

            if (i1 < 0 && i2 < 0) {
                return true;
            }

            if (i1 < 0 || i2 < 0) {
                return false;
            }

            if (s.charAt(i1) != t.charAt(i2)) {
                return false;
            }

            index1 = i1 - 1;
            index2 = i2 - 1;
        }
        return true;
    }

    private int getIndexOfNextValidChar(String str, int index) {

        int backspaceCount = 0;
        while (index >= 0) {

            if (str.charAt(index) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                break;
            }

            index--;
        }

        return index;
    }
}
