package org.atanu.java.ds.stack;

import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {

	public static void mergeOverlappingIntervals(Interval [] intervals) {

		// Test if the given set has at least one interval  
		if (intervals.length <= 0)  
			return;  

		// Create an empty stack of intervals  
		Stack<Interval> stack=new Stack<>(); 

		Arrays.sort(intervals, (a , b) -> a.start - b.start);

		for (int i = 0; i < intervals.length; i++) {

			Interval t = intervals[i];
			System.out.print("["+t.start+","+t.end+"] "); 
		}

		stack.push(intervals[0]);

		for (int i = 1; i < intervals.length; i++) 
		{
			Interval cur = intervals[i];

			Interval top = stack.peek();

			// if current interval is not overlapping with stack top,  
			// push it to the stack  
			if(top.end < cur.start )
			{
				stack.push(cur);
			}

			// Otherwise update the ending time of top if ending of current interval is more 
			else if(top.end < cur.end)
			{
				top.end = cur.end;
				stack.pop();
				stack.push(top);

			}
		}

		// Print contents of stack  
		System.out.print("The Merged Intervals are: "); 
		while (!stack.isEmpty())  
		{  
			Interval t = stack.pop();  
			System.out.print("["+t.start+","+t.end+"] "); 
		}  

	}

	public static void main(String[] args) {

		Interval arr[]=new Interval[5]; 
		arr[0]=new Interval(6,8); 
		arr[1]=new Interval(1,9); 
		arr[2]=new Interval(2,4); 
		arr[3]=new Interval(4,7);
		arr[4]=new Interval(8,15);

		mergeOverlappingIntervals(arr);

	}

}

class Interval {

	int start ;
	int end;

	public Interval (int start , int end) {

		this.start = start;
		this.end = end;
	}
}
