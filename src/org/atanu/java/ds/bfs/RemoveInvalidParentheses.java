package org.atanu.java.ds.bfs;

import java.util.*;

//Leetcode 301
//https://leetcode.com/problems/remove-invalid-parentheses/
public class RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();
        if (s == null) {
            return result;
        }

        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        set.add(s);
        boolean found = false;

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (isValid(current)) {
                result.add(current);
                found = true;
            }
            //This is tricky. Once we found valid
            //we don't do any further bfs using items pending in the queue
            // since any further bfs would only create strings of smaller length
            // However the items already in queue need to be processed.
            // If the current level's parentheses are valid, there might be possibiluty that the valid string is not teh first
            // In that case next level parentheses will be added in the queue for the srings appeared before the first found
            // the next level parentheses in the queue will not be added to our result,
            // because only even number of string size could make it valid.
            if (found)
                continue;

            // generate all possible states
            for (int i = 0; i < current.length(); i++) {
                // we only try to remove left or right paren
                if (current.charAt(i) != '(' && current.charAt(i) != ')')
                    continue;
                String temp = current.substring(0, i) + current.substring(i + 1);
                // for each state, if it's not visited, add it to the queue
                if (!set.contains(temp)) {
                    queue.offer(temp);
                    set.add(temp);
                }
            }

        }
        return result;
    }

    // helper function checks if string s contains valid parantheses
    boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                count++;
            if (s.charAt(i) == ')') {
                if (count == 0)
                    return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
        String s = "()())()";
        List<String> result = removeInvalidParentheses.removeInvalidParentheses(s);
        result.forEach(System.out::println);
    }
}
