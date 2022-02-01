package org.atanu.java.ds.cyclicsort;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/set-mismatch/
//LeetCode 645
//https://www.educative.io/courses/grokking-the-coding-interview/3wEkKy6Pr9A : One solution
public class SetMismatch {

    //we will place each number at its correct index. Once we are done with the cyclic sort,
    //we will iterate through the array to find the number that is not at the correct index.
    //Since only one number got corrupted,
    //the number at the wrong index is the duplicated number and the index itself represents the missing number.
    public int[] findErrorNums(int[] nums) {

        int i = 0;
        while(i < nums.length) {

            int j = nums[i] -1;
            if(nums[i] != nums[j]){
                swap(nums, i, j);
            }
            else {
                i++;
            }
        }

        for(int k = 0; k < nums.length; k++){
            if(nums[k] != k+1){
                return new int[]{nums[k], k+1};
            }
        }
        return null;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //By Negating
    public int[] findErrorNumsV2(int[] nums) {

        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i++){

            int indexValue = Math.abs(nums[i]);
            int indexToMakeNegative = indexValue - 1;

            if(nums[indexToMakeNegative] < 0){
                ans[0] = indexValue;
            }
            else{
                nums[indexToMakeNegative] = -nums[indexToMakeNegative];
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                ans[1] = i+1;
            }
        }

        return ans;
    }

    //Useing extra space(Set) to record
    public int[] findErrorNumsV3(int[] nums) {

        int[] ans = new int[2];
        Set<Integer> set = new HashSet<>();
        //Record teh duplicate Number
        for(int a : nums){
            if(set.contains(a)){
                ans[0] = a;
            }
            else {
                set.add(a);
            }
        }

        //Traverse 1 To N. to record the missing number
        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i)){
                ans[1] = i;
                break;
            }
        }

        return ans;
    }
}
