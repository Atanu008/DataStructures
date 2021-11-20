package org.atanu.java.ds.heap;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/
//LeetCode 347
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        if(k == nums.length){
            return nums;
        }

        Map<Integer, Integer> map = new HashMap<>();
        //Min Heap ('the less frequent element first')
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        // 1. build hash map : character and how often it appears
        // O(N) time
        for(int a : nums){
            map.put(a, map.getOrDefault(a,0) + 1);
        }
        // Build Min Heap ('the less frequent element first')
        //keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        // 3. build an output array
        // O(k log k) time
        int[] topK = new int[k];
        for(int i = k -1; i >=0; i--){
            topK[i] = pq.poll().getKey();
        }

        return topK;
    }

    //Retun List . the only diffeeence
    public List<Integer> topKFrequentV2(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> retVal = new ArrayList<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pQueue = new PriorityQueue<>(
                (a,b) -> a.getValue() - b.getValue()
        );

        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            pQueue.offer(entry);

            if(pQueue.size() > k){
                pQueue.poll();
            }
        }

        while(!pQueue.isEmpty()){
            retVal.add(0,pQueue.poll().getKey());
        }

        return retVal;
    }
    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] result = topKFrequentElements.topKFrequent(nums,k);
        System.out.println(Arrays.toString(result));
        List<Integer> resultList = topKFrequentElements.topKFrequentV2(nums,k);
        System.out.println(resultList);
    }
}
