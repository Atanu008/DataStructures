package org.atanu.java.ds.cyclicsort;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//LeetCode 448
//https://www.educative.io/courses/grokking-the-coding-interview/Y52qNM0ljWK
public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> resultIndices = new ArrayList<>();
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

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != j+1){
                resultIndices.add(j+1);
            }
        }
        return resultIndices;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray findAllNumbersDisappearedInAnArray = new FindAllNumbersDisappearedInAnArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = findAllNumbersDisappearedInAnArray.findDisappearedNumbers(nums);
        System.out.println(result);
    }
}
