package org.atanu.java.ds.array;

//https://leetcode.com/problems/relative-sort-array/
//LeetCode 1122
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int[] count = new int[1001]; // can be replaced by Map

        for(int i: arr1){
            count[i]++;
        }
        // System.out.println(Arrays.toString(count));
        int k = 0;
        for(int i : arr2){
            while(count[i] > 0){
                result[k++] = i;
                count[i]--;
            }
        }

        //For loop is to maintain the relative order.
        //Otherwise for loop on arr1 would give the same order of arr1
        for(int i = 0; i < 1001 ;i++){
            while(count[i] > 0){
                result[k++] = i;
                count[i]--;
            }
        }

        return result;
    }

}
