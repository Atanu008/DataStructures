package org.atanu.java.ds.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

//https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
//LeetCode 1081
//same As
//https://leetcode.com/problems/remove-duplicate-letters/
//LeetCode 316 -- Check String package
public class SmallestSubsequenceOfDistinctCharacters {

    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        // this lets us keep track of what's in our solution in O(1) time
        Set<Character> seen = new HashSet<>();
        // this will let us know if there are any more instances of s[i] left in s
        int[] frequency = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency[ch - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            frequency[currentChar - 'a']--;
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if(!seen.contains(currentChar)) {
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution
                while(!stack.isEmpty() && currentChar < stack.peek() && frequency[stack.peek() - 'a'] > 0){
                    seen.remove(stack.pop());
                }
                stack.push(currentChar);
                seen.add(currentChar);
            }


        }

        StringBuilder sb = new StringBuilder();
        for(char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
