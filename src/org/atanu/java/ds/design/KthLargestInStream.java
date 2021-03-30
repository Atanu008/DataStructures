package org.atanu.java.ds.design;

import java.util.PriorityQueue;

//Leetcode 703
//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestInStream {
    PriorityQueue<Integer> pq;
    int size;
    public KthLargestInStream(int k, int[] nums) {
        size = k;
        pq = new PriorityQueue(size);
        for(int a : nums) {
            pq.offer(a);
            if(pq.size() > size) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > size){
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 8, 2};
        KthLargestInStream kthLargest = new KthLargestInStream(3,nums);
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }

}
