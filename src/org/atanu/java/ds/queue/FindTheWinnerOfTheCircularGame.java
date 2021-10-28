package org.atanu.java.ds.queue;

import java.util.ArrayDeque;
import java.util.Queue;

//Video : https://www.youtube.com/watch?v=V5CyomTb-94
//https://leetcode.com/problems/find-the-winner-of-the-circular-game/
//LeetCode 1823
public class FindTheWinnerOfTheCircularGame {

    public int findTheWinner(int n, int k) {

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= n; i++){
            queue.offer(i);
        }

        //Put k-1 item back of the queue and Remove the Kth element
        //Finally return the single element
        while(!queue.isEmpty() && queue.size() != 1){

            for(int i = 1; i < k; i++){
                queue.offer(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }


    //In the end,n = 1,
    //the index of winner index is 0 (base-0)
    //
    //We think with one step back,
    //when n = 2,
    //the index of winner is 0 + k,
    //but we have only n peopple,
    //so the winner index is (0 + k) % 2 (base-0)
    //
    //We think with one more step back,
    //when n = 3,
    //the index of winner is f(2) + k,
    //but we have only n peopple,
    //so the winner index is (f(2) + k) % 3 (base-0)
    //
    //We think with n more step back,
    //the index of winner is f(n-1) + k,
    //but we have only n peopple,
    //so the winner index is (f(n-1) + k) % n (base-0)
    public int findTheWinnerV2(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; ++i)
            res = (res + k) % i;
        return res + 1;
    }

    public static void main(String[] args) {
        FindTheWinnerOfTheCircularGame winner = new FindTheWinnerOfTheCircularGame();
        System.out.println("Winner is "+ winner.findTheWinner(5,2));
        System.out.println("Winner is "+ winner.findTheWinner(6,5));

        System.out.println("Winner is "+ winner.findTheWinnerV2(5,2));
        System.out.println("Winner is "+ winner.findTheWinnerV2(6,5));
    }
}
