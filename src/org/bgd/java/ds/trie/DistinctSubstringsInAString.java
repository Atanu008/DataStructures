package org.bgd.java.ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.naukri.com/code360/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos">...</a>
 * Given a string 'S', you are supposed to return the number of distinct substrings(including empty substring) of the given string. You should implement the program using a trie.
 * Sample Input 1 :
 * 2
 * sds
 * abc
 * Sample Output 1 :
 * 6
 * 7
 * Explanation of Sample Input 1 :
 * In the first test case, the 6 distinct substrings are { ‘s’,’ d’, ”sd”, ”ds”, ”sds”, “” }
 * In the second test case, the 7 distinct substrings are {‘a’, ‘b’, ‘c’, “ab”, “bc”, “abc”, “” }.
 * Sample Input 2 :
 * 2
 * aa
 * abab
 * Sample Output 2 :
 * 3
 * 8
 * Explanation of Sample Input 2 :
 * In the first test case, the two distinct substrings are {‘a’, “aa”, “” }.
 * In the second test case, the seven distinct substrings are {‘a’, ‘b’, “ab”, “ba”, “aba”, “bab”, “abab”, “” }
 * Hints:
 * 1. Can you think about a data structure that can be used to store the distinct substrings?
 * 2. Can you think about using the fact that every substring of ‘S’ is a prefix of some suffix string of ‘S’?
 * 3. Try to insert every suffix of the string in Trie.
 */
public class DistinctSubstringsInAString {

    static class TrieNode {
        int count;
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
            this.count = 0;
        }
    }

    TrieNode root;

    public int countDistinctSubstrings(String s) {

        root = new TrieNode();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            TrieNode head = root;
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!head.children.containsKey(c)) {
                    head.children.put(c, new TrieNode());
                    count++;
                }
                head = head.children.get(c);
            }
        }
        return count + 1;
    }
}
