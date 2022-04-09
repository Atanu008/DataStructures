package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/valid-palindrome-ii/
//LeetCode 680
//Video : https://www.youtube.com/watch?v=JrxRYBwG6EI
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while(start < end) {
            if(s.charAt(start) != s.charAt(end)){
                return isPalindrome(s, start+1, end) || isPalindrome(s, start, end -1);
            }

            start++;
            end--;
        }

        return true; //Flow will come only when the input is palondrome :)
    }

    public boolean isPalindrome(String s , int start, int end) {

        while(start < end) {

            if(s.charAt(start) != s.charAt(end)){
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindromeII validPalindrome = new ValidPalindromeII();

        String s = "aba";
        //Output: true . String itself is Palindrome
        System.out.println(validPalindrome.validPalindrome(s));

        s = "abca";
        //Output: true
        //Explanation: You could delete the character 'c'.
        System.out.println(validPalindrome.validPalindrome(s));

        s = "abc";
        //Output: true . Can not remove at most one char to make it Palindrome
        System.out.println(validPalindrome.validPalindrome(s));
    }
}
