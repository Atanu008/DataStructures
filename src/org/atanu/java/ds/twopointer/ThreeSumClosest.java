package org.atanu.java.ds.twopointer;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {


            int low = i + 1;
            int high = nums.length - 1;

            while (low < high) {

                //sum of Three element
                int sum = nums[i] + nums[low] + nums[high];

                // Check difference
                int diff = Math.abs(target - sum);

                // return if the difference i.e the target is found
                if (diff == 0)
                    return sum;

                //If the difference is smaller than the minimum update the minimum
                if (diff < min) {
                    min = diff;
                    result = sum;
                }

                //Move the pointers. forward low if sum is less that target.
                if (sum < target) {
                    low++;
                } else //Decrement the high if sum is greater that target.
                {
                    high--;
                }
            }

        }


        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int[] S = {-1, 2, 1, -4, 3, 4, 9};
        int target = 19;
        int result = threeSumClosest.threeSumClosest(S, target);

        System.out.println("Closest of " + target + " is " + result);


    }

}
