package org.atanu.java.ds.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubarraySumEqualsKV2 {

    public static void findSubArraysSol1(int[] a, int sum) {

        for (int i = 0; i < a.length; i++) {

            int sum_so_far = 0;

            // consider all sub-arrays starting from i and ending at j
            for (int j = i; j < a.length; j++) {

                sum_so_far += a[j];

                // if sum so far is equal to the given sum
                if (sum == sum_so_far) {
                    print(a, i, j);
                }
            }
        }
    }

    public static void findSubArraysSol2(int[] a, int sum) {

        // create a map for storing end index of all subarrays with
        // sum of elements so far
        Map<Integer, List<Integer>> map = new HashMap<>();

        // To handle the case when the subarray with given sum starts
        // from 0th index
        insert(map, 0, -1);

        int sum_so_far = 0;
        for (int index = 0; index < a.length; index++) {

            // sum of elements so far
            sum_so_far += a[index];

            int temp = sum_so_far - sum;

            // check if there exists at-least one sub-array with given sum
            if (map.containsKey(sum_so_far - sum)) {

                List<Integer> list = map.get(temp);
                for (Integer value : list) {
                    print(a, value + 1, index);
                }
            }

            // insert (sum so far, current index) pair into the map
            insert(map, sum_so_far, index);
        }


    }

    //Utility function to insert <key, value> pair into the Multimap
    private static void insert(Map<Integer, List<Integer>> hashMap, int key, int value) {
        // if the key is seen for the first time, initialize the list
        if (!hashMap.containsKey(key)) {
            hashMap.put(key, new ArrayList<>());
        }

        hashMap.get(key).add(value);
    }

    public static void print(int[] arr, int i, int j) {
        System.out.println(IntStream.range(i, j + 1)
                .mapToObj(k -> arr[k])
                .collect(Collectors.toList()));
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, -7, 1, 3, 3, 1, -4};
        int sum = 7;

        //findSubArraysSol1(arr, sum);

        System.out.println();

        findSubArraysSol2(arr, sum);
    }

}
