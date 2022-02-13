package org.atanu.java.ds.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
//LeetCode 1481
public class LeastNumberOfUniqueIntegersAfterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap();
        for(int a : arr){
            frequencyMap.put(a, frequencyMap.getOrDefault(a,0)+1);
        }
        // Create Min Heap. less fruquent element will be top of Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue((a, b)->frequencyMap.get(a)-frequencyMap.get(b));
        //Plcae all Keys/distinct in Heap
        minHeap.addAll(frequencyMap.keySet());

        while(k > 0 && !minHeap.isEmpty()) {
            k -= frequencyMap.get(minHeap.poll());
        }

        //If K is negative that means we removed one element that has more than one occurance
        //In that case we may want to delete few elements and keep few
        // So we need to return minHeap.size() + 1 . i.e keeping the item in heap
        //Otherwise k == 0 , return minHeap.size()
        return k < 0 ? minHeap.size() + 1 : minHeap.size();
    }
}
