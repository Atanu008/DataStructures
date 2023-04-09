package org.atanu.java.ds.hash;

// https://leetcode.com/problems/optimal-partition-of-string/description/
// Leetcode 2405
// Video : https://www.youtube.com/watch?v=CKZPdiXiQf0
import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionOfString {
    public int partitionString(String s) {

        // Initialize to 1
        // For "aaaa" like case we will have answer 1 and partitionCount wont be incremented in loop
        // Also for the last character it wont consider that so lets make it 1

        int partitionCount = 1;
        Set<Character> set = new HashSet<>();

        for(char ch : s.toCharArray()){
            // When we found the repeating substring we need to start a new substring
            // Increment the substring Count
            if(set.contains(ch)){
                partitionCount++;
                set.clear();
            }
            set.add(ch); // Add to set
        }
        return partitionCount;
    }
}
