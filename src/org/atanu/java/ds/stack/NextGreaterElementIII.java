package org.atanu.java.ds.stack;

//https://leetcode.com/problems/next-greater-element-iii/
//LeetCode 556
// Same as
//https://leetcode.com/problems/next-permutation/  //LeetCode 31
public class NextGreaterElementIII {

    public int nextGreaterElement(int n) {

        char[] nums = ("" + n).toCharArray();
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i < 0) {
            return -1;
        }

        int j = nums.length - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        swap(nums, i, j);

        // Arrange these elements in Ascending Element
        reverse(nums, i + 1, nums.length - 1);
        try {
            return Integer.parseInt(new String(nums));
        } catch (Exception e) {
            return -1;
        }

    }

    public void swap(char[] A, int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(char[] A, int i, int j) {
        while (i < j) swap(A, i++, j--);
    }
}
