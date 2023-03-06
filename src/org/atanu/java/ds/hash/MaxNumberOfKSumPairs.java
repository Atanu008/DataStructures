package org.atanu.java.ds.hash;

//https://leetcode.com/problems/max-number-of-k-sum-pairs/
//Leetcode 1679

//So, what we'll gonna do is & may be you know this one,
//it is similar to Two Sum, so if u dont know then listen to me.

//We gonna fill our map as frequency map.
//And we gonna get the result by subtracting current value from k & whatever result we get,
//we gonna check in our map. If that is present increment the count & remove it from the map now.
// That's how we'll get our answer in just O(1) for searching & as we are using a loop thus, O(N).

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {

        Map<Integer, Integer> freq = new HashMap<>();

        int count = 0;

        for (int num : nums) {
            int remaining = k - num;
            Integer remainingFreq = freq.get(remaining);
            if (remainingFreq != null) {
                count++;
                if (remainingFreq == 1) {
                    freq.remove(remaining);
                } else {
                    freq.put(remaining, freq.get(remaining) - 1);
                }

            } else {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

        }

        return count;
    }
}
