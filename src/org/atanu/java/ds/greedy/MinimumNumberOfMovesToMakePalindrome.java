package org.atanu.java.ds.greedy;

import java.util.LinkedList;

//https://leetcode.com/problems/minimum-number-of-moves-to-make-palindrome/description/
//Leetcode 2193
public class MinimumNumberOfMovesToMakePalindrome {
    //Intition
    //If it is single character then we need to move it to middle
    //So we will mark the last character
    // Start checking it from first , if any character found same as last one
    // then we can move it to first posotion so that the last position and first position can cance out
    // So the moves needed to make that elemt to bring it to First is the index number
    // For Example cbda.....a
    // Last Char = 'a'
    // We got another 'a' whose index is 3
    // so lets make 3 moves - cdba -> cdab -> cadb -> acdb
    // So it took 3 moves to bring it first

    //Edge case when the last character has only only one occurance , for odd also it will happen
    // We need it bring that last char to Middle i.e (index/2)

    //https://www.youtube.com/watch?v=2Vcdjb-H8yA
    public int minMovesToMakePalindrome(String s) {

        LinkedList<Character> queue = new LinkedList<>();
        //Make Queeu from the String
        for(char ch : s.toCharArray()){
            queue.add(ch);
        }

        int res = 0;

        while(!queue.isEmpty()){

            char lastChar = queue.getLast();

            int index = 0;
            while(queue.get(index) != lastChar){
                index++;
            }

            if(index == queue.size() - 1){
                res += index / 2;
            }
            else{
                res += index;
            }

            if(index != queue.size() - 1){
                queue.remove(index);
            }

            queue.removeLast();
        }

        return res;
    }

    public int minMovesToMakePalindrome_v2(String s) {
        int res = 0;
        while (s.length() > 0) {
            int i = s.indexOf(s.charAt(s.length() - 1));
            if (i == s.length() - 1)
                res += i / 2;
            else {
                res += i;
                s = s.substring(0, i) + s.substring(i + 1);
            }
            s = s.substring(0, s.length() - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "aabb";
        MinimumNumberOfMovesToMakePalindrome minimumNumberOfMovesToMakePalindrome = new MinimumNumberOfMovesToMakePalindrome();
        int minMoves = minimumNumberOfMovesToMakePalindrome.minMovesToMakePalindrome(s);
        System.out.println("Minimum Moves "+ minMoves);
        minMoves = minimumNumberOfMovesToMakePalindrome.minMovesToMakePalindrome_v2(s);
        System.out.println("Minimum Moves "+ minMoves);
    }
}
