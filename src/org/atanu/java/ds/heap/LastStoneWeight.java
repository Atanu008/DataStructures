package org.atanu.java.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/last-stone-weight/
//LeetCode 1046
public class LastStoneWeight {

    //heap = a new Max-Heap
    //    add all stones to heap
    //    while heap contains more than 1 stone:
    //        heavy_stone_1 = remove max from heap
    //        heavy_stone_2 = remove max from heap
    //        if heavy_stone_1 is heavier than heavy_stone_2:
    //            new_stone = heavy_stone_1 - heavy_stone_2
    //            add new_stone to heap
    //    if heap is empty:
    //        return 0
    //    return last stone on heap
    public int lastStoneWeight(int[] stones) {

        // Insert all the stones into a Max-Heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }

        // While there is more than one stone left, we need to remove the two largest
        // and smash them together. If there is a resulting stone, we need to put into
        // the heap.
        while(!pq.isEmpty() && pq.size() > 1){
            int stoneX = pq.poll();
            int stoneY = pq.poll();

            if(stoneX != stoneY){
                pq.offer(stoneX - stoneY);
            }
        }

        // Check whether or not there is a stone left to return.
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int[] stones = {2,7,4,1,8,1};
        //Output: 1
        //Explanation:
        //We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        //we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        //we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        //we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
        int lastWeight = lastStoneWeight.lastStoneWeight(stones);
        System.out.println("Last Stone Weight is "+ lastWeight);
    }
}
