package org.atanu.java.ds.dp;

// Variation Of Longest Increasing Subsequence
// https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/g2Nyy34V0l3

public class MinimumDeletionsToMakeASequenceSorted {

    /*
    we can convert this problem into a Longest Increasing Subsequence (LIS) problem.
    As we know that LIS will give us the length of the longest increasing subsequence (in the sorted order!),
    which means that the elements which are not part of the LIS should be removed to make the sequence sorted.
    This is exactly what we need.
    So we’ll get our solution by subtracting the length of LIS from the length of the input array:
    Length-of-input-array - LIS()
     */

    // Let’s say we have an integer array, [4, 2, 3, 6, 10, 1, 12],
    // and we want to delete the minimum number of elements to make the remaining sequence sorted.
    // We can do this by finding the length of the longest increasing subsequence first,
    // which is 5 here because the longest increasing subsequence is [2, 3, 6, 10, 12].
    // All elements other than this should be removed to get a sorted sequence.
    // We need to remove 4 and 1 from the array.
    // So, the minimum number of deletions required is 2. We can formulate this relationship as:
    // Minimum Deletions = Array Length − LIS Length
    public int findMinimumDeletions(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        //Base Case. For one element Subsequence is always one
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            //Base Case. For one element Subsequence is always one
            dp[i] = 1;
            //Check for all previous elements.
            //If (nums[i] > nums[j] then take the length of jth element(i.e dp[j]) + 1(means teh ith element)
            //Take the maximum while evluating all js
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }

            }
        }
        return nums.length - maxLength;

    }

    public static void main(String[] args) {

        MinimumDeletionsToMakeASequenceSorted makeASequenceSorted = new MinimumDeletionsToMakeASequenceSorted();
        int[] nums = {4,2,3,6,10,1,12};
        //Output: 2
        //Explanation: We need to delete {4,1} to make the remaining sequence sorted {2,3,6,10,12}.
        System.out.println(makeASequenceSorted.findMinimumDeletions(nums));
        nums = new int[]{-4,10,3,7,15};
        System.out.println(makeASequenceSorted.findMinimumDeletions(nums));
        nums = new int[]{3,2,1,0};
        System.out.println(makeASequenceSorted.findMinimumDeletions(nums));
    }
}
