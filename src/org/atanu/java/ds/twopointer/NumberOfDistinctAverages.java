package org.atanu.java.ds.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-distinct-averages/description/
//Leetcode 2465
public class NumberOfDistinctAverages {

    public int distinctAverages(int[] nums) {
        //Sort the array
        Arrays.sort(nums);

        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;
        Set<Integer> set = new HashSet<>();
        //Use Two pointer
        //Actualy we no need to do average
        for(int i = 0; i < n / 2; i++){
            int sum = nums[i] + nums[n - i - 1];
            set.add(sum);
        }

        return set.size();
    }


    public int distinctAverages_v2(int[] nums) {
        //Sort the array
        Arrays.sort(nums);

        int low = 0;
        int high = nums.length - 1;
        Set<Double> set = new HashSet<>();
        //Use Two pointer
        //Actualy we no need to do average , as the average of unique sum would be same only
        //just mark the unique sum
        while(low < high){
            double average = (nums[low++] + nums[high--]) / 2.0;
            set.add(average);
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[] nums = {4,1,4,0,3,5};
        int distinctAverage = new NumberOfDistinctAverages().distinctAverages(nums);
        System.out.println("distinctAverage "+distinctAverage);
        //Explanation:
        //1. Remove 0 and 5, and the average is (0 + 5) / 2 = 2.5. Now, nums = [4,1,4,3].
        //2. Remove 1 and 4. The average is (1 + 4) / 2 = 2.5, and nums = [4,3].
        //3. Remove 3 and 4, and the average is (3 + 4) / 2 = 3.5.
        //Since there are 2 distinct numbers among 2.5, 2.5, and 3.5, we return 2.
    }
}
