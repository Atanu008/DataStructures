package org.atanu.java.ds.matrix;

import java.util.TreeSet;

//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
//Leetcode 363

//Explanation : https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/solutions/1313721/java-python-sub-problem-max-sum-of-subarray-no-larger-than-k-clean-concise/?orderBy=most_votes

//Firstly, let solve this sub problem Max Sum of Subarray No Larger Than K, which is "Given an array of N integers, find the maximum sum of subarray which is no larger than K".
//Iterating index i from left to right.
//Calculate prefixSum so far, let name it right
//Try to find the left prefixSum so that right - left <= k => left >= right - k.
//We can use TreeSet (implemented as BST), and use ceiling(x) to find the least key greater than or equal to the given x. So left = bst.ceiling(right-k).
//If we found a valid left, then we update the answer by ans = max(ans, right - left).
//Then we try all possible pairs of (r1, r2) of rows in the matrix, where 0 <= r1 <= r2 < m. Make an array of n integer, where arr[c] = sum(matrix[r1][c]...matrix[r2][c]), then solve that sub problem.
public class MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int maxSum = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++){
            int[] rowSum = new int[n];

            for(int row = i; row < m; row++){
                for(int c = 0; c < n; c++){
                    rowSum[c] += matrix[row][c];
                }
                maxSum = Math.max(maxSum, maxSumSubArray(rowSum, k));
            }
        }

        return maxSum;
    }

    private int maxSumSubArray(int[] nums, int k){

        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        int maxSum = Integer.MIN_VALUE;
        int right = 0; //PrefixSum
        for(int i = 0; i < nums.length; i++){

            right += nums[i];
            Integer left = bst.ceiling(right - k);//This is tricky // right - left <= k -> left >= right - k
            if(left != null){
                maxSum = Math.max(maxSum, right - left);
            }

            bst.add(right);
        }

        return maxSum;
    }

    int maxSumSubArray(int[] arr, int n, int k) { // O(N * logN)
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        int ans = Integer.MIN_VALUE;
        for (int i = 0, right = 0; i < n; ++i) {
            right += arr[i];
            //We need bigger number so right - left cam be less that k
            //in base case right - left could be k
            Integer left = bst.ceiling(right - k); // right - left <= k -> left >= right - k
            if (left != null) {
                ans = Math.max(ans, right - left);
            }
            bst.add(right);
        }
        return ans;
    }
}
