package org.atanu.java.ds.greedy;

//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
//LeetCode 659

// This is a greedy approach. The whole idea is to first look for an existing group
// to join for the current num. If no, then create a new group.
// Here a group means group of 3 or more numbers as mentioned in question description.

import java.util.HashMap;
import java.util.Map;

//Well, If u didn't understand, keep the above story of company in mind and try to understand the code below through comments, you will be fine.
public class SplitArrayintoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        // This hashmap tells us about whether a number in num is available for a job or not
        Map<Integer, Integer> availabilityMap = new HashMap<>();

        // This hashmap tells a number (say x), if there is a job vacancy for them
        Map<Integer, Integer> wantSubSequenceMap = new HashMap<>();

        // We store the count of every num in nums into avaibilityMap. Basically, a number's count is the avaibility of it.
        for(int a : nums){
            availabilityMap.put(a, availabilityMap.getOrDefault(a,0) + 1);
        }

        // We iterate through each number in the nums array. Remember the story ? So, treat them like a person.
        for(int num : nums){
            // First we check if our current num/person is available. If it is not we just continue with next num/person
            if(availabilityMap.getOrDefault(num,0) <= 0){
                continue;
            }

            // If the person is available, first we check if there is a job vacancy for him/her. Basically, is someone looking for him/her?
            else if(wantSubSequenceMap.getOrDefault(num,0) > 0){
                // Yes, someone is looking, so we decrease the avaibility count of that number
                availabilityMap.put(num, availabilityMap.getOrDefault(num, 0) -1);
                // we also decrease its count from the job vacancy space / wantMap
                wantSubSequenceMap.put(num, wantSubSequenceMap.getOrDefault(num, 0) -1);
                // Then as a goodwill, he/she will also create a job vacancy for (num[i]+1) in job vacancy space / wantMap, as we need consecutive numbers only
                wantSubSequenceMap.put(num+1, wantSubSequenceMap.getOrDefault(num+1,0) + 1);
            }

            // Ooh, we are here means nums[i] was not able to find a job.
            // so, nums[i] tries to start his/her own company by checking avaibility of his/her friends i.e. (nums[i]+1) and (nums[i]+2)
            else if(availabilityMap.getOrDefault(num,0) > 0 && availabilityMap.getOrDefault(num+1,0) > 0 && availabilityMap.getOrDefault(num+2,0) > 0){

                // Yay! both 2 friends are available. Let's start a company.
                // So we decrease the avaibility count of nums[i], (nums[i]+1) and (nums[i]+2) from the
                // avaibilityMap
                availabilityMap.put(num, availabilityMap.getOrDefault(num, 0) -1);
                availabilityMap.put(num+1, availabilityMap.getOrDefault(num+1, 0) -1);
                availabilityMap.put(num+2, availabilityMap.getOrDefault(num+2, 0) -1);

                // Also, as a goodwill, we create a new job vacancy for (nums[i]+3), as we need consecutive numbers only
                wantSubSequenceMap.put(num+3, wantSubSequenceMap.getOrDefault(num+3,0) + 1);
            }

            // Bad luck case, nums[i] not able to start his/her company, so just return false
            else {
                return false;
            }
        }

        // All good till here so we return true
        return true;
    }

    public static void main(String[] args) {
        SplitArrayintoConsecutiveSubsequences subsequences = new SplitArrayintoConsecutiveSubsequences();
        int[] nums = {1,2,3,3,4,5};
        boolean res = subsequences.isPossible(nums);
        System.out.println(res);
    }
}
