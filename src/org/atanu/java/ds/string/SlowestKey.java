package org.atanu.java.ds.string;

//https://leetcode.com/problems/slowest-key/description/
//Leetcode 1629
public class SlowestKey {
    public char slowestKey(int[] releaseTimes, String keysPressed) {

        char slowestKey = keysPressed.charAt(0);
        int slowestKeyPressedDuration = releaseTimes[0];

        for(int i = 1; i < releaseTimes.length; i++){
            int difference = releaseTimes[i] - releaseTimes[i-1];

            if(difference > slowestKeyPressedDuration
                    || (difference == slowestKeyPressedDuration && keysPressed.charAt(i) > slowestKey)){
                slowestKey = keysPressed.charAt(i);
                slowestKeyPressedDuration = difference;
            }
        }

        return slowestKey;
    }

    public static void main(String[] args) {
        int[]releaseTimes = {9,29,49,50};
        String keysPressed = "cbcd";
        SlowestKey slowestKey = new SlowestKey();
        //Output: "c"
        //Explanation: The keypresses were as follows:
        //Keypress for 'c' had a duration of 9 (pressed at time 0 and released at time 9).
        //Keypress for 'b' had a duration of 29 - 9 = 20 (pressed at time 9 right after the release of the previous character and released at time 29).
        //Keypress for 'c' had a duration of 49 - 29 = 20 (pressed at time 29 right after the release of the previous character and released at time 49).
        //Keypress for 'd' had a duration of 50 - 49 = 1 (pressed at time 49 right after the release of the previous character and released at time 50).
        //The longest of these was the keypress for 'b' and the second keypress for 'c', both with duration 20.
        //'c' is lexicographically larger than 'b', so the answer is 'c'.
        System.out.println(slowestKey.slowestKey(releaseTimes, keysPressed));
    }
}
