package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-number-of-robots-within-budget/description/
//Leetcode 2398
public class MaximumNumberOfRobotsWithinBudget {
    //keep track of the max till now using a priority queue and keep adding to it untill it exceeds the given budget.
//When it exceeds the budget we start removing the elements from the start(using another pointer j).
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {

        int left = 0;
        int right = 0;
        int res = Integer.MIN_VALUE;
        long currentRunningCost = 0; // Need to make it long, with int its becoming overflow
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());


        while(right < chargeTimes.length){
            currentRunningCost += runningCosts[right];
            maxHeap.offer(chargeTimes[right]);
            while((!maxHeap.isEmpty() && (maxHeap.peek() + ((right - left + 1) * currentRunningCost)) >  budget)){
                maxHeap.remove(chargeTimes[left]);
                currentRunningCost -= runningCosts[left];
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }

    public static void main(String[] args) {
        MaximumNumberOfRobotsWithinBudget maximumNumberOfRobotsWithinBudget = new MaximumNumberOfRobotsWithinBudget();
        int[] chargeTimes = {3,6,1,3,4}, runningCosts = {2,1,3,4,5};
        long budget = 25;
        int maxRobot = maximumNumberOfRobotsWithinBudget.maximumRobots(chargeTimes, runningCosts, budget);
        //Output: 3
        //Explanation:
        //It is possible to run all individual and consecutive pairs of robots within budget.
        //To obtain answer 3, consider the first 3 robots. The total cost will be max(3,6,1) + 3 * sum(2,1,3) = 6 + 3 * 6 = 24 which is less than 25.
        //It can be shown that it is not possible to run more than 3 consecutive robots within budget, so we return 3.
        System.out.println(maxRobot);

    }
}
