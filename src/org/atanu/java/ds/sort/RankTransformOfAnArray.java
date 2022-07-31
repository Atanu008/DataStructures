package org.atanu.java.ds.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/rank-transform-of-an-array/
//LeetCode 1331
public class RankTransformOfAnArray {

    //Copy arr into A and sort it.
    //Iterate sorted array A and record the rank for each element in hashmap rank.
    //Iterate arr again, and assign rank[arr[i]] to A[i].
    //return the final result A.
    public int[] arrayRankTransform(int[] arr) {

        int[] copy = Arrays.copyOf(arr, arr.length);
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(copy);

        for(int a : copy){
            map.putIfAbsent(a , map.size() + 1);
        }

        for(int i = 0; i < arr.length; i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}
