package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// LeetCode 80
// https://aaronice.gitbook.io/lintcode/two_pointers/remove-duplicates-from-sorted-array-ii

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);
    }

    public int removeDuplicates(int[] nums, int k) {

        int i = 0;
        // Include first K elements first
        // Then check if current element is NOT equal to i-k places.
        for(int a : nums){
            if(i < k || nums[i-k] != a){
                nums[i] = a;
                i++;
            }
        }

        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArrayII removeDuplicates = new RemoveDuplicatesfromSortedArrayII();
        int[] nums = {0,0,1,1,1,1,2,3,3};
        //Output: 7, nums = [0,0,1,1,2,3,3,_,_]
        //Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
        //It does not matter what you leave beyond the returned k (hence they are underscores).
        System.out.println(removeDuplicates.removeDuplicates(nums));
    }
}
