package org.atanu.java.ds.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/partition-labels/
//LeetCode 763
//Video Idea : https://www.youtube.com/watch?v=B7m8UmZE-vw&t=608s
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> lastOccuranceMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            lastOccuranceMap.put(s.charAt(i), i);
        }

        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            right = Math.max(right, lastOccuranceMap.get(ch));
            //This the main trick
            //This means we have one complete window where the  character belongs to thsi window
            // any char in this window will not be in any next window
            // As we always checked last occurance
            if(i == right){
                result.add(right - left + 1);
                left = right + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels(s));
    }
}
