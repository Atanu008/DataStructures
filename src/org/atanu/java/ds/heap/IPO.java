package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/ipo/
//LeetCode 502
//Same Kind of solution as FindMedianFromDataStream . Two Heaps(Min and Max)

//Add all project capitals to a min-heap, so that we can select a project with the smallest capital requirement.
//Go through the top projects of the min-heap and filter the projects that can be completed within our available capital. Insert the profits of all these projects into a max-heap, so that we can choose a project with the maximum profit.
//Finally, select the top project of the max-heap for investment.
//Repeat the 2nd and 3rd steps for the required number of projects.
public class IPO {

    private static class Project{
        int capital;
        int profit;

        Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        PriorityQueue<Project> minHeapCapital = new PriorityQueue<>((a, b) -> a.capital - b.capital);
        PriorityQueue<Project> maxHeapProfit = new PriorityQueue<>((a,b) -> b.profit - a.profit);

        //Add all project capitals to a min-heap, so that we can select a project with the smallest capital requirement.
        for(int i = 0; i < capital.length; i++){
            Project project = new Project(capital[i], profits[i]);
            minHeapCapital.offer(project);
        }

        //Initilize Initial Capital
        int availableCapital = w;

        for(int i = 0; i < k; i++){
            //Go through the top projects of the min-heap and filter the projects that can be completed within our available capital. Insert the profits of all these projects into a max-heap, so that we can choose a project with the maximum profit
            while(!minHeapCapital.isEmpty() && minHeapCapital.peek().capital <= availableCapital){
                maxHeapProfit.offer(minHeapCapital.poll());
            }

            if(maxHeapProfit.isEmpty()){
                return availableCapital;
            }

            //Finally, select the top project of the max-heap for investment.
            availableCapital += maxHeapProfit.poll().profit;
        }

        return availableCapital;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        int k = 2, w = 0;
        int[] profits = {1,2,3}, capital = {0,1,1};
        //Output: 4
        //Explanation: Since your initial capital is 0, you can only start the project indexed 0.
        //After finishing it you will obtain profit 1 and your capital becomes 1.
        //With capital 1, you can either start the project indexed 1 or the project indexed 2.
        //Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
        //Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
        System.out.println("Maximum Capital is "+ ipo.findMaximizedCapital(k, w, profits, capital));
    }
}
