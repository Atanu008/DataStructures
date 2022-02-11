package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
//LeetCode 744
//https://www.educative.io/courses/grokking-the-coding-interview/g2w6QPBA2Nk
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char key) {
        int n = letters.length;

        int start = 0, end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (key < letters[mid]) {
                end = mid - 1;
            } else { //if (key >= letters[mid]) {
                start = mid + 1;
            }
        }
        // since the loop is running until 'start <= end', so at the end of the while loop, 'start == end+1'
        //Basically its for the last element
        return letters[start % n];
    }
}
