package org.atanu.java.ds.bit;

//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/description/
//Leetcode 1356

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        //We need wrapper object as Arrays.sort with lambda only works with Object array
        Integer[] a = new Integer[arr.length];
        for(int i = 0; i < arr.length; i++){
            a[i] = arr[i];
        }

        Arrays.sort(a, (x, y) -> {
            int xBitCount = getBitCount(x);
            int yBitCount = getBitCount(y);
            if(xBitCount == yBitCount){
                return x - y; //If bit Count is same return the small element
            }
            else{
                return xBitCount - yBitCount; // return whose count is small
            }
        });

        for(int i = 0; i < arr.length; i++){
            arr[i] = a[i];
        }

        return arr;
    }

    private int getBitCount(int num){
        int count = 0;
        while(num != 0){
            if(num % 2 != 0){
                count++;
            }
            num >>= 1;
        }
        return count;
    }
}
