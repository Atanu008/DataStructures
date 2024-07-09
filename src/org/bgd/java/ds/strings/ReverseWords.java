package org.bgd.java.ds.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string/description/">...</a>
 *
 * Given an input string s, reverse the order of the words.
 *
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String[] words = s.trim()
          .split("\\s");

        StringBuilder sb = new StringBuilder();
        for (String w : words) {

            if (w.length() >= 1) {
                sb.append(reverse(w.trim()));
                sb.append(" ");
            }

        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.reverse()
          .toString();
    }

    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == 32) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new ReverseWords().reverseWords("a good   example");
    }

    /**
     * BuiltIn Methods
     */
    public String reverseWordsBuiltin(String s) {
        s = s.trim();
        StringBuilder res = new StringBuilder();
        List<String> words = Arrays.asList(s.split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
