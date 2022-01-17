package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/employee-free-time/
//LeetCode 759
// Kind of Merge Interval pattern used
public class EmployeeFreeTime {

    //Will Use the Merge Interval Approach here
    //Take the interval when non over lapped
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> result = new ArrayList<>();
        List<Interval> allIntervals = new ArrayList<>();
        //Put all the schedule in a list
        for(List<Interval> list : schedule){
            list.forEach(a -> allIntervals.add(a));
        }

        //Sort the list using Start Time
        Collections.sort(allIntervals, (a, b) -> a.start - b.start);

        Interval prevInterval = allIntervals.get(0);

        for(int i = 1; i < allIntervals.size(); i++){

            Interval currentInterval = allIntervals.get(i);
            //Non Over Lapping
            //Take the free slot i,e in between prev and current slot
            //update the Prev Interval to Current
            if(currentInterval.start > prevInterval.end){
                int start = prevInterval.end;
                int end = currentInterval.start;
                Interval free = new Interval(start, end);
                result.add(free);
                prevInterval = currentInterval;
            }
            //OverLapping
            else{
                //Update End of previous to the max of Previous and Current ends
                prevInterval.end = Math.max(prevInterval.end, currentInterval.end);
            }
        }
        return result;
    }


    //O(NlogN) : As we are inserting all elements in the queue
    public List<Interval> employeeFreeTimeV2(List<List<Interval>> schedule) {

        List<Interval> result = new ArrayList<>();
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        //Put all the schedule in a list
        for(List<Interval> list : schedule){
            pq.addAll(list);
        }

        Interval prevInterval = pq.peek();

        while(!pq.isEmpty()){

            Interval currentInterval = pq.poll();
            //Non Over Lapping
            //Take the free slot i,e in between prev and current slot
            //update the Prev Interval to Current
            if(currentInterval.start > prevInterval.end){
                int start = prevInterval.end;
                int end = currentInterval.start;
                Interval free = new Interval(start, end);
                result.add(free);
                prevInterval = currentInterval;
            }
            //OverLapping
            else{
                //Update End of previous to the max of Previous and Current ends
                prevInterval.end = Math.max(prevInterval.end, currentInterval.end);
            }
        }
        return result;
    }
}
