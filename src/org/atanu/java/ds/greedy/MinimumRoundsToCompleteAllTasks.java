package org.atanu.java.ds.greedy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/description/
//LeetCode 2244

//If the frequency is 1, the task cannot be performed so we return -1.
//If the frequency is 3, the task can be performed and we return frequency/3.
//Now if the frequency is not completely divisible by 3, then the possible remainders are 1 and 2. Lets check them out:

//If remainder is 1, i.e, lets take 7 frequency, then 🔮🔮🔮🔮🔮🔮🔮
//the groups are something like this "🔮🔮🔮" "🔮🔮🔮" "🔮",
//i.e, one 🔮 is left alone so the solution is to break the second last group into two parts of 2 and 1
//so that it becomes like: "🔮🔮🔮" "🔮🔮" "🔮🔮", i.e, one is added to the division by 3.

//If remainder is 2, i.e, lets take 8 frequency, then 🔮🔮🔮🔮🔮🔮🔮🔮
//the groups are something like this "🔮🔮🔮" "🔮🔮🔮" "🔮🔮", i.e, two 🔮 are left
//so the solution is to just add 1,i.e, one group of two to the solution.
public class MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {

        Map<Integer, Integer> taskFreq = new HashMap<>();
        for(int task : tasks){
            taskFreq.put(task, taskFreq.getOrDefault(task, 0) + 1);
        }

        int minRound = 0;
        for(int freq : taskFreq.values()){

            if(freq == 1){
                return -1;
            }

            if(freq % 3 == 0){
                minRound += freq / 3;
            }
            else {
                minRound += (freq / 3) + 1;
            }
        }

        return minRound;
    }

    public int minimumRoundsV2(int[] tasks) {

        Map<Integer, Integer> freq = new HashMap<>();
        for(int task : tasks){
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        int roundes = 0;
        for(int freqOfDifficulty : freq.values()){

            if(freqOfDifficulty == 1){
                return -1;
            }
            roundes += freqOfDifficulty / 3;
            if(freqOfDifficulty % 3 != 0){
                roundes++;
            }
        }

        return roundes;
    }

    public static void main(String[] args) {
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        int minRound = new MinimumRoundsToCompleteAllTasks().minimumRounds(tasks);
        System.out.println("Minimum Round Needed is "+ minRound);
    }
}
