package org.atanu.java.ds.string;

//https://leetcode.com/problems/count-binary-substrings/
//LeetCode 696
//Video : https://www.youtube.com/watch?v=MGPHPadxhtQ&t=151s might be helpful
//Algorith Intuition
//We can observe from the above examples that our final count will only depend on the consecutive counts of binary characters. With each two groups of consecutive characters, the number of substrings that can be formed will be minimum of count among the two groups.
//
//Now, although we could maintain all the groupings and their counts and then count the number of substrings, we actually don't even need to maintain the consecutive counts in all of the string. We can just store the current consecutive count and previous consecutive count and count the substrings on the fly.
//
//s[i] == s[i - 1] : When current character is equal to previous - just increment the current consecutive count.
//s[i] != s[i - 1] :Whenever current character is not equal to previous - We know that we atleast have group of 2 different characters having consecutiveCount >= 1. The number of substrings that can be formed from these would be equal to minimum of currentConsecutiveCount & prevConsecutiveCount.
//So just add that amount to ans. Now prevConsecutiveCount will become equal to currentConsecutiveCount and reset the currentCon
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {

        int previousRunningLength = 0;
        int currentRunningLength = 1;
        int count = 0;

        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                currentRunningLength++;
            }
            else{
                count += Math.min(previousRunningLength, currentRunningLength);
                previousRunningLength = currentRunningLength;
                currentRunningLength = 1;
            }
        }

        count += Math.min(previousRunningLength, currentRunningLength);

        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        String s = "00110011";
        //Output: 6
        //Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
        //Notice that some of these substrings repeat and are counted the number of times they occur.
        //Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
        System.out.println("Binary Substrings "+ countBinarySubstrings.countBinarySubstrings(s));
    }
}
