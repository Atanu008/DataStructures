package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/ipo/
//LeetCode 502
//Same Kind of solution as FindMedianFromDataStream . Two Heaps(Min and Max)

//Add all project capitals to a min-heap, so that we can select a project with the smallest capital requirement.
//Go through the top projects of the min-heap and filter the projects that can be completed within our available capital. Insert the profits of all these projects into a max-heap, so that we can choose a project with the maximum profit.
//Finally, select the top project of the max-heap for investment.
//Repeat the 2nd and 3rd steps for the required number of projects.
public class IPOV2 {

    //Storing the Indexes of the arrays in Heap
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Integer> minHeapCapital = new PriorityQueue<>((a, b) ->  capital[a]- capital[b]);
        PriorityQueue<Integer> maxHeapProfit = new PriorityQueue<>((a,b) -> profits[b] - profits[a]);

        //Add all project capitals to a min-heap, so that we can select a project with the smallest capital requirement.
        for(int i = 0; i < capital.length; i++){
            minHeapCapital.offer(i);
        }

        //Initilize Initial Capital
        int availableCapital = w;

        for(int i = 0; i < k; i++){
            //Go through the top projects of the min-heap and filter the projects that can be completed within our available capital. Insert the profits of all these projects into a max-heap, so that we can choose a project with the maximum profit
            while(!minHeapCapital.isEmpty() && capital[minHeapCapital.peek()] <= availableCapital){
                maxHeapProfit.offer(minHeapCapital.poll());
            }

            if(maxHeapProfit.isEmpty()){
                return availableCapital;
            }

            //Finally, select the top project of the max-heap for investment.
            availableCapital += profits[maxHeapProfit.poll()];
        }

        return availableCapital;
    }
}
