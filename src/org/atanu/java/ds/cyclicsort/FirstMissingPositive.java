package org.atanu.java.ds.cyclicsort;

import java.util.HashSet;

//https://leetcode.com/problems/first-missing-positive/
//LeetCode 41
//Video : https://www.youtube.com/watch?v=Whhpvk2k5qk&t=657s
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(num > 0)
                set.add(num);
        }

        for(int i = 1; i <= nums.length; i++){
            if(!set.contains(i))
                return i;
        }
        return nums.length + 1;
    }

    public int firstMissingPositiveV2(int[] nums) {
        int n = nums.length;
        //Put each number in its right place
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] -1] != nums[i]){
                //Swap numbers if the number is not in its correct position
                int temp = nums[nums[i] -1];
                nums[nums[i] -1] = nums[i];
                nums[i] = temp;
            }
        }

        //At last, the first place where its number is not right, return the place + 1.
        for(int i = 0; i < n; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }

        return n+1;
    }
    //1- Ignore all numbers <=0 and >n since they are outside the range of possible answers
    // (which we proved was [1..n]). We do this by replacing them with the value n+1.
//2- For all other integers <n+1, mark their bucket (cell) to indicate the integer exists. (*see below)
//3- Find the first cell not marked, that is the first missing integer. If you did not find an unmarked cell, there was no missing integer, so return n+1.

    public int firstMissingPositiveV3(int[] nums) {
        int n = nums.length;
        for(int i=0; i <n; i++){
            if(nums[i] <= 0 || nums[i] > n){
                nums[i] = n+1;
            }
        }

        for(int i = 0; i < n; i++){
            int currentIndex = Math.abs(nums[i]);
            //If currentIndex > n , No need to consider as it will be out of Array Index
            if(currentIndex > n){
                continue;
            }
            if(nums[currentIndex - 1] > 0){
                nums[currentIndex - 1] *=-1;
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i] >= 0){
                return i+1;
            }
        }

        return n+1;

    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        System.out.println("First Missing Positive is "+ firstMissingPositive.firstMissingPositive(nums));
        System.out.println("First Missing Positive is "+ firstMissingPositive.firstMissingPositiveV2(nums));
        System.out.println("First Missing Positive is "+ firstMissingPositive.firstMissingPositiveV3(nums));
    }
}
