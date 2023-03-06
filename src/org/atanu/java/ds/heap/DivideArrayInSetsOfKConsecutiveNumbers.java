package org.atanu.java.ds.heap;

//https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/description/
//Leetcode 1296

//This is exactly same as https://leetcode.com/problems/hand-of-straights/description/
//Leetcode 846
import java.util.PriorityQueue;
import java.util.TreeMap;

//Since the numbers need to consecutive we immediately can figure out
//the next W - 1 numbers that must occur after a given number.
//By using a priority queue we can poll the smallest number and remove the next W - 1 consecutive numbers.
//If any of the consecutive numbers are not in the priority queue,
//it implies the hand is invalid and thus returns false.
public class DivideArrayInSetsOfKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        //Base case. can not form group with groupSize
        if(nums.length % k != 0){
            return false;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num : nums){
            minHeap.offer(num);
        }

        while(!minHeap.isEmpty()){
            int first = minHeap.poll();// Take the minimum from Heap
            for(int i = 1; i < k; i++){
                // Check for next consecutime elements
                int next = first + i;
                //If the element is present we will be able to delete and form the group
                //otherwise return false;
                if(!minHeap.remove(next)){
                    return false;
                }
            }
        }
        return true;
    }

    //TreeMap fo efficiency as remove of PriorityQueue is a linear operation
    public boolean isPossibleDivide_v2(int[] nums, int k) {
        //Base case. can not form group with groupSize
        if(nums.length % k != 0){
            return false;
        }

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for(int num : nums){
            treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
        }

        while(!treeMap.isEmpty()){
            int first = treeMap.firstKey();
            for(int i = 1; i < k; i++){
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
        DivideArrayInSetsOfKConsecutiveNumbers kConsecutiveNumbers = new DivideArrayInSetsOfKConsecutiveNumbers();
        int[] nums = {1,2,3,3,4,4,5,6};
        int k = 4;
        //Output: true
        //Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
        System.out.println(kConsecutiveNumbers.isPossibleDivide(nums, k));

        nums = new int[]{3,2,1,2,3,4,3,4,5,9,10,11};
        k = 3;
        //Output: true
        //Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
        System.out.println(kConsecutiveNumbers.isPossibleDivide(nums, k));
    }
}
