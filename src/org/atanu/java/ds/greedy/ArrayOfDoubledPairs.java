package org.atanu.java.ds.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/array-of-doubled-pairs/description/
//Leetcode 954

//Explanation : https://leetcode.com/problems/array-of-doubled-pairs/solutions/1396876/c-java-python-greedy-algorithm-clear-explanation-o-nlogn-clean-concise/

//Idea
//
//We greedily process elements starting from the smallest value, WHY smallest value but not an arbitrary value?
//Because since it's the smallest values, let say x, there is only one choice to pair with x:
//If x is a positive number, then it pairs with y = x*2, for example: x = 4 pair with y = 8.
//If x is a non-positive number, then it pairs with y = x/2, for example: x = -8 pair with y = -4.
//If there is no corresponding y then it's IMPOSSIBLE, return FALSE.
//If it's an arbitrary value, let say x, there are two choices, either x/2 or x*2 is also a good pairing with x (no matter if x is a possible or negative number), if we choose x/2 or x*2 to pair with x, it maybe WRONG, because some other elements may need it to make pair.
//For example: arr = [2, 4, 1, 8]
//If we process x = 2 first, then there are 2 choices, either 4 or 1 can be paired with 2, if we choose 4 -> we got WRONG ANSWER.
//Because 8 needs 4, so 2 should be paired with 1.
//So we need to sort our arr array first.
//When a pair of (x and y) match, we need to decrease their count. So we need to use a HashTable data structure to count the frequency of elements in the arr array.

//Time: O(NlogN), where N <= 3 * 10^4 is number of elements in arr array.
//Space: O(N)

public class ArrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] nums) {
        //Sort the array
        Arrays.sort(nums);
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(int num : nums){
            //If Freq is zero . Continue . that means its has been taken care of
            if(freq.getOrDefault(num, 0) == 0){
                continue;
            }
            // For example: arr=[-5, -2, 1, 2], x = -5, there is no x/2 pair to match
            if(num < 0 && num % 2 != 0){
                return false;
            }

            int target = num < 0 ? num / 2 : num * 2;
            // Don't have the corresponding `target` to match with `num` -> Return IMPOSSIBLE!
            if(freq.getOrDefault(target, 0) == 0){
                return false;
            }

            freq.put(num, freq.get(num) - 1);
            freq.put(target, freq.get(target) - 1);
        }

        return true;
    }
}
