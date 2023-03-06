package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/sequential-digits/description/
//Leetcode 1291
//Video Can Refer : https://www.youtube.com/watch?v=o6aojJpaXBc&t=25s
public class SequentialDigits {
    //Intuition :
    //Idea is to first add 1-9 number in Queue
    //Pop one element and add 1 to it and push it tn the queue to evaluate and form th enext number again
    //if we get any bigger number then no need to procedd further
    public List<Integer> sequentialDigits(int low, int high) {

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= 9; i++){
            queue.offer(i);
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty()){

            int current = queue.poll();

            if(current >= low && current <= high){
                ans.add(current);
            }
            //No need to go branching further as the next numbers would be big only
            if(current > high){
                break;
            }

            int lastDigit = current % 10;
            //If the last digit is 9 then 9 + 10 would be 10 , and that not a single digit number
            // So we can add One till 8
            // Suppose current is 123
            // So our next would be 1234
            // nextNumber = current * 10 + (Reminder + 1);
            // 123 * 10 + (3 + 1) = 1234
            if(lastDigit < 9){
                int nextNumber = current * 10 + (lastDigit + 1);
                queue.offer(nextNumber);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SequentialDigits sequentialDigits = new SequentialDigits();
        System.out.println(sequentialDigits.sequentialDigits(1000, 13000));
    }
}
