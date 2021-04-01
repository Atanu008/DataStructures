package org.atanu.java.ds.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TimeMap {
    class Pair {
        String value;
        int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> timeMap;
    /** Initialize your data structure here. */
    public TimeMap() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair timeEntry = new Pair(value, timestamp);
        timeMap.putIfAbsent(key, new ArrayList<>());
        timeMap.get(key).add(timeEntry);
    }

    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }
        List<Pair> times = timeMap.get(key);
        return binarySearch(times, timestamp);
    }

    public String binarySearch(List<Pair> times, int timestamp) {
        int low = 0;
        int high = times.size() -1;
        String resultVal = "";
        while(low <= high) {
            int mid = low + (high - low)/2;
            Pair midPair = times.get(mid);
            if(midPair.timestamp == timestamp) {
                resultVal = midPair.value;
                return resultVal;
            }
            else if(midPair.timestamp < timestamp) {
                low = mid + 1;
                resultVal = midPair.value; // As we need maximum value lesser than TimeStamp
            }
            else {
                high = mid -1;
            }
        }

        return resultVal;

    }

    public static void main(String[] args) {
        TimeMap kv = new TimeMap();
        kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
        System.out.println(kv.get("foo", 1));  // output "bar"
        System.out.println(kv.get("foo", 3)); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
        kv.set("foo", "bar2", 4);
        System.out.println(kv.get("foo", 4)); // output "bar2"
        System.out.println(kv.get("foo", 5)); //output "bar2"
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */