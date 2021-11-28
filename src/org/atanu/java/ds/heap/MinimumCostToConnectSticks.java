package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/minimum-cost-to-connect-sticks/
//LeetCode 1167
public class MinimumCostToConnectSticks {

    public int connectSticks(int[] sticks) {

        // add all sticks to the min heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a : sticks){
            pq.offer(a);
        }

        int totalConnectCost = 0;

        // combine two of the smallest sticks until we are left with just one.
        while(!pq.isEmpty() && pq.size() > 1){

            int stickA = pq.poll();
            int stickB = pq.poll();

            int costCombinijngAandB = stickA + stickB;
            pq.offer(costCombinijngAandB);

            totalConnectCost += costCombinijngAandB;
        }

        return totalConnectCost;
    }

    public static void main(String[] args) {
        MinimumCostToConnectSticks minimumCostToConnectSticks = new MinimumCostToConnectSticks();
        int[] sticks ={1,8,3,5};
        //Output: 30
        //Explanation: You start with sticks = [1,8,3,5].
        //1. Combine sticks 1 and 3 for a cost of 1 + 3 = 4. Now you have sticks = [4,8,5].
        //2. Combine sticks 4 and 5 for a cost of 4 + 5 = 9. Now you have sticks = [9,8].
        //3. Combine sticks 9 and 8 for a cost of 9 + 8 = 17. Now you have sticks = [17].
        //There is only one stick left, so you are done. The total cost is 4 + 9 + 17 = 30.
        System.out.println("Minumum Cost to combine sticks is "+ minimumCostToConnectSticks.connectSticks(sticks));

        sticks = new int[]{2, 4, 3};
        //Output: 14
        //Explanation: You start with sticks = [2,4,3].
        //1. Combine sticks 2 and 3 for a cost of 2 + 3 = 5. Now you have sticks = [5,4].
        //2. Combine sticks 5 and 4 for a cost of 5 + 4 = 9. Now you have sticks = [9].
        //There is only one stick left, so you are done. The total cost is 5 + 9 = 14.
        System.out.println("Minumum Cost to combine sticks is "+ minimumCostToConnectSticks.connectSticks(sticks));
    }
}
