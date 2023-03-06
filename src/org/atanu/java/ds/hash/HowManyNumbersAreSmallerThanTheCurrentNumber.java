package org.atanu.java.ds.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
//Leetcode 1365

//Let's use this input for illustration: [8,1,2,2,3]
//
//Create a copy of the input array. copy = [8,1,2,2,3]
//Sort the copy array. copy = [1,2,2,3,8]
//Fill the map: number => count (where count is an index in sorted array, so first number with index 0 has 0 numbers less than it, index 1 has 1 number less, etc). We update only first time we enocunter the number so that way we skip duplicates.
//map[1]=>0
//map[2]=>1
//map[3]=>3
//map[8]=>4
//We re-use our copy array to get our result, we iterate over original array, and get counts from the map.
//[4,0,1,1,3]

public class HowManyNumbersAreSmallerThanTheCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] cloned = nums.clone();

        //Sort the cloned array to get prper indices
        Arrays.sort(cloned);
        //Map to record the position of a number. will take the first index from teh sorted array as it would give the correct position/
        //For Ex : 1 2 2 2 3 : 2 appears Trice but only one is sammler, we need to take first index where 2 appears first i.e 1 here
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < cloned.length; i++){
            map.putIfAbsent(cloned[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            cloned[i] = map.get(nums[i]);
        }

        return cloned;
    }

    public static void main(String[] args) {
        HowManyNumbersAreSmallerThanTheCurrentNumber ob = new HowManyNumbersAreSmallerThanTheCurrentNumber();
        int[] nums = {8,1,2,2,3};
        int[] result = ob.smallerNumbersThanCurrent(nums);
        System.out.println(Arrays.toString(result));
    }
}
