package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/valid-palindrome-ii/
// LeetCode 680
// Video : https://www.youtube.com/watch?v=JrxRYBwG6EI
public class ValidPalindromeII {

    // We can use the standard two-pointer approach that starts at the left and right of the string and move inwards.
    // Whenever there is a mismatch,
    //  we can either exclude the character at the left or the right pointer.
    //  We then take the two remaining substrings and see if either one is a palindrome
    //  If any one part is palindrome then we can confirm that deleteing one char(start/end) will make the string palindrome
    // Whenever a match . proceed with next star and end
    //
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
        return true; //Flow will come only when the input is palindrome :)
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
