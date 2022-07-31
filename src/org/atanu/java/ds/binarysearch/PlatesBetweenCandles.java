package org.atanu.java.ds.binarysearch;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/plates-between-candles/
//LeetCode 2055
public class PlatesBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries) {

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '|'){
                treeMap.put(i, count);
            }
            else{
                count++;
            }
        }

        int[] result = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            //We need the next Candel , that why use ceiling. either at position if avaialble or next
            Map.Entry<Integer, Integer> left = treeMap.ceilingEntry(queries[i][0]);
            //want either  at position if avaialble or lower
            Map.Entry<Integer, Integer> right = treeMap.floorEntry(queries[i][1]);

            if(left != null && right != null){
                //There might be cases where there wont be two candel between
                //result can be negative , so take 0 instead
                result[i] = Math.max(right.getValue() - left.getValue(), 0);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        PlatesBetweenCandles platesBetweenCandles = new PlatesBetweenCandles();
        String s = "**|**|***|";
        int[][] queries = {{2,5},{5,9}};
        int[] result = platesBetweenCandles.platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(result));
        s = "***|**|*****|**||**|*";
        queries = new int[][]{{1,17},{4,5},{14,17},{5,11},{15,16}};
        result = platesBetweenCandles.platesBetweenCandles(s, queries);
        System.out.println(Arrays.toString(result));

    }
}
