package org.atanu.java.ds.heap;

import java.util.*;

//https://leetcode.com/problems/task-scheduler/
//LeetCode 621
//https://www.educative.io/courses/grokking-the-coding-interview/B1gBkopEBzk
public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for(char ch : tasks) {
            characterFrequencyMap.put(ch, characterFrequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(characterFrequencyMap.entrySet());
        int count = 0;
        while(!maxHeap.isEmpty()) {

            List<Map.Entry<Character, Integer>> waitList = new ArrayList<>();
            int interval = n + 1;
            // fill the intervals with the next high freq task
            while(interval > 0 && !maxHeap.isEmpty()) {
                // one slot is taken
                count++;
                // interval shrinks
                interval--;
                //Get teh Task and Decrement its frequency
                Map.Entry<Character, Integer> currentTask = maxHeap.poll();
                currentTask.setValue(currentTask.getValue() - 1);
                //Add it waitList if it still has occurances after decremenet
                if(currentTask.getValue() > 0) {
                    waitList.add(currentTask);
                }

            }
            //Add all the Tasks from WaitList To teh MaxHeap
            maxHeap.addAll(waitList);

            //This is a bit tricky.
            //Here either  interval is zero i.e In one iteration (n+1) task got execited
            //Or it may have some positive value, that is in iteration it could not execute n+1 task.
            //It was idle for remaining time thats will be the value of interval
            //So basically if interval is > 0, then the machine can only be idle , add it to the count
            if(!maxHeap.isEmpty()) {
                count += interval;
            }

        }

        return count;
    }

    public static void main(String[] args) {
        TaskScheduler taskScheduler = new TaskScheduler();
        char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'b', 'b' };
        //Input: tasks = ["A","A","A","B","B","B"], n = 2
        //Output: 8
        //Explanation:
        //A -> B -> idle -> A -> B -> idle -> A -> B
        //There is at least 2 units of time between any two same tasks.
        System.out.println("Minimum intervals needed to execute all tasks: " + taskScheduler.leastInterval(tasks, 2));

        tasks = new char[] { 'a', 'b', 'a' };
        System.out.println("Minimum intervals needed to execute all tasks: " + taskScheduler.leastInterval(tasks, 3));
    }
}
