package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/B1w5xqOrm6J
//https://www.techiedelight.com/minimum-sum-partition-problem/

//Video : https://www.youtube.com/watch?v=FB0KUhsxXGY&list=PLEJXowNB4kPxBwaXtRO1qFLpCzF75DYrS&index=11

//Given a set of integers,
//the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

//If there is a set S with n elements, then if we assume Subset1 has m elements,
//Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

import java.util.HashMap;
import java.util.Map;

public class PartitionIntoTwoSubToMinimizeSumDifference {

    public int findMinAbsDiff(int[] nums, int i, int sum1, int sum2, Map<String, Integer> dp){
        // Base case: if the list becomes empty, return the absolute
        // difference between both sets
        if(i == nums.length){
            return Math.abs(sum1 - sum2);
        }

        // Construct a unique map key from dynamic elements of the input.
        // Note that we can uniquely identify the subproblem with `i` and `sum1` only,
        // as `sum2` is nothing but `S-sum1`, where `S` is the sum of all elements
        String key = i + "|" + sum1;

        if (!dp.containsKey(key)){
            // Case 1. Include the current item in subset `sum1` and recur
            // for the remaining items i+1
            int include = findMinAbsDiff(nums, i + 1, sum1 + nums[i], sum2, dp);
            // Case 2. Exclude the current item from subset `sum1` and include in sum2 and recur for
            // the remaining items `i+1'
            int exclude = findMinAbsDiff(nums, i + 1, sum1, sum2 + nums[i], dp);

            dp.put(key, Math.min(include, exclude));

        }

        return dp.get(key);
    }

    public static void main(String[] args) {

        PartitionIntoTwoSubToMinimizeSumDifference partition = new PartitionIntoTwoSubToMinimizeSumDifference();
        // Input: a set of items
        int[] S = { 10, 20, 15, 5, 25 };
        // create a map to store solutions to subproblems
        Map<String, Integer> lookup = new HashMap<>();

        System.out.println("The minimum difference is "
                + partition.findMinAbsDiff(S, 0, 0, 0, lookup));
    }
}
