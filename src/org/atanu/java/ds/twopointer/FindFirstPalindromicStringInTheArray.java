package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/find-first-palindromic-string-in-the-array/description/
// Leetcode 2108

public class FindFirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {

        for(String word : words){
            if(isPalindrome(word)){
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word){
        int i = 0;
        int j = word.length() - 1;

        while(i < j){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abc","car","ada","racecar","cool"};
        System.out.println(new FindFirstPalindromicStringInTheArray().firstPalindrome(words));
    }
}
