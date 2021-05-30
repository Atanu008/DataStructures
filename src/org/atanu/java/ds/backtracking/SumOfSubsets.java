package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// To get the sum of sub sets. we could have generated the subsets and the add . O(2^N.N)
// Here we are removing the N by doing the calculation in flight
public class SumOfSubsets {

    public List<Integer> sumOfSubSets(int[] nums, LinkedList<Integer> current, int[] sum, List<Integer> result, int index){
        result.add(sum[0]);
        for(int i = index; i < nums.length; i++){
            current.addLast(nums[i]);
            sum[0] += nums[i]; // we are adding the sum to 0th index
            sumOfSubSets(nums, current, sum, result, i+1);
            sum[0] -= current.removeLast(); // removing the sum added in line 14. removing the element as well. for backtrack
        }
        return result;
    }
    public static void main(String[] args) {
        SumOfSubsets sumOfSubsets = new SumOfSubsets();
        int[] sum = new int[1];
        int[] nums = {1,2,3};
        LinkedList<Integer> current = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        result = sumOfSubsets.sumOfSubSets(nums, current, sum, result, 0);
        Collections.sort(result);
        result.forEach(System.out::print);
    }
}
