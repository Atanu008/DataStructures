package org.bgd.java.ds.heapandquickselect;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/description/">...</a>
 *
 * 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */

public class KMostFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(entry.getKey());
            if (heap.size() > k) {
                heap.poll();
            }
        }
        int[] r = new int[k];
        while (k > 0) {
            r[--k] = heap.poll();
        }
        return r;
    }
}
