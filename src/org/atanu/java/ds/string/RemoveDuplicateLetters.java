package org.atanu.java.ds.string;

import java.util.*;

//https://leetcode.com/problems/remove-duplicate-letters/
//LeetCode 316
//Same As
//https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
//LeetCode 1081 -- In Stack package
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {

        Stack<Character> stack = new Stack<>();
        // this lets us keep track of what's in our solution in O(1) time
        Set<Character> seen = new HashSet<>();
        // this will let us know if there are any more instances of s[i] left in s
        Map<Character, Integer> lastOccurance = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lastOccurance.put(s.charAt(i), i);
        }

        for(int i = 0; i < s.length(); i++) {

            char currentChar = s.charAt(i);
            // we can only try to add c if it's not already in our solution
            // this is to maintain only one of each character
            if(!seen.contains(currentChar)) {
                // if the last letter in our solution:
                //     1. exists
                //     2. is greater than c so removing it will make the string smaller
                //     3. it's not the last occurrence
                // we remove it from the solution to keep the solution
                while(!stack.isEmpty() && currentChar < stack.peek() && lastOccurance.get(stack.peek()) > i){
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
