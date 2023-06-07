package org.atanu.java.ds.twopointer;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/duplicate-zeros/description/
// Leetcode 1089
public class DuplicateZeros {

    // Most Intutive
    // However require more space
    public void duplicateZeros_v3(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                queue.offer(0);
                queue.offer(0);
            }else{
                queue.offer(nums[i]);
            }
            nums[i] = queue.poll();
        }
    }

    public void duplicateZeros(int[] a) {

        int[] copy = a.clone();
        int i = 0;
        int j = 0;

        while(i < a.length){
            a[i] = copy[j];
            i++;
            if(copy[j] == 0){
                if(i < a.length){
                    a[i] = copy[j];//copy twice if zero
                }
                i++;
            }
            j++;
        }
    }

    //SC - O(1)
    // Dont try this at home :)
    public void duplicateZeros_v2(int[] arr) {
        int zeroCount = 0;
        for(int a : arr){
            zeroCount += a == 0 ? 1 : 0;
        }
        int oldLength = arr.length;
        int newLength = oldLength + zeroCount; //as we need to duplicate as many number of zeros;

        int i = newLength - 1; // we will start from the new end to fill up
        int j = oldLength - 1; // This pointer will always point to old length array

        while(i >= 0){
            if(i < oldLength){
                arr[i] = arr[j];
            }
            i--; // move i towards left
            if(arr[j] == 0){//Copy twice if arr[i] == 0
                if(i < oldLength){
                    arr[i] = arr[j];
                }
                i--; // decrement i as we are duplicating
            }
            j--; //move the length from actual length
        }
    }
}
