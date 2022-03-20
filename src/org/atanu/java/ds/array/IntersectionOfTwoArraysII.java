package org.atanu.java.ds.array;

import java.util.*;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int a : nums1) {
            frequencyMap.put(a, frequencyMap.getOrDefault(a, 0) +1);
        }
        List<Integer> result = new ArrayList<>();
        for(int b : nums2) {
            if(frequencyMap.containsKey(b) && frequencyMap.get(b) > 0) {
                result.add(b);
                frequencyMap.put(b, frequencyMap.get(b) -1); //Decrement Frequency If Found in secod Arrau
            }
        }

        //Convert List Array. This one is not best I guess
        return result.stream().mapToInt(a ->a).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        IntersectionOfTwoArraysII intersectionOfTwoArrays = new IntersectionOfTwoArraysII();
        int[] result = intersectionOfTwoArrays.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
