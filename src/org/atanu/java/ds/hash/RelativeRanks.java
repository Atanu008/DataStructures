package org.atanu.java.ds.hash;

// https://leetcode.com/problems/relative-ranks/description/
// Leetcode 506

import java.util.*;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {

        String[] result = new String[score.length];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i = 0; i < score.length; i++){
            map.put(score[i], i);
        }

        int i = 1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            int key = entry.getKey();
            int value = entry.getValue();
            if(i == 1){
                result[value] = "Gold Medal";
            }else if(i == 2){
                result[value] = "Silver Medal";
            }else if(i == 3){
                result[value] = "Bronze Medal";
            }
            else{
                result[value] = ""+i;
            }
            i++;
        }

        return result;
    }

    public String[] findRelativeRanks_v2(int[] score) {

        String[] result = new String[score.length];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        for(int i = 0; i < score.length; i++){
            maxHeap.offer(i);
        }

        int i = 1;
        while(!maxHeap.isEmpty()){

            int index = maxHeap.poll();

            if(i == 1){
                result[index] = "Gold Medal";
            }else if(i == 2){
                result[index] = "Silver Medal";
            }else if(i == 3){
                result[index] = "Bronze Medal";
            }
            else{
                result[index] = ""+i;
            }
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        RelativeRanks relativeRanks = new RelativeRanks();
        int[] score = {5,4,3,2,1};
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks(score)));
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks_v2(score)));

        score = new int[]{10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks(score)));
        System.out.println(Arrays.toString(relativeRanks.findRelativeRanks_v2(score)));

    }
}
