package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/
//LeetCode 1299
public class ReplaceElementswithGreatestElementOnRightSide {

    public int[] replaceElements(int[] arr) {

        int n = arr.length;
        int max = -1;

        for(int i = arr.length -1; i >= 0; i--){
            int currentValue = arr[i]; // This the trick I was missing . need to preserve the old value before updating . as the old value would be needed to calculate the max .
            arr[i] = max;
            max = Math.max(max, currentValue);

        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        ReplaceElementswithGreatestElementOnRightSide replaceElementswithGreatestElementOnRightSide = new ReplaceElementswithGreatestElementOnRightSide();
        replaceElementswithGreatestElementOnRightSide.replaceElements(arr);
        System.out.println(Arrays.toString(arr));
    }
}
