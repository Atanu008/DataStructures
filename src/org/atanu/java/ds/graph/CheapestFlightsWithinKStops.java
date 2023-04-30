package org.atanu.java.ds.graph;

import java.util.*;

// https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// Leetcode 787
// Video : https://www.youtube.com/watch?v=vWgoPTvQ3Rw&t=447s

// Modified Dijkstra Implementation

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for(int[] flight : flights){
            int source = flight[0];
            int destination = flight[1];
            int price = flight[2];
            adjList.computeIfAbsent(source, val -> new ArrayList<>()).add(new int[]{destination, price});
        }

        int[] prices = new int[n];
        int[] stops = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        Arrays.fill(stops, Integer.MAX_VALUE);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]); // Comparing price/distance
        minHeap.offer(new int[]{src, 0, 0}); // new int[]{Node,price,stop}

        while(!minHeap.isEmpty()){

            int[] current = minHeap.poll();
            int currentNode = current[0];
            int currentPrice = current[1];
            int currentStop = current[2];

            // Got it :)
            if(currentNode == dst){
                return currentPrice;
            }

            // K + 1 because we are considering the last node while counting currentStop
            // But it should be in between nodes . k = currentStop - 1 is we should do
            if(currentStop == k + 1){
                continue;
            }

            for(int[] neighbour : adjList.getOrDefault(currentNode, new ArrayList<>())){
                int nextNode = neighbour[0];
                int nextPrice = currentPrice + neighbour[1];
                int nextStop = currentStop + 1;

                // Here Comes the modified Dijkstra
                // when the nextPrice(distance) is less than the previous ones for this node , Take it
                // Also when the stops is less take it , otherwise we may miss some path
                // In both cases update prices state(distance in Dijkstra) for that node
                // Reason :/
                // Let say we already have a recorded a shortest path, let say path X, to a node A that is just before the destination,
                // but the num of stops to node A for this particular path has already maxed out the num of stops,
                // so we just popped it. But in the dist array, we still record this shortest path.
                // Now, there is another path, let say path Y, that is significantly longer but fewer num of stops,
                // we still push path Y to the pq because it has fewer stops. Finally, there is one last path, path Z,
                // in which its distance is lower than path Y, but its num of stops is larger (but within bound) than path Y.
                // However, the distance of path Z is slightly larger than distance of path X.
                // Thus, we are not pushing this path Z to pq because the dist record still save the shortest path,
                // while in fact, this path Z should be  the correct answer.

                // Another perspective :

                // dist array stores the minimum distance from the source to reach a node,
                // stops array stores how many stops are required to reach that node from the source
                // while taking the minimum distance route,
                // So if the minimum distance is not changing then the stops would not change too ,
                // but we would add this route with longer distance but lesser stops to the min heap
                // so that if we find a shorter route through that path in future we could change it.

                if(nextPrice < prices[nextNode] || nextStop <  stops[nextNode]){
                    prices[nextNode] = nextPrice;
                    stops[nextNode] = nextStop;
                    minHeap.offer(new int[]{nextNode, nextPrice, nextStop});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops cheapestFlightsWithinKStops = new CheapestFlightsWithinKStops();

        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        int minimumCost = cheapestFlightsWithinKStops.findCheapestPrice(n, flights, src, dst, k);
        //Output: 700
        //Explanation:
        //The graph is shown above.
        //The optimal path with at most 1 stop from city 0 to 3 is marked in red and has cost 100 + 600 = 700.
        //Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.
        System.out.println(minimumCost);

        n = 3;
        flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        src = 0;
        dst = 2;
        k = 1;

        minimumCost = cheapestFlightsWithinKStops.findCheapestPrice(n, flights, src, dst, k);
        //Output: 200
        //Explanation:
        //The graph is shown above.
        //The optimal path with at most 1 stop from city 0 to 2 is marked in red and has cost 100 + 100 = 200.
        System.out.println(minimumCost);
    }
}
