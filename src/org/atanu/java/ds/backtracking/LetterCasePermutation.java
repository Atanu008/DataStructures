package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 784
//https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutation {
    public List<String> letterCasePermutation(String s) {

        List<String> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        backtrack(charArray, 0, result);
        return result;
    }

    private void backtrack(char[] charArray, int index, List<String> result) {
        if (index == charArray.length) {
            result.add(new String(charArray));
            return;
        }
        char ch = charArray[index];
        if (Character.isDigit(ch)) {//if it is a digit, continue
            backtrack(charArray, index + 1, result);
        } else {
            charArray[index] = Character.toUpperCase(ch);
            backtrack(charArray, index + 1, result);
            charArray[index] = Character.toLowerCase(ch);
            backtrack(charArray, index + 1, result);
        }
    }

    public static void main(String[] args) {
        LetterCasePermutation letterCasePermutation = new LetterCasePermutation();
        String s = "a1b2";
        List<String> result = letterCasePermutation.letterCasePermutation(s);
        result.forEach(System.out::println);
    }
}
