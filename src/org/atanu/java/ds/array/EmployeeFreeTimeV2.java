package org.atanu.java.ds.array;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/employee-free-time/
//LeetCode 759
//https://www.educative.io/courses/grokking-the-coding-interview/RLwKZWgMJ1q
public class EmployeeFreeTimeV2 {
    static class EmployeeInterval{
        Interval interval;// interval representing employee's working hours
        int intervalIndex;// index of the list containing working hours of this employee
        int employeeIndex;// index of the interval in the employee list

        EmployeeInterval(Interval interval, int employeeIndex, int intervalIndex){
            this.interval = interval;
            this.employeeIndex = employeeIndex;
            this.intervalIndex = intervalIndex;

        }

    }
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> result = new ArrayList<>();
        PriorityQueue<EmployeeInterval> pq = new PriorityQueue<>((a, b) -> a.interval.start - b.interval.start);
        //insert the first interval of each employee to the queue
        for(int i = 0; i < schedule.size(); i++){
            pq.offer(new EmployeeInterval(schedule.get(i).get(0), i, 0));
        }

        Interval prevInterval = pq.peek().interval;

        while(!pq.isEmpty()){
            EmployeeInterval queueTop = pq.poll();
            Interval currentInterval = queueTop.interval;
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

            List<Interval> currentEmployeeSchedule = schedule.get(queueTop.employeeIndex);
            //if there are more intervals available for the same employee, add their next interval
            if(currentEmployeeSchedule.size() > queueTop.intervalIndex +1){
                pq.offer(new EmployeeInterval(currentEmployeeSchedule.get(queueTop.intervalIndex +1), queueTop.employeeIndex, queueTop.intervalIndex +1));
            }
        }
        return result;
    }
}
