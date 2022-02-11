package org.atanu.java.ds.array;

//https://leetcode.com/problems/single-number-iii/
//LeetCode 260
public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {

        int res = 0;

        // Find XOR of
        // all numbers
        for (int i = 0; i < nums.length; i++) {

            res = res ^ nums[i];
        }

        // Find a set bit in the
        // XOR (We find rightmost
        // set bit here)
        int setBit = res & (~res + 1); //https://www.youtube.com/watch?v=XcSr6TIMl7w


        // Traverse through all
        // numbers and divide them
        // in two groups (i) Having
        // set bit set at same position
        // as the only set bit in
        // set_bit (ii) Having 0 bit at
        // same position as the only
        // set bit in set_bit
        int num1 = 0, num2 = 0;

        for (int i = 0; i < nums.length; i++) {

            if ((nums[i] & setBit) != 0) {
                num1 = num1 ^ nums[i];
            } else {
                num2 = num2 ^ nums[i];
            }

        }
        return new int[]{num1, num2};
    }
}
