package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/single-number-ii/
//LeetCode 137
public class SingleNumberII {

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a: nums) {
            map.put(a, map.getOrDefault(a,0) +1);
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    //https://leetcode.com/problems/single-number-ii/discuss/43297/Java-O(n)-easy-to-understand-solution-easily-extended-to-any-times-of-occurance
    public int singleNumberV2(int[] nums) {

        int ans = 0;
        for(int bit = 0; bit < 32; bit++) {

            int sum = 0;
            for(int i = 0; i < nums.length; i++) {
                if(((nums[i] >> bit) & 1) == 1){
                    sum++;
                }
            }
            sum %= 3;
            ans |= sum << bit; // sum will either be 0 or 1
        }

        return ans;
    }

    public static void main(String[] args) {
        int a = 8;

        a |= 10;
        System.out.println(a);
    }
}
