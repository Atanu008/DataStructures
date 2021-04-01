package org.atanu.java.ds.design;

//LeetCode 362
//https://leetcode.com/problems/design-hit-counter/
public class HitCounter {

    int[] timeStamps = new int[300];
    int[] hits = new int[300];

    public void hit(int timeStamp) {
        int timeStampIndex = timeStamp%300;
        if(timeStamps[timeStampIndex] != timeStamp){
            timeStamps[timeStampIndex] = timeStamp;
            hits[timeStampIndex] = 1;
        }
        else {
            ++hits[timeStampIndex];
        }
    }

    public int getHits(int timeStamp) {
        int result = 0;
        for(int i = 0; i < 300; i++){
            if(timeStamp - timeStamps[i] < 300) {
                result += hits[i];
            }
        }
        System.out.println("Hits for "+timeStamp + " is "+ result);
        return result;
    }

    public static void main(String[] args) {

        HitCounter counter = new HitCounter();
        // hit at timestamp 1.
        counter.hit(1);
        //hit at timestamp 2.
        counter.hit(2);
        // hit at timestamp 3.
        counter.hit(3);
        // get hits at timestamp 4, should return 3.
        counter.getHits(4);
        // hit at timestamp 300.
        counter.hit(300);
        // get hits at timestamp 300, should return 4.
        counter.getHits(300);
        // get hits at timestamp 301, should return 3.
        counter.getHits(301);

        counter.getHits(500);

    }
}
