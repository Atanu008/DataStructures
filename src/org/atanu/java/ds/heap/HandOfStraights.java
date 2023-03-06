package org.atanu.java.ds.heap;

//https://leetcode.com/problems/hand-of-straights/description/
//Leetcode 846

import java.util.PriorityQueue;
import java.util.TreeMap;

//Since the numbers need to consecutive we immediately can figure out
//the next W - 1 numbers that must occur after a given number.
//By using a priority queue we can poll the smallest number and remove the next W - 1 consecutive numbers.
//If any of the consecutive numbers are not in the priority queue,
//it implies the hand is invalid and thus returns false.
public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        //Base case. can not form group with groupSize
        if(hand.length % groupSize != 0){
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int h : hand){
            minHeap.offer(h);
        }

        while(!minHeap.isEmpty()){
            int first = minHeap.poll(); // Take the minimum from Heap
            for(int i = 1; i < groupSize; i++){
                int next = first + i; // Check for next consecutime elements
                //If the element is present we will be able to delete and form the group
                //otherwise return false;
                if(!minHeap.remove(next)){
                    return false;
                }
            }
        }
        return true;
    }

    //Used Tree
    public boolean isNStraightHand_v2(int[] hand, int groupSize) {
        //Base case. can not form group with groupSize
        if(hand.length % groupSize != 0){
            return false;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int h : hand){
            treeMap.put(h, treeMap.getOrDefault(h, 0) + 1);
        }

        while(!treeMap.isEmpty()){
            int first = treeMap.firstKey();
            for(int i = 1; i < groupSize; i++){
                int next = first + i;
                Integer nextOccuranceFreq = treeMap.get(next);
                if(nextOccuranceFreq == null){
                    return false;
                }else{
                    treeMap.put(next, treeMap.get(next) - 1);
                    if(treeMap.get(next) == 0){
                        treeMap.remove(next);
                    }
                }
            }
            treeMap.put(first, treeMap.get(first) - 1);
            if(treeMap.get(first) == 0){
                treeMap.remove(first);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        HandOfStraights handOfStraights = new HandOfStraights();
        int[] nums = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        System.out.println(handOfStraights.isNStraightHand(nums, groupSize));
        System.out.println(handOfStraights.isNStraightHand_v2(nums, groupSize));

        nums = new int[]{1,2,3,4,5};
        groupSize = 4;
        System.out.println(handOfStraights.isNStraightHand(nums, groupSize));
        System.out.println(handOfStraights.isNStraightHand_v2(nums, groupSize));
    }

}
