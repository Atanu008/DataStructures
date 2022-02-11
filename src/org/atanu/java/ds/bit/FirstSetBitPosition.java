package org.atanu.java.ds.bit;

public class FirstSetBitPosition {

    //get the position
    public static int getFirstSetBitPos(int n) {
        int rightmostSetBit = 1;
        int count = 0;
        while (true) {
            if(((rightmostSetBit & n) != 0)) {
                return count; // Return rightmostSetBit for actual value
            }
            rightmostSetBit = rightmostSetBit << 1;
            count++;
        }
        //return count;
    }

    //Get the number
    public int getSetBitNumber(int n) {
        // get the rightmost bit that is '1'
        int rightmostSetBit = 1;
        while ((rightmostSetBit & n) == 0) {
            rightmostSetBit = rightmostSetBit << 1;
        }
        return rightmostSetBit;
    }

    public static void main(String[] args) {

        System.out.println("First setbit position for number: 18 is -> " + getFirstSetBitPos(18));
        System.out.println("First setbit position for number: 5 is -> " + getFirstSetBitPos(5));
        System.out.println("First setbit position for number: 32 is -> " + getFirstSetBitPos(32));
    }
}
