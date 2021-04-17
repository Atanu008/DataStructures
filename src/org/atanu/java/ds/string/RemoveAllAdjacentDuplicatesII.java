package org.atanu.java.ds.string;

import java.util.Stack;

//Leetcode 1209
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
public class RemoveAllAdjacentDuplicatesII {
    public String removeDuplicates(String s, int k) {
        Stack<AdPair> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if(stack.isEmpty() || stack.peek().ch != ch){
                stack.push(new AdPair(ch,1));
            }
            else{
                stack.peek().count++;
            }
            if(stack.peek().count == k){
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            AdPair adp = stack.pop();
            int i = adp.count;
            while(i>0){
                sb.insert(0,adp.ch);
                i--;
            }

        }
        return sb.toString();
    }

    class AdPair{
        char ch;
        int count;
        AdPair(char ch, int count){
            this.ch = ch;
            this.count = count;
        }
    }

    public String removeDuplicatesV2(String s, int k) {
        int count = 1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }
            else{
                count=1;
            }

            if(count==k){
                String reduced = s.substring(0,i-k+1) + s.substring(i+1);
                return removeDuplicates(reduced,k);
            }
        }

        return s;
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicatesII rm = new RemoveAllAdjacentDuplicatesII();
        String s = "deeedbbcccbdaa";
        int k = 3;
        String afterRemoval = rm.removeDuplicates(s,k);
        System.out.println(s + " after adjacent Reomval " + afterRemoval);

        String afterRemoval1 = rm.removeDuplicatesV2(s,k);
        System.out.println(s + " after adjacent Reomval " + afterRemoval1);
    }
}
