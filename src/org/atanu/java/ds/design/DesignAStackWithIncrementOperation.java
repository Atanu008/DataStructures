package org.atanu.java.ds.design;

//https://leetcode.com/problems/design-a-stack-with-increment-operation/description/
//Leetcode 1381
public class DesignAStackWithIncrementOperation {

    class CustomStack {

        int[] stack;
        int maxSize;
        int top;
        public CustomStack(int maxSize) {
            this.maxSize = maxSize;
            stack = new int[maxSize];
            top = -1;
        }

        public void push(int x) {
            //Return if Full. maxSize -1 as top starts with -1
            if(top == maxSize -1){
                return;
            }
            stack[++top] = x; // Notice doing ++top as top start at -1;
        }

        public int pop() {
            if(top == -1){
                return -1;
            }
            return stack[top--]; // Notice doing top-- as we would return and then move the pointer to next
        }

        public void increment(int k, int val) {
            int i = 0;
            while(i < maxSize && i < k){
                stack[i] = stack[i] + val;
                i++;
            }
        }
    }
}
