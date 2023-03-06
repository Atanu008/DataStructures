package org.atanu.java.ds.greedy;

//https://leetcode.com/problems/find-original-array-from-doubled-array/description/
//Leetcode 2007

//Explanation : https://leetcode.com/problems/find-original-array-from-doubled-array/editorial/

//Algorithm
//
//Return empty array {} if the size of the given array changed is odd.
//Sort the array changed in increasing order.
//Store the element count in the HashMap freq. Iterate over the elements in the array changed and increment the count corresponding to the element in the map.
//Iterate over the elements in the array changed, for each element num:
//Check if the count of num in the map freq is more than zero or not.
//Decrement the frequency of num in the map.
//Check if the count of twiceNum (2 * num) in the map freq is positive or not. If it is then decrement the count and add the element num to the answer array original.
//If it is not, then return an empty {} array.
//Return the array original.

// Why Sorting ??
//If X is the smallest element in the array then element X/2 will not exist in the array,
//hence we will have to check for element 2X. Similarly,
//if X is the greatest element in the array then element 2X will not exist in the array
//hence we will have to check for X/2 only. Therefore, the trick is to go for the smallest
//or greatest element always because this way we will have only one option to go for.
//In the two approaches below we chose the smallest element always.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        // It can't be doubled array, if the size is odd
        if(n % 2 != 0){
            return new int[0];
        }
        //
        Arrays.sort(changed); // eg : [2,1] use case wont work

        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : changed){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] original = new int[n/2];
        int index = 0;

        for(int num : changed){
            if(freq.containsKey(num)){

                //Decrement Twice Num . Remove if zero occurance
                if(freq.get(num) == 1){
                    freq.remove(num);
                }else{
                    freq.put(num, freq.get(num) - 1);
                }
                int twiceNum = num * 2;
                if(freq.containsKey(twiceNum)){
                    //We can pair up num and twiceNum
                    //record the num in result. // Add the original number to answer
                    original[index++] = num;
                    //Decrement Twice Num . Remove if zero occurance
                    if(freq.get(twiceNum) == 1){
                        freq.remove(twiceNum);
                    }else{
                        freq.put(twiceNum, freq.get(twiceNum) - 1);
                    }
                }else{
                    //We can not pair up. return empty array
                    return new int[0];
                }
            }
        }
        return original;
    }
}
