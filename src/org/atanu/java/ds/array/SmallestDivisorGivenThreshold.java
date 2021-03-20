package org.atanu.java.ds.array;

//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/submissions/
//https://www.wikiwand.com/en/Binary_search_algorithm
public class SmallestDivisorGivenThreshold {

    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 6;
        while (left <= right) {
            int m = (left + right) / 2, sum = 0;
            for (int i : nums)
                sum += (i + m - 1) / m;
            if (sum > threshold)
                left = m + 1;
            else
                right = m - 1;
        }
        return left;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        int result = smallestDivisor(nums, threshold);
        System.out.println(result);
    }
}