package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/circular-array-loop/
// LeetCode 457
// Video Explanation: https://www.youtube.com/watch?v=2hVinjU-5SA
// https://www.educative.io/courses/grokking-the-coding-interview/NE67J9YMj3m

//Slow and Fast Pointer

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {

        for(int i = 0; i < nums.length; i++){

            //As we will only be checking cycle in one direction .
            //Either Forward
            boolean isForward = nums[i] >= 0;
            int slow = i;
            int fast = i;
            do {
                // move one step for slow pointer
                slow = getNextIndex(nums, slow, isForward);
                //Break is slow is not valid
                if(slow == -1){
                    break;
                }

                // move one step for fast pointer
                fast = getNextIndex(nums, fast, isForward);
                if(fast == -1){
                    break; //Break is fast is not valid
                }
                // move another step for fast pointer
                fast = getNextIndex(nums, fast, isForward);

            }while(slow != -1 && fast != -1 && slow != fast);

            if(slow != -1 && fast != -1 && slow == fast){
                return true;
            }

        }

        return false;
    }

    private int getNextIndex(int[] nums, int index, boolean isForward) {

        boolean direction = nums[index] >= 0;
        // change in direction, return -1
        if(direction != isForward){
            return -1;
        }

        int nextIndex = (index + nums[index]) % nums.length;

        // wrap around for negative numbers
        if(nextIndex < 0){
            nextIndex = nextIndex + nums.length;
        }

        // Same element cycle, return -1
        if(index == nextIndex) {
            return -1;
        }

        return nextIndex;
    }
}
