package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fruit-into-baskets/
//LeetCode 904
//same as below
//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
//LeetCode 159

//This problem follows the Sliding Window pattern and is quite similar to Longest Substring with K Distinct Characters.
//In this problem, we need to find the length of the longest subarray with no more than two distinct characters (or fruit types!).
//This transforms the current problem into Longest Substring with K Distinct Characters where K=2.
public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        // sliding window left and right pointers
        int windowStart = 0;
        int windowEnd = 0;
        int maxLength = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // try to extend the range [windowStart, windowEnd]
        while(windowEnd < fruits.length){

            int end = fruits[windowEnd];
            map.put(end , map.getOrDefault(end,0) +1);
            // shrink the sliding window, until we are left with '2' fruits in the frequency map
            while(map.size() > 2){
                int start = fruits[windowStart];
                map.put(start, map.get(start) -1);
                // delete the leftmost character
                if(map.get(start) == 0){
                    map.remove(start);
                }
                windowStart++; // shrink the window
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart +1);

            windowEnd++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        FruitIntoBaskets fruitIntoBaskets = new FruitIntoBaskets();
        int[] fruits = {1,2,3,2,2};
        //Output: 4
        //Explanation: We can pick from trees [2,3,2,2].
        //If we had started at the first tree, we would only pick from trees [1,2].
        System.out.println("Total Fruits "+ fruitIntoBaskets.totalFruit(fruits));

        fruits = new int[]{0,1,2,2};
        //Output: 3
        //Explanation: We can pick from trees [1,2,2].
        //If we had started at the first tree, we would only pick from trees [0,1].
        System.out.println("Total Fruits "+ fruitIntoBaskets.totalFruit(fruits));
    }
}
