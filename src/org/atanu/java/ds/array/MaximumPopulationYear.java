package org.atanu.java.ds.array;

// https://leetcode.com/problems/maximum-population-year/description/
// Leetcode 1854

// We can mark the start and end of each life as +1 and -1 on the timeline.
// Then, we go through timeline from 1950 to 2050 and accumulate the current population for each year.

public class MaximumPopulationYear {

    public int maximumPopulation(int[][] logs) {

        int[] year = new int[2051];

        // O(n) -> n is log.length

        for(int[] log : logs){

            year[log[0]] += 1;
            year[log[1]] -= 1;
        }

        int maxNum = year[1950], maxYear = 1950;

        // O(100) -> 2050 - 1950 = 100

        for(int i = 1951; i < year.length; i++){
            year[i] += year[i - 1];  // Generating Prefix Sum

            if(year[i] > maxNum){
                maxNum = year[i];
                maxYear = i;
            }
        }

        return maxYear;
    }

    public int maximumPopulation_v2(int[][] logs) {

        int[] year = new int[101];
        for(int[] log : logs){
            year[log[0] - 1950]++;
            year[log[1] - 1950]--;
        }

        int maxYear = 1950;
        int maximumPopulation = year[0];
        for(int i = 1; i < year.length; i++){
            year[i] = year[i] + year[i - 1];
            if(year[i] > maximumPopulation){
                maximumPopulation = year[i];
                maxYear = i + 1950;
            }
        }

        return maxYear;
    }

    public static void main(String[] args) {
        MaximumPopulationYear maximumPopulationYear = new MaximumPopulationYear();
        int[][] logs = {{1950,1961},{1960,1971},{1970,1981}};
        System.out.println(maximumPopulationYear.maximumPopulation(logs));

    }
}
