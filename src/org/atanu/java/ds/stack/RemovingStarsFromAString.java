package org.atanu.java.ds.stack;

// https://leetcode.com/problems/removing-stars-from-a-string/description/
// Leetcode 2390

import java.util.Stack;

//Initialize an empty list ans that will be used to build the modified string.
//Loop through each character i in the input string s.
//If the current character i is an asterisk, remove the last element from the ans list.
//If the current character i is not an asterisk, add it to the end of the ans list.
//Join the elements in the ans list into a string and return the result.

public class RemovingStarsFromAString {
    public String removeStars(String s) {

        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '*' && !stack.isEmpty()){
                stack.pop();
            }
            else{
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
