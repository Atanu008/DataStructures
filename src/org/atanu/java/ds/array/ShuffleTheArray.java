package org.atanu.java.ds.array;

// https://leetcode.com/problems/shuffle-the-array/description/
// Leetcode 1470

import java.util.Arrays;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {

        int result[] = new int[n*2];

        int index = 0;
        for(int i = 0; i < n; i++){
            result[index++] = nums[i];
            result[index++] = nums[n + i];
        }

        return result;
    }

    // Same algo just different implementation
    public int[] shuffle_v2(int[] nums, int n) {

        int[] res = new int[2*n];
        for(int i = 0; i < n; i++){
            res[2 * i] = nums[i];
            res[2 * i + 1] = nums[n+i];
        }
        return res;
    }

    public static void main(String[] args) {
        ShuffleTheArray shuffleTheArray = new ShuffleTheArray();
        int[] nums = {2,5,1,3,4,7};
        int n = 3;
        System.out.println(Arrays.toString(shuffleTheArray.shuffle(nums, n)));
        System.out.println(Arrays.toString(shuffleTheArray.shuffle_v2(nums, n)));
    }
}
