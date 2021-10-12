package org.atanu.java.ds.dp;

//https://leetcode.com/problems/2-keys-keyboard/
//LeetCode 650
public class TwoKeysKeyboard {

    /*
   As per the keyboard operations:
to get AA from A we need 2 additional steps (copy-all and then paste)
to get AAA from A we need 3 additional steps (copy-all, then paste, then again paste)

For generating AAAA we need 2 additional steps from AA.
however, to get AAAAAAAA, the most optimal way would be from AAAA, with 2 additional steps (copy-all then paste)
Essentially, we find the next smaller length sequence (than the one under consideration) which can be copied and then pasted over multiple times to generate the desired sequence. The moment we find a length that divides our required sequence length perfectly, then we don't need to check for any smaller length sequences.
   */
    public int minSteps(int n) {

        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            dp[i] = i;

            // if sequence of length 'j' can be pasted multiple times to get length 'i' sequence
            for (int j = i / 2; j > 1; j--) {
                // we just need to paste sequence j (i/j - 1) times, hence additional (i/j) times since we need to copy it first as well.
                // we don't need checking any smaller length sequences
                if (i % j == 0) {
                    dp[i] = dp[j] + (i / j);
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        TwoKeysKeyboard twoKeysKeyboard = new TwoKeysKeyboard();
        for (int N = 0; N <=20; N++) {
            System.out.println("Minimum number of operations to get the character 'A'" +
                    " exactly "+N+" time is "+ twoKeysKeyboard.minSteps(N));
        }

    }
}
