package org.atanu.java.ds.dp;

//https://leetcode.com/problems/palindrome-partitioning-ii/description/
//Leetcode 132
//Same logic as the Top Down(recursive one)
//Bottom UP
public class PalindromePartitioningII_v3 {
    public int minCut(String s) {
        int n = s.length();
        Integer[] cutsDp = new Integer[n];
        boolean[][] palindromeDp = new boolean[n][n];
        // build the palindrome cutsDp for all susbtrings
        buildPalindromeDp(s, palindromeDp);

        for (int end = 0; end < s.length(); end++) {
            int minimumCut = end;
            for (int start = 0; start <= end; start++) {
                if (palindromeDp[start][end]) {
                    // If the left part is palindrome(palindromeDp[start][end])
                    //Case A : Start = 0 and tthe substring (start, end) is palindrome means No cut is needed
                    //Case B : Take the minumum from left part + One(for the current cut)
                    minimumCut = start == 0 ? 0 : Math.min(minimumCut, cutsDp[start - 1] + 1);
                }
            }
            cutsDp[end] = minimumCut;
        }
        return cutsDp[s.length() - 1];
    }

    private void buildPalindromeDp(String s, boolean[][] palindromeDp) {
        for (int end = 0; end < s.length(); end++) {
            for (int start = 0; start <= end; start++) {
                if (s.charAt(start) == s.charAt(end) && (end - start <= 2 ||
                        palindromeDp[start + 1][end - 1])) {
                    palindromeDp[start][end] = true;
                }
            }
        }
    }
}
