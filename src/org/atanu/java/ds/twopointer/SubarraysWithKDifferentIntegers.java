package org.atanu.java.ds.twopointer;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarrays-with-k-different-integers/description/
// Leetcode 992

// https://leetcode.com/problems/subarrays-with-k-different-integers/solutions/523136/java-c-python-sliding-window/?orderBy=most_votes
// https://leetcode.com/problems/subarrays-with-k-different-integers/solutions/672979/analysis-and-explanation-with-visualization/?orderBy=most_votes
// Video : https://www.youtube.com/watch?v=akwRFY2eyXs can refer

// subarraysWith(K)Distinct = subarraysWithAtMost(K)Distinct - subarraysWithAtMost(K -1)Distinct
// i.e subarrays of size EXACTLY K = Compute subarrays of size AT MOST K and subtract subarrays of size AT MOST K - 1
// atMostK(A, k) includes subarrays of size 1, 2, 3, .... k (all subrrays with size less than K).
// How to get rid of those arrays that have size less than K?
// Compute subarrays of size K - 1(atMostK(A, k - 1)) which will give you subarrays of size 1, 2, 3, .... k - 1.
// The subarrays that we don't want from the first list will be cancelled out by the subarrays in the second list.

// subArrayCount += windowEnd - windowStart + 1;
// Explanation
//suppose initial window [a] then subarrays that ends with this element are [a] --> 1
//now we expand our window [a,b] then subarrays that ends with this new element are [b], [a,b] -->2
//now we expand our window [a,b,c] then subarrays that ends with this new element are [c], [b, c], [a,b,c] -->3
//now we expand our window [a,b,c,d] and let suppose this is not valid window so we compress window from left side to make it valid window
//[b,c,d] then subarrays that ends with this new element are [d], [c,d], [b,c,d] -->3
//
//You can observe that we are only considering subarrays with new element in it which auto. eliminate the counting of duplicate subarrays that we already considered previously.
//And surprisingly the number of sub-arrays with this new element in it is equal to the length of current window.

public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {

        return subarraysWithAtMostKDistinct(nums, k) - subarraysWithAtMostKDistinct(nums, k-1);
    }

    public int subarraysWithAtMostKDistinct(int[] nums, int k) {
        int windowStart = 0;
        int windowEnd = 0;
        int subArrayCount = 0;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        while(windowEnd < nums.length){

            int rightElement = nums[windowEnd];
            frequencyMap.put(rightElement, frequencyMap.getOrDefault(rightElement, 0) + 1);

            while(frequencyMap.size() > k){

                int leftElement = nums[windowStart];
                frequencyMap.put(leftElement, frequencyMap.get(leftElement) - 1);
                if(frequencyMap.get(leftElement) == 0){
                    frequencyMap.remove(leftElement);
                }
                windowStart++;
            }

            subArrayCount += windowEnd - windowStart + 1;
            windowEnd++;
        }

        return subArrayCount;
    }
}
