package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/get-equal-substrings-within-budget/
//LeetCode 1208
public class GetEqualSubstringsWithinBudget {

    // we can use a sliding window
    // We slide the end of the window to the right with each step
    // Calculate the running cost difference sum of current window
    // If the running cost difference sum exceeds the maxCost,
    // we slide the start of the window to the right until the total sum inside the window is less than maxCosts
    // With each eligible window, we take the length and keep track of the maximum length.

    public int equalSubstring(String s, String t, int maxCost) {

        int windowEnd = 0;
        int windowStart = 0;
        int cost = 0;
        int maxLength = 0;
        while(windowEnd < s.length()){

            cost+= Math.abs(s.charAt(windowEnd) - t.charAt(windowEnd));

            while(cost > maxCost){
                cost -= Math.abs(s.charAt(windowStart) - t.charAt(windowStart));
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart +1);
            windowEnd++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        GetEqualSubstringsWithinBudget getEqualSubstringsWithinBudget = new GetEqualSubstringsWithinBudget();
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        int maxLength = getEqualSubstringsWithinBudget.equalSubstring(s,t,maxCost);
        //Output: 3
        //Explanation: "abc" of s can change to "bcd".
        //That costs 3, so the maximum length is
        System.out.println("Max Length EqualSubstringsWithinBudget "+ maxLength);

        s = "abcd";
        t = "cdef";
        maxCost = 3;
        maxLength = getEqualSubstringsWithinBudget.equalSubstring(s,t,maxCost);
        //Output: 1
        //Explanation: Each character in s costs 2 to change to character in t,  so the maximum length is 1.
        System.out.println("Max Length EqualSubstringsWithinBudget "+ maxLength);
    }
}
