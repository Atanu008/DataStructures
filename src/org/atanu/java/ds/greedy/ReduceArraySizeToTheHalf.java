package org.atanu.java.ds.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/reduce-array-size-to-the-half/description/
//LeetCode 1338
public class ReduceArraySizeToTheHalf {
    //Choose Greedily
    //We need to choose smallest set of numbers such that deleting all occurences of those numberswill be reduce the array size by half.
    //It should be obvious that the number having the maximum frequency should be deleted first
    //so that size of set of numbers is minimized.

    //For this, we can use hashmap to find frequency of each number,
    //then sort the frequencies using multiset in descending order
    //and keep adding numbers to our set till atleast n / 2 numbers are deleted.
    public int minSetSize(int[] arr) {

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : arr){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            maxHeap.offer(entry.getValue());
        }

        int count = 0;
        int size = 0;

        while(!maxHeap.isEmpty()){
            size += maxHeap.poll();
            count++;
            if(size >= arr.length / 2){
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,5,5,5,2,2,7};
        ReduceArraySizeToTheHalf reduceArraySizeToTheHalf = new ReduceArraySizeToTheHalf();
        int minSetSize = reduceArraySizeToTheHalf.minSetSize(arr);
        System.out.println("Minimum Set Size "+ minSetSize);
    }
}
