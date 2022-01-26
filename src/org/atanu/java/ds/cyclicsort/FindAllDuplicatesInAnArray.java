package org.atanu.java.ds.cyclicsort;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-duplicates-in-an-array/
//LeetCode 442
public class FindAllDuplicatesInAnArray {

    //we will place each number at its correct index. After that,
    //we will iterate through the array to find all numbers that are not at the correct indices.
    //All these numbers are duplicates.
    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while(i < nums.length){

            int j = nums[i] -1;
            if(nums[i] != nums[j]){
                swap(nums, i, j);
            }
            else{
                i++;
            }
        }

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                result.add(nums[j]);
            }
        }

        return result;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //Iterate over the array and for every element x in the array, negate the value at index abs(x)-1
    //When we found a element negative then we know it
    //https://www.youtube.com/watch?v=wE0fYtbA8iw
    public List<Integer> findDuplicatesV2(int[] nums) {

        List<Integer> resultIndices = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){

            int indexValue = Math.abs(nums[i]);
            int indexToMakeNegative = indexValue - 1;

            if(nums[indexToMakeNegative] < 0){
                resultIndices.add(indexValue);
            }
            else{
                nums[indexToMakeNegative] = -nums[indexToMakeNegative];
            }
        }

        return resultIndices;
    }

    //Brute Force
    public List<Integer> findDuplicatesV3(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    ans.add(nums[i]);
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray findAllDuplicatesInAnArray = new FindAllDuplicatesInAnArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        //Output: [2,3]
        List<Integer> result;
        result = findAllDuplicatesInAnArray.findDuplicates(nums);
        System.out.println(result);
        result = findAllDuplicatesInAnArray.findDuplicatesV2(nums);
        System.out.println(result);
        nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1}; //Reassigning again as it was modified by findDuplicatesV2
        result = findAllDuplicatesInAnArray.findDuplicatesV3(nums);
        System.out.println(result);

    }
}
