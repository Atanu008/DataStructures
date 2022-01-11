package org.atanu.java.ds.stack;

import java.util.Stack;

//https://leetcode.com/problems/backspace-string-compare/
//LeetCode 844
public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();

        //Prepare StackA
        for(char ch : s.toCharArray()){
            //if not backspace then push to stack
            if(ch != '#'){
                stackA.push(ch);
            }
            //Pop in case of #
            else if(!stackA.isEmpty()){
                stackA.pop();
            }

        }

        for(char ch : t.toCharArray()){
            //if not backspace then push to stack
            if(ch != '#'){
                stackB.push(ch);
            }
            //Pop in case of #
            else if(!stackB.isEmpty()){
                stackB.pop();
            }

        }
        //Return false if those stacks have different size
        if(stackA.size()!= stackB.size()){
            return false;
        }

        while(!stackA.isEmpty()){
            //If any character dont match return false
            if(stackA.pop() != stackB.pop()){
                return false;
            }
        }

        //We have come here means they are equal
        return true;
    }

    public static void main(String[] args) {
        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceStringCompare.backspaceCompare(s,t));

        String s1 = "a#c", t1 = "b";
        System.out.println(backspaceStringCompare.backspaceCompare(s1,t1));
    }
}
