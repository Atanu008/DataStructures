package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/valid-palindrome/
//LeetCode 125
public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if(s == null || s.isEmpty()){
            return true;
        }

        int i = 0;
        int j = s.length() -1;

        while(i <= j){
            int headChar = s.charAt(i);
            int tailChar = s.charAt(j);

            if(!Character.isLetterOrDigit(headChar)){
                i++;
            }
            else if(!Character.isLetterOrDigit(tailChar)){
                j--;
            }
            else {
                if(Character.toLowerCase(headChar) != Character.toLowerCase(tailChar)){
                    return false;
                }
                i++;
                j--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        //Output: true
        //Explanation: "amanaplanacanalpanama" is a palindrome.
        System.out.println("Valid Palindrome "+ validPalindrome.isPalindrome(s));
        s = "race a car";
        //Output: false
        //Explanation: "raceacar" is not a palindrome.
        System.out.println("Valid Palindrome "+ validPalindrome.isPalindrome(s));
    }
}
