package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/furthest-building-you-can-reach/
//LeetCode 1642
public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] A, int bricks, int ladders) {

        PriorityQueue<Integer> ladderAllocations = new PriorityQueue<>();
        for (int i = 0; i < A.length - 1; i++) {
            int difference = A[i + 1] - A[i];
            // If this is actually a "jump down", skip it.
            if(difference < 0){
                continue;
            }
            // Otherwise, allocate a ladder for this climb.
            ladderAllocations.offer(difference);
            //Choose Ladders First
            // If we haven't gone over the number of ladders, nothing else to do.
            if(ladderAllocations.size() <= ladders){
                continue;
            }

            //We have come here means that , there is No ladders
            //Check if we can replace any ladder with bricks
            //less jump should be done by brick. take the minumum jump that we did from ladder and assign it to bricks.
            bricks -= ladderAllocations.poll();

            if(bricks < 0){
                return i;
            }
        }
        return A.length - 1;
    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach furthestBuildingYouCanReach = new FurthestBuildingYouCanReach();
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5, ladders = 1;
        System.out.println("Furthest Building is "+ furthestBuildingYouCanReach.furthestBuilding(heights,bricks,ladders));
    }
}
