package org.atanu.java.ds.heap;

import java.util.*;

//https://leetcode.com/problems/top-k-frequent-words/
//LeetCode 692
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        List<String> retList = new ArrayList<String>();

        // Put the Frequency in the Map
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i] , 0) + 1);
        }

        // Define a Heap where last item would have the most frequent element.
        // If the frequency is same then the low alphabetically order would be last
        PriorityQueue<Map.Entry<String, Integer>> pQueue = new PriorityQueue<>(new CustomComparator());

        //Adding items to the Heap
        for(Map.Entry<String, Integer> entry : map.entrySet()){

            pQueue.offer(entry);

            //Remove from Heap if the heap Size Greater
            if(pQueue.size() > k){
                pQueue.poll();
            }
        }

        // Remove from the List and add it to the front of teh List
        while(!pQueue.isEmpty()){
            retList.add(0, pQueue.poll().getKey());
        }
        return retList;

    }
}

 class CustomComparator implements Comparator<Map.Entry<String, Integer>>{

    public int compare(Map.Entry<String, Integer> a , Map.Entry<String, Integer> b){

        if(a.getValue() == b.getValue()){
            return b.getKey().compareTo(a.getKey());
        }
        else{
            return a.getValue() - b.getValue();
        }
    }
}
