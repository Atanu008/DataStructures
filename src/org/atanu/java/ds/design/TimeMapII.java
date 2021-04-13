package org.atanu.java.ds.design;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeMapII {
    Map<String, TreeMap<Integer, String>> timeMap;
    /** Initialize your data structure here. */
    public TimeMapII() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)){
            timeMap.put(key, new TreeMap<>());
        }
        timeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap;
        treeMap = timeMap.get(key);
        if(treeMap == null){
            return "";
        }
        Integer floorKey = treeMap.floorKey(timestamp);
        if(floorKey != null) {
            return treeMap.get(floorKey);
        }
        return "";
    }

    public static void main(String[] args) {
        TimeMapII kv = new TimeMapII();
        kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
        System.out.println(kv.get("foo", 1));  // output "bar"
        System.out.println(kv.get("foo", 3)); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
        kv.set("foo", "bar2", 4);
        System.out.println(kv.get("foo", 4)); // output "bar2"
        System.out.println(kv.get("foo", 5)); //output "bar2"
    }
}
