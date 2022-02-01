package org.atanu.java.ds.cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstKMissingPositive {
    public List<Integer> findNumbers(int[] nums, int k) {
        int i = 0;
        while(i < nums.length) {
            int j = nums[i] -1;
            if(nums[i] != nums[j]) {
                swap(nums, i, j);
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> validPresentNumbers = new HashSet<>();

        for(int j = 0; j < nums.length && missingNumbers.size() < k ; j++) {
           if(nums[j] != j+1){
               missingNumbers.add(j+1);
               validPresentNumbers.add(nums[j]);
           }
        }

        for(int l = 1; missingNumbers.size() < k; l++) {
            int candidate = l + nums.length;
            if(!validPresentNumbers.contains(candidate)) {
                missingNumbers.add(candidate);
            }
        }
        return missingNumbers;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
