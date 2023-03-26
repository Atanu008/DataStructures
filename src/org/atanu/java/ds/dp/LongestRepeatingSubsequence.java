package org.atanu.java.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/g2VxB8gqY1j
//https://www.techiedelight.com/longest-repeated-subsequence-problem/

public class LongestRepeatingSubsequence {
    public int findLRS(String str) {

        Map<String, Integer> memo = new HashMap<>();
        return findLRS(str, str.length(), str.length(), memo);
    }

    public int findLRS(String str, int p1, int p2, Map<String, Integer> memo){

        if(p1 == 0 || p2 == 0){
            return 0;
        }
        // construct a unique map key from dynamic elements of the input
        String key = p1 + " - " + p2;

        // if the subproblem is seen for the first time, solve it and
        // store its result in a map
        if(!memo.containsKey(key)){
            // if characters at index `m` and `n` matches and the index are different
            if(str.charAt(p1 - 1) == str.charAt(p2 - 1) && p1 != p2){
                memo.put(key, findLRS(str, p1 -1, p2 - 1, memo) + 1); // +1
            }
            else{
                // otherwise, if characters at index `m` and `n` don't match
                memo.put(key, Math.max(findLRS(str, p1 -1, p2, memo),
                        findLRS(str, p1, p2 - 1, memo)
                ));
            }
        }
        // return the subproblem solution from the map
        return memo.get(key);
    }

    public static void main(String[] args) {

        LongestRepeatingSubsequence longestRepeatingSubsequence = new LongestRepeatingSubsequence();
        ArrayList<String> inputs = new ArrayList<String>(
                Arrays.asList("abcd", "abddccd", "abbaba", "aaaaba", "abcdaeda")
        );

        // Let's uncomment this and check the effect of dynamic programming using memoization
        // inputs.add("abcdefghijklmnopqrstuv");

        for (int i = 0; i < inputs.size(); i++) {
            System.out.println(i + 1 + ". String: " + inputs.get(i));
            System.out.println("Longest repeating subsequence is " + longestRepeatingSubsequence.findLRS(inputs.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-') + '\n');
        }
    }
}
