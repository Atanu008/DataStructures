package org.atanu.java.ds.array;

//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
//Leetcode 1752
public class CheckIfArrayIsSortedAndRotated {
    public boolean check(int[] nums) {
        // here we compare all the neighbouring elemnts and check whether they are in somewhat sorted
        // there will be a small change due to rotation in the array at only one place.
        // so if there are irregularities more than once, return false
        // else return true;
        int irregularities = 0;
        int length = nums.length;
        for(int i = 0; i < length; i++){
            if(nums[i] > nums[(i+1) % length]){ // % length as to check the last element with first as rotated
                irregularities++;
            }
        }

        return irregularities <= 1;
    }

    public static void main(String[] args) {
        CheckIfArrayIsSortedAndRotated sortedAndRotated = new CheckIfArrayIsSortedAndRotated();
        int[] nums = {3,4,5,1,2};
        //Output: true
        //Explanation: [1,2,3,4,5] is the original sorted array.
        //You can rotate the array by x = 3 positions to begin on the the element of value 3: [3,4,5,1,2].
        System.out.println(sortedAndRotated.check(nums));

        nums = new int[]{2,1,3,4};
        //Output: false
        //Explanation: There is no sorted array once rotated that can make nums.
        System.out.println(sortedAndRotated.check(nums));

    }
}
