package org.atanu.java.ds.string;

// https://leetcode.com/problems/length-of-last-word/description/
// Leetcode 58

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        int p = s.length() -1;
        //Trim last characters
        while(p >= 0 && s.charAt(p) == ' '){
            p--;
        }

        int length = 0;
        while(p >= 0 && s.charAt(p) != ' '){
            length++;
            p--;
        }

        return length;
    }

    public static void main(String[] args) {

        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String s = "   fly me   to   the moon  ";
        //Output: 4
        //Explanation: The last word is "moon" with length 4.
        System.out.println(lengthOfLastWord.lengthOfLastWord(s));

        s = "luffy is still joyboy";
        //Output: 6
        //Explanation: The last word is "joyboy" with length 6.
        System.out.println(lengthOfLastWord.lengthOfLastWord(s));
    }
}
