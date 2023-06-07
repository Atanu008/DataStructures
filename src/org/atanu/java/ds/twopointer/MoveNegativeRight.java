package org.atanu.java.ds.twopointer;

import java.util.Arrays;

public class MoveNegativeRight {

     // 2 -1 4 -3 5 -8
    //

    public static void main(String[] args) {
        MoveNegativeRight moveNegativeRight = new MoveNegativeRight();
        int[] nums = {2, -1, 4, -3, 5, -8};
        moveNegativeRight.movePositiveRight(nums);
    }
    public void movePositiveRight(int[] nums){

        int pivot = 0;
        int index = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > pivot){
                swap(nums, i, index);
                index++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int a, int b) {

        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
