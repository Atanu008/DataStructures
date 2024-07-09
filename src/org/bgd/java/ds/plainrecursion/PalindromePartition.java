package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/description/
 *
 * Given a string s, partition s such that every
 * substring
 *  of the partition is a
 * palindrome
 * . Return all possible palindrome partitioning of s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 */
public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<List<String>> answer = new ArrayList<>();
        partition(s, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void partition(String s, int index, List<String> strings, List<List<String>> answer) {
        if (index == s.length()) {
            answer.add(new ArrayList<>(strings));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String toConsider = s.substring(index, i + 1);
            if (isPalindrome(toConsider)) {
                strings.add(toConsider);
                partition(s, i + 1, strings, answer);
                strings.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
        }
        return true;
    }
}
