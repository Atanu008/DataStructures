package org.atanu.java.ds.array;

public class JumpGame {

    public static boolean canJumpTillEnd(int[] arr) {

        int maxJumpCan = 0;
        //run till end and if not enough to go to next
        for (int i = 0; i < arr.length && i <= maxJumpCan; i++) {

            maxJumpCan = Math.max(maxJumpCan, i + arr[i]);

            if (maxJumpCan >= arr.length - 1)
                return true;
        }

        return maxJumpCan >= arr.length - 1;
    }

    public static void main(String[] args) {

        int[] arr = {2, 0, 0, 1, 1, 2, 3};

        System.out.println(canJumpTillEnd(arr));

    }

}
