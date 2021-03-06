package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 17
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {

        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return result;
        }

        backtrack(digits,0, new StringBuilder(), map,result);

        return result;

    }

    private void backtrack(String digits, int index, StringBuilder sb, String[] map, List<String> result) {
        // index == digits.length()
        if(sb.length() == digits.length()){
            result.add(new String(sb));
            return;
        }

        String letters = map[digits.charAt(index) - '0'];
        for(int i = 0; i< letters.length(); i++){
            sb.append(letters.charAt(i));
            backtrack(digits,index+1, sb, map,result);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber combinationsPhoneNumber = new LetterCombinationsPhoneNumber();
        String number = "23";
        List<String> result = combinationsPhoneNumber.letterCombinations(number);
        System.out.println(result);
    }
}
