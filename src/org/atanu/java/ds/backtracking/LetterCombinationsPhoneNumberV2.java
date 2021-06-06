package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
//Leetcode 17
public class LetterCombinationsPhoneNumberV2 {
    public List<String> letterCombinations(String digits) {

        String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        List<String> result = new ArrayList<>();

        if(digits == null || digits.length() == 0){
            return result;
        }

        dfs(digits,0,"",map,result);

        return result;

    }

    public void dfs(String digits, int index, String prefix, String[] map, List<String> result){

        if(index >= digits.length()){
            result.add(prefix);
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++){
            //as prefix is string . it is working as backtrack
            dfs(digits,index+1,prefix + letters.charAt(i),map,result);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumberV2 combinationsPhoneNumber = new LetterCombinationsPhoneNumberV2();
        String number = "23";
        List<String> result = combinationsPhoneNumber.letterCombinations(number);
        System.out.println(result);

    }
}
