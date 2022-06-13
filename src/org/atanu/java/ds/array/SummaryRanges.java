package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/summary-ranges/
//LeetCode 228
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {

        List<String> summaryRanges = new ArrayList<>();

        int i = 0;
        while(i < nums.length){
            int start = nums[i];
            while(i < nums.length -1 && nums[i] + 1 == nums[i+1]){
                i++;
            }

            String range = "";
            if(start != nums[i]){
                range += start+"->"+nums[i];
            }
            else{
                range += nums[i];
            }
            summaryRanges.add(range);

            i++; //Increment i, basically fix the start point again
        }

        return summaryRanges;
    }

    public static void main(String[] args) {

        SummaryRanges summaryRanges = new SummaryRanges();
        int[] nums = {0,1,2,4,5,7};
        List<String> ranges = summaryRanges.summaryRanges(nums);
        System.out.println(ranges);
    }
}
