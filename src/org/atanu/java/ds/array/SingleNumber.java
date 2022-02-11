package org.atanu.java.ds.array;

import java.util.HashMap;

public class SingleNumber {

    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash_table = new HashMap<>();
        for (int i : nums) {
            if (hash_table.get(i) == i) {
                hash_table.remove(i);
            } else {
                hash_table.put(i, i);
            }
        }
        return hash_table.keySet().stream().findFirst().get();
    }

    //So we can XOR all the numbers in the input;
    //duplicate numbers will zero out each other and we will be left with the single number.
    public int singleNumberV2(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }
}
