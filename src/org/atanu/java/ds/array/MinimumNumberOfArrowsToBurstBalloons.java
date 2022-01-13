package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
//LeetCode 452
public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {

        //Sort by end position
        //[[-2147483646,-2147483645],[2147483646,2147483647]]
        //Arrays.sort(points, (a,b) -> a[1]-b[1]); // Not working for Integer range issue
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); //Works
        //Arrays.sort(points, (a,b) -> a[1]< b[1] ? -1 : 1); //Works

        int previousBaloonEnd = points[0][1];
        int arrowCount = 1; //Atleast need one baloon to burst first baloon, as we will start check from 2nd one

        for(int i = 1; i < points.length; i++){
            int currentBaloonStart = points[i][0];

            //Two Baloons are overlapping . Existing arrow is enough to burst this baloon
            //No need for extra Arrow
            if(currentBaloonStart <= previousBaloonEnd){
                continue;
            }

            //Need one arrow to burst this baloon as this not overlapping with the previous one
            arrowCount++;
            previousBaloonEnd = points[i][1]; //Update previous End
        }

        return arrowCount;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons arrowsToBurstBalloons = new MinimumNumberOfArrowsToBurstBalloons();
        int[][] points = {{10,16},{2,8},{1,6},{7,12}};
        //Output: 2
        //Explanation: The balloons can be burst by 2 arrows:
        //- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
        //- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
        System.out.println("Minimum No os arrow needed is "+ arrowsToBurstBalloons.findMinArrowShots(points));
    }
}
