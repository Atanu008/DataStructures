package org.atanu.java.ds.design;

import java.util.HashMap;
import java.util.Map;

public class HitCounterUsingMap {

    Map<Integer, TimeStampHitCount> hitCountMap;
    public HitCounterUsingMap() {
        hitCountMap = new HashMap<>();
    }
    public void hit(int timeStamp) {
        int index = timeStamp % 300;
        TimeStampHitCount timeStampHit = hitCountMap.get(index);
        //If the time stamp encountered for the first time
        if(timeStampHit == null) {
            hitCountMap.put(index, new TimeStampHitCount(timeStamp, 1));
        }
        else {
            // If the its a new TimeStamp in same index;
            // suppose for Timestamp 5 we have entry. Now 305 has came. So we need to erase 5 and put 305
            // As it is exceeding 5 minutes
            if(timeStampHit.timeStamp != timeStamp){
                hitCountMap.put(index, new TimeStampHitCount(timeStamp, 1));
            }
            //Increment the Count for same timestamp
            else {
                ++timeStampHit.hitCount;
            }
        }
    }

    public int getHits(int timeStamp) {
        int result = 0;
        for(TimeStampHitCount timeStampInstance : hitCountMap.values()) {
            if(timeStamp - timeStampInstance.timeStamp < 300) {
                result += timeStampInstance.hitCount;
            }
        }
        System.out.println("Hits for "+timeStamp + " is "+ result);
        return result;
    }

    class TimeStampHitCount {
        int timeStamp;
        int hitCount;

        public TimeStampHitCount(int timeStamp, int hitCount){
            this.timeStamp = timeStamp;
            this.hitCount = hitCount;
        }
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
