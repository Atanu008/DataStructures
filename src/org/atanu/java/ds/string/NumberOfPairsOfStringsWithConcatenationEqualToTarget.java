package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/description/
// Leetcode 2023
public class NumberOfPairsOfStringsWithConcatenationEqualToTarget {

    // Brute Force
    // Just concatenate and compare
    public int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && (nums[i] + nums[j]).equals(target)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // Video : https://www.youtube.com/watch?v=XH8jPbNw2uw
    public int numOfPairs_v2(String[] nums, String target) {

        Map<String, Integer> freq = new HashMap<>();
        int n = target.length();
        for (String num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        //check for substrings
        for (int i = 1; i <= n; i++) {
            String firstPart = target.substring(0, i);
            String secondPart = target.substring(i, n);
            // If Both strings are in that case do freq * (freq - 1)
            // otherwise freqA * freqB
            if (firstPart.equals(secondPart)) {
                int frequency = freq.getOrDefault(firstPart, 0);
                ans += frequency * (frequency - 1);
            } else {
                int frequencyFirst = freq.getOrDefault(firstPart, 0);
                int frequencySecond = freq.getOrDefault(secondPart, 0);
                ans += frequencyFirst * frequencySecond;
            }
        }

        return ans;
    }

    //Idea:
    //First, we store in a map the frequencies of the strings, so that we can find easily which strings we have and how many.
    //Now, we iterate through the freq map.
    //For every string:
    //
    //We check if it's a prefix of our target.
    //If yes, first case is that the target is exactly twice the prefix. If so, we add frq*(frq-1) to res.
    //The reason is that the number of combinations for a pattern with frequency n is n * (n-1).
    //Otherwise we look in the map if we have the suffix, if so - we add the product of their frequencies to res.

    public int numOfPairs_v3(String[] nums, String target) {
        Map<String, Integer> freq = new HashMap<>();
        int n = target.length();
        for (String num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        //check for substrings
        for (String firstPart : freq.keySet()) {

            // If Both strings are in that case do freq * (freq - 1)
            // otherwise freqA * freqB
            if (target.startsWith(firstPart)) {
                if (target.equals(firstPart + firstPart)) {
                    int frequency = freq.getOrDefault(firstPart, 0);
                    ans += frequency * (frequency - 1);
                } else if (freq.containsKey(target.substring(firstPart.length()))) {
                    int frequencyFirst = freq.get(firstPart);
                    int frequencySecond = freq.get(target.substring(firstPart.length()));
                    ans += frequencyFirst * frequencySecond;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfPairsOfStringsWithConcatenationEqualToTarget number = new NumberOfPairsOfStringsWithConcatenationEqualToTarget();
        String[] nums = {"777","7","77","77"};
        String target = "7777";

        int result = number.numOfPairs(nums, target);
        System.out.println(result);
        result = number.numOfPairs_v2(nums, target);
        System.out.println(result);
        result = number.numOfPairs_v3(nums, target);
        System.out.println(result);
    }

}
