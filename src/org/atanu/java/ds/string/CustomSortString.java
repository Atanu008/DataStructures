package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/custom-sort-string/
//LeetCode 791
public class CustomSortString {

    public String customSortString(String order, String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for(char ch: s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(char ch: order.toCharArray()){
            int orderFreq = freqMap.get(ch) != null ? freqMap.get(ch): 0;
            while(orderFreq > 0){
                sb.append(ch);
                orderFreq--;
            }
            freqMap.remove(ch);
        }

        for(Map.Entry<Character, Integer> entry : freqMap.entrySet()){
            int orderFreq = entry.getValue();
            Character reaminigChar = entry.getKey();
            while(orderFreq > 0){
                sb.append(reaminigChar);
                orderFreq--;
            }
        }

        return new String(sb);
    }

    public String customSortStringV2(String S, String T) {
        int [] arr = new int [26];
        //count T characters
        for(char ch: T.toCharArray()){
            arr[ch-'a']++;
        }
        // append S  chars at the right order as many times as they appear in T
        StringBuilder sb = new StringBuilder();
        for(char ch: S.toCharArray()){
            while(arr[ch-'a']>0){
                sb.append(ch);
                arr[ch-'a']--;
            }
        }
        //append the rest of the T characters
        for(int i = 0; i<arr.length; i++){
            while(arr[i]>0){
                sb.append((char)(i+'a'));
                arr[i]--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String order = "cba", s = "abcd";

        String customSortedString = new CustomSortString().customSortString(order,s);
        System.out.println("Custom Sorted String "+ customSortedString);
        customSortedString = new CustomSortString().customSortStringV2(order,s);
        System.out.println("Custom Sorted String "+ customSortedString);

    }
}
