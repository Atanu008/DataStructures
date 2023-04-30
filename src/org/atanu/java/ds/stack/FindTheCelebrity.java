package org.atanu.java.ds.stack;

// https://leetcode.com/problems/find-the-celebrity/description/
// Leetcode 277

// Video : https://www.youtube.com/watch?v=ZuJEDPU1iug

public class FindTheCelebrity {

    // In a nutshell

    // The first loop is to find the candidate as the author explains. In detail,
    // suppose the candidate after the first for loop is person k, it means 0 to k-1 cannot be the celebrity,
    // because they know a previous or current candidate. Also, since k knows no one between k+1 and n-1,
    // k+1 to n-1 can not be the celebrity either. Therefore, k is the only possible celebrity, if there exists one.

    //The remaining job is to check if k indeed does not know any other persons and all other persons know k.

    public int findCelebrity(int n) {

        // Lets assume candidate is 0th person
        int candidate = 0;

        for(int i = 1; i < n; i++){
            // if candidate knows i, then current candidate can not be the potential answer
            // i can , lets assign i to possible candidate
            if(knows(candidate, i)){
                candidate = i;
            }
        }

        // Now we have one candidate , that may not be the possible one
        // How from the left half(left part of the candidate index) there can person whom this candidate might know
        // So we need to check again all the member if they know this candidate.
        // if one does not know this its not the celebrity
        // Or this candidate does know someone in that case also its not a celebrity
        // So basiccaly from left of this candidate might know someone
        for(int i = 0; i < n; i++){
            if(i != candidate && ( !knows(i, candidate) || knows(candidate, i))){
                return -1;
            }
        }

        return candidate;
    }

    private boolean knows(int i, int candidate) {
        return true;
    }

}
