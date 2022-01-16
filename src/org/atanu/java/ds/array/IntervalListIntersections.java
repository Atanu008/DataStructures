package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> resultIntersection = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length){

            // check if the interval arr[i] intersects with arr2[j]
            // check if one of the interval's start time lies within the other interval
            if((firstList[i][0] >= secondList[j][0] && firstList[i][0] <= secondList[j][1]) ||
                    (secondList[j][0] >= firstList[i][0] && secondList[j][0] <= firstList[i][1])){


                int start = Math.max(firstList[i][0], secondList[j][0]);
                int end = Math.min(firstList[i][1], secondList[j][1]);
                // store the intersection part
                resultIntersection.add(new int[]{start,end});
            }

            // move next from the interval which is finishing first
            if(firstList[i][1] < secondList[j][1]){
                i++;
            }
            else{
                j++;
            }
        }

        return resultIntersection.toArray(new int[resultIntersection.size()][]);
    }

    public int[][] intervalIntersectionV2(int[][] firstList, int[][] secondList) {

        List<int[]> resultIntersection = new ArrayList<>();
        int i = 0;
        int j = 0;

        while(i < firstList.length && j < secondList.length){

            if((firstList[i][0] <= secondList[j][1] && secondList[j][0] <= firstList[i][1]) ||
                    (secondList[j][0] <= firstList[i][1] && firstList[i][0] <= secondList[j][1])){


                int start = Math.max(firstList[i][0], secondList[j][0]);
                int end = Math.min(firstList[i][1], secondList[j][1]);
                // store the intersection part
                resultIntersection.add(new int[]{start,end});
            }

            // move next from the interval which is finishing first
            if(firstList[i][1] < secondList[j][1]){
                i++;
            }
            else{
                j++;
            }
        }

        return resultIntersection.toArray(new int[resultIntersection.size()][]);
    }

    public static void main(String[] args) {
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();

    }
}
