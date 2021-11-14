package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    //Time complexity : O(nlgn). // For Sorting. main loop does t in O(n)
    //Space complexity : O(1)O(1) (or O(n)O(n)).
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);

        int currentStreak = 1;
        int longestStreak = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                if (nums[i] == nums[i - 1] + 1) {
                    currentStreak += 1;
                } else {
                    currentStreak = 1;
                }
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }
        return longestStreak;

    }

    //Time complexity : O(n).
    //Space complexity : O(1)O(n)
    public int longestConsecutiveV2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int longestSteak = 0;

        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int currentSteak = 1;
            // This if will make sure that we will only check from smallest number
            if (!set.contains(currentNumber - 1)) {
                while (set.contains(currentNumber + 1)) {
                    currentNumber += 1;
                    currentSteak += 1;
                }
            }

            longestSteak = Math.max(longestSteak, currentSteak);
        }

        return longestSteak;
    }

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        int longestCommonSequence = new LongestConsecutiveSequence().longestConsecutive(nums);
        System.out.println("Longest Consecutive Sequence is "+ longestCommonSequence);

        longestCommonSequence = new LongestConsecutiveSequence().longestConsecutiveV2(nums);
        System.out.println("Longest Consecutive Sequence is "+ longestCommonSequence);
    }
}
