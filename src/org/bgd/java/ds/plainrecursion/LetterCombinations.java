package org.bgd.java.ds.plainrecursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">...</a>
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below.
 *
 * Note that 1 does not map to any letters.
 */
public class LetterCombinations {

    Map<String, String> map = Map.of("2", "abc", "3", "def", "4", "ghi", "5", "jkl", "6", "mno", "7", "pqrs", "8", "tuv", "9", "wxyz");
    private String digits;
    List<String> strings;

    public List<String> letterCombinations(String digits) {
        this.strings = new ArrayList<>();
        this.digits = digits;
        if (digits.isEmpty()) {
            return strings;
        }
        letterRec(new StringBuilder(), 0);
        return strings;
    }

    private void letterRec(StringBuilder path, int index) {
        if (digits.length() == path.length()) {
            strings.add(path.toString());
            return;
        }

        String letters = map.get("" + digits.charAt(index));
        for (Character c : letters.toCharArray()) {
            path.append(c);
            letterRec(path, index + 1);
            path.deleteCharAt(path.length() - 1);
        }

    }
}
