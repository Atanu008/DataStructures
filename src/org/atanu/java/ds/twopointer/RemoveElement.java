package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/remove-element/
//LeetCode 27
public class RemoveElement {

    public int removeElement(int[] nums, int key) {
        //we will store other elements in the ith Index
        int index = 0;

        for (int j = 0; j < nums.length; j++) {

            //forward if the element is not equal to Key
            if (nums[j] != key) {
                nums[index] = nums[j];
                index++;
            }
        }
        return index;
    }

    public int removeElement_v2(int[] nums, int key) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == key) {
                // MOve the Nth element to Ith element if the key matches
                nums[i] = nums[n - 1];
                n--;
            }
            //Otherwise forward i
            else {
                i++;
            }

        }
        return i;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 3, 4, 7, 3, 2, 1, 5, 6, 1};

        //System.out.println(removeElementSol1(arr,2));

        System.out.println(new RemoveElement().removeElement(arr, 2));
    }

}
