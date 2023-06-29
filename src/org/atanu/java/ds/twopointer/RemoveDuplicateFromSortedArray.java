package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
//LeetCode 26
public class RemoveDuplicateFromSortedArray {

    //This Solution looks clean
    public int removeDuplicates(int[] nums) {
        int insertIndex = 1;
        for(int i = 1; i < nums.length; i++){
            // We skip to next index if we see a duplicate element
            if(nums[i - 1] != nums[i]) {
                /* Storing the unique element at insertIndex index and incrementing
                   the insertIndex by 1 */
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }

    //sane idea as above , but only implementation is different . Two Pointer
    public static int removeDuplicates_v2(int[] nums) {

        //Initialize Starting Pointer as j . nums[0] will always have the first element
        int i = 0;
        // Start from Index 1 and compare with previous . nums[0] already placed at the right position
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                // If the element is NOT equal to the previous element
                // Increment the pointer and place the item
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1; // +1 because i started with 0 and we are incrementing inside if
    }

    public static void main(String[] args) {

        int arr[] = {1, 2, 2, 3, 4, 4, 4, 5, 5};
        int n = arr.length;
        n = new RemoveDuplicateFromSortedArray().removeDuplicates(arr);

        //n = removeDuplicateFromSortedArraySol2(arr);

        System.out.println("Length after Deletion " + n);
        // Print updated array
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

    }

}
