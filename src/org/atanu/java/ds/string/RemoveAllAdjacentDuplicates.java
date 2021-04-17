package org.atanu.java.ds.string;

import java.util.Stack;

//LeetCode 1047
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
public class RemoveAllAdjacentDuplicates {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            //sb.insert(0,c); // In case of pop(). Another way would be in pop() , append then reverse
            sb.append(c);
        }

        return sb.toString();
    }

    public String removeDuplicatesV2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            int len = sb.length();
            if (len > 0 && sb.charAt(len - 1) == ch) {
                sb.deleteCharAt(len - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    //If there are no 2 same adjacent characters, then we move p forward along with i;
    //else, we move back for 1 step since we need to remove those 2 same adjacent characters!
    public String removeDuplicatesV3(String S) {
        char[] ch = S.toCharArray();
        int len = S.length(), p = 0; // p as a pointer, to point the next index of current substring.
        for (int i=0; i<len; i++) {
            if (p == 0 || ch[i] != ch[p-1]) {
                ch[p++] = ch[i];
                System.out.println("value of P "+p);
            } else {
                p--;
                System.out.println("value of P "+p);
            }
        }
        System.out.println("value of ch "+String.valueOf(ch));
        //System.out.println("value of P "+p);
        return String.valueOf(ch).substring(0, p);
    }

    public static void main(String[] args) {
        RemoveAllAdjacentDuplicates removeAllAdjacentDuplicates = new RemoveAllAdjacentDuplicates();
        String s = "abbaca";
        String afterRemoval = removeAllAdjacentDuplicates.removeDuplicates(s);
        //System.out.println(s + " after adjacent Reomval " + afterRemoval);

        String s1 = "abbaca";
        String afterRemoval1 = removeAllAdjacentDuplicates.removeDuplicatesV3(s1);
        System.out.println(s1 + " after adjacent Reomval " + afterRemoval);
    }
}
