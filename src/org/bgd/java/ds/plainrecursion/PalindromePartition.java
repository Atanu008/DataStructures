package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/description/">...</a>
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
    private List<List<String>> answer;
    private String input;

    public List<List<String>> partition(String s) {
        this.answer = new ArrayList<>();
        this.input = s;
        partition(0, new ArrayList<>());
        return answer;
    }

    private void partition(int index, List<String> strings) {
        if (index == input.length()) {
            answer.add(new ArrayList<>(strings));
            return;
        }

        for (int i = index; i < input.length(); i++) {
            String toConsider = input.substring(index, i + 1);
            if (isPalindrome(toConsider)) {
                strings.add(toConsider);
                partition(i + 1, strings);
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
            l++;
            r--;
        }
        return true;
    }
}
