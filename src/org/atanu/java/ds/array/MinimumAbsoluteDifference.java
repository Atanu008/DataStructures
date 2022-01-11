package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/minimum-absolute-difference/
//LeetCode 1200
public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);
        Integer minDifference = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length -1; i++){
            minDifference = Math.min(minDifference, arr[i+1] - arr[i]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < arr.length -1; i++){
            if(arr[i] + minDifference == arr[i+1]){
                result.add(Arrays.asList(arr[i], arr[i+1]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
        int[] arr = {4,2,1,3};
        List<List<Integer>> result = minimumAbsoluteDifference.minimumAbsDifference(arr);
        result.forEach(System.out::println);
    }
}
