package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 131
//https://leetcode.com/problems/palindrome-partitioning/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(result, current, s, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> current, String s, int index) {
        if(index == s.length()){
            result.add(new ArrayList<>(current));
        }

        for(int i = index; i < s.length(); i++){
            if(isPalindrome(s, index , i)){
                String sbString = s.substring(index, i+1);
                current.add(sbString);
                backtrack(result, current, s, i+1);
                current.remove(current.size() -1);
            }
        }
    }

    private boolean isPalindrome(String s, int i , int j) {
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        String s = "aab";
        List<List<String>> result = palindromePartitioning.partition(s);
        result.forEach(System.out::println);
    }
}
