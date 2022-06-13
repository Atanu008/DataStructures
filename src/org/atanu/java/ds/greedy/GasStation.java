package org.atanu.java.ds.greedy;

//https://leetcode.com/problems/gas-station/
//LeetCode 134

//Perfect Video : https://www.youtube.com/watch?v=wDgKaNrSOEI
//Video This One Too : https://www.youtube.com/watch?v=ROrEAUbWg9w
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGasInTank = 0;
        int totalCost = 0;
        for(int i = 0; i < gas.length; i++){
            totalGasInTank += gas[i];
            totalCost += cost[i];
        }

        //Trip is not posible from any starting position
        if(totalGasInTank < totalCost){
            return -1;
        }

        int gasInTank = 0;
        int start = 0;
        for(int i = 0; i < gas.length; i++){

            gasInTank += gas[i] - cost[i];

            if(gasInTank < 0){
                gasInTank = 0;
                start = i+1;
            }
        }

        return start;
    }

    // In One pass . Same as above just with optimization
    public int canCompleteCircuitV2(int[] gas, int[] cost) {

        int gasInTank = 0;
        int start = 0;
        int deficit = 0;
        for(int i = 0; i < gas.length; i++){

            gasInTank += gas[i] - cost[i];

            if(gasInTank < 0){
                deficit += gasInTank;
                gasInTank = 0;
                start = i+1;
            }
        }

        return gasInTank + deficit >= 0 ? start : -1;
    }
}
