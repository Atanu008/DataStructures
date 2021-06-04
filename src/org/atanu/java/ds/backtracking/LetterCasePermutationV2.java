package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 784
//https://leetcode.com/problems/letter-case-permutation/
public class LetterCasePermutationV2 {
    public List<String> letterCasePermutation(String s) {

        List<String> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        backtrack(charArray, 0, result);
        return result;
    }

    private void backtrack(char[] charArray, int index, List<String> result) {
        //Just add it. No need to check for length. this method is called for every change.
        result.add(new String(charArray));

        for (int i = index; i < charArray.length; i++) {
            char ch = charArray[i];
            //If the Char is Upper make it to lower and do DFS . after DFS revert it(make upper again)
            // For lower do the opposite
            if (Character.isLetter(ch)) {
                if(Character.isUpperCase(ch))
                    charArray[i] = Character.toLowerCase(ch);
                else
                    charArray[i] = Character.toUpperCase(ch);
                backtrack(charArray, i + 1, result);
                if(Character.isUpperCase(ch))
                    charArray[i] = Character.toUpperCase(ch);
                else
                    charArray[i] = Character.toLowerCase(ch);

            }
        }

    }

    public static void main(String[] args) {
        LetterCasePermutationV2 letterCasePermutation = new LetterCasePermutationV2();
        String s = "a1b2";
        List<String> result = letterCasePermutation.letterCasePermutation(s);
        result.forEach(System.out::println);
    }
}
