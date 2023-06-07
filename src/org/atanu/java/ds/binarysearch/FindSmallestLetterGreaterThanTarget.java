package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
//LeetCode 744
//https://www.educative.io/courses/grokking-the-coding-interview/g2w6QPBA2Nk
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char key) {
        int n = letters.length;

        int low = 0, high = n - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            // If letters[mid] > key , then its a possible answer. But need the minimum. Lets go left
            if (letters[mid] > key) {
                high = mid;
            } else { // letters[mid] <= key , no wat it can be present in left part , chek right part
                low = mid + 1;
            }
        }
        return letters[high] >= key ? letters[high] : letters[0];
    }
}
