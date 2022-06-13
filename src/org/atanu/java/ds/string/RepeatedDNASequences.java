package org.atanu.java.ds.string;

import java.util.*;

//https://leetcode.com/problems/repeated-dna-sequences/
//LeetCode 187
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {

        Map<String, Integer> dnaSeqMap = new HashMap<>();
        List<String> repeated = new ArrayList<>();

        for(int i = 0; i +10 <= s.length(); i++){
            String dnaSeq = s.substring(i, i+10);
            dnaSeqMap.put(dnaSeq, dnaSeqMap.getOrDefault(dnaSeq, 0) +1);
            if(dnaSeqMap.get(dnaSeq) == 2){
                repeated.add(dnaSeq);
            }
        }

        return repeated;
    }

    //Same but with Set
    public List<String> findRepeatedDnaSequencesV2(String s) {

        Set<String> seen = new HashSet<>();

        //If one string repeats more than twice,
        // then the arraylist will contain duplicates. So, a hashset is needed to avoid duplicates.
        Set<String> repeated = new HashSet<>();

        for(int i = 0; i +10 <= s.length(); i++){
            String dnaSeq = s.substring(i, i+10);
            if(seen.contains(dnaSeq)){
                repeated.add(dnaSeq);
            }

            seen.add(dnaSeq);
        }

        return new ArrayList<>(repeated);
    }
}
