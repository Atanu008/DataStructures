package org.atanu.java.ds.backtracking;


//LeetCode 1688
//https://leetcode.com/problems/count-of-matches-in-tournament/
public class CountMatchesTournament {
    public int numberOfMatches(int n) {
        if(n < 2)
            return 0;
        if(n == 2)
            return 1;

        return (n %2) != 0 ?  (n - 1) / 2 + 1 +  numberOfMatches((n - 1) / 2) : n/2+ numberOfMatches(n/2);
    }

    //n teams, one match, one lose and eliminated.
    //The champion never lose, n - 1 other team lose.
    //So need n - 1 match.
    public int numberOfMatchesV2(int n) {
        return n -1; // :)
    }
    public static void main(String[] args) {
        CountMatchesTournament matchesTournament = new CountMatchesTournament();
        int result = matchesTournament.numberOfMatches(14);
        int resultv2 = matchesTournament.numberOfMatchesV2(14);

        System.out.println(result+" "+ resultv2);
    }
}
