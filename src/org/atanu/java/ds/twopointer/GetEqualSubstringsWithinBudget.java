package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/get-equal-substrings-within-budget/
//LeetCode 1208
public class GetEqualSubstringsWithinBudget {

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
    }
}
