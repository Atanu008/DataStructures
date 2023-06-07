package org.atanu.java.ds.twopointer;

import java.util.Arrays;

// https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
// Leetcode 1838
// Video : https://www.youtube.com/watch?v=vgBrQ0NM5vE

public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {

        // Sort the Array , Then only we can apply our below algorithm
        Arrays.sort(nums);

        int windowStart = 0;
        int windowEnd = 0;
        int ans = Integer.MIN_VALUE;
        long sum = 0;
        while(windowEnd < nums.length){
            sum += nums[windowEnd];
            int windowLength = windowEnd - windowStart + 1;
            // Now we are pointing to windowEnd
            // If we need to make all elements in our window to have same value as current value i.e nums[windowStart]
            // then the Expected sum would be WindowLength * nums[windowStart] :
            // ExpectedSum = WindowLength * nums[windowStart]
            // we also have the actual sum of all numbers in the window
            // So the total operation it would take to convert actual sum to expected sum is :
            // ExpectedSum - sum i.e ((windowEnd - windowStart + 1) * nums[windowEnd]) - sum
            // If that is greater than k then its not a valid window
            // Shrink the window
            while((windowEnd - windowStart + 1) * nums[windowEnd] - sum > k){
                sum -= nums[windowStart];
                windowStart++;
            }

            ans = Math.max(ans, windowEnd - windowStart + 1);
            windowEnd++;
        }

        return ans;
    }

    public static void main(String[] args) {
        FrequencyOfTheMostFrequentElement frequencyOfTheMostFrequentElement = new FrequencyOfTheMostFrequentElement();
        int[] nums = {1,2,4};
        int k = 5;
        int result = frequencyOfTheMostFrequentElement.maxFrequency(nums, k);
        //Output: 3
        //Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
        //4 has a frequency of 3.
        System.out.println(result);
    }
}
