package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/baseball-game/description/
//Leetcode 682
public class BaseballGame {
    public int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for(String ch : operations){
            if(ch.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                int sum = a + b;
                //The Order is Imp , b is the last element popped , we need to push it first
                //Then a and then the sum
                stack.push(b);
                stack.push(a);
                stack.push(sum);

                /*int a = stack.pop();
                int newScore = a + stack.peek();
                stack.push(a);
                stack.push(newScore);*/
            }
            else if(ch.equals("D")){
                stack.push(2 * stack.peek());
            }
            else if(ch.equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.parseInt(ch));
            }
        }

        int result = 0;

        for(int a : stack){
            result += a;
        }

        return result;
    }

    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        String[] ops = {"5","2","C","D","+"};
        int points = baseballGame.calPoints(ops);
        //Output: 30
        //Explanation:
        //"5" - Add 5 to the record, record is now [5].
        //"2" - Add 2 to the record, record is now [5, 2].
        //"C" - Invalidate and remove the previous score, record is now [5].
        //"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
        //"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
        //The total sum is 5 + 10 + 15 = 30.
        System.out.println(points);
    }
}
