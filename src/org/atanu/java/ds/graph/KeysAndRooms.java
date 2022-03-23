package org.atanu.java.ds.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/keys-and-rooms/
//LeetCode 841
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Set<Integer> distinctKeys = new HashSet<>();
        dfs(0, distinctKeys, rooms);
        //Once we traverse distinctKeys will have keys of all the rooms that we could visited
        // If we have all the keys then we can visit all the rooms . otherwise false
        return distinctKeys.size() == rooms.size();
    }

    public void dfs(int key, Set<Integer> distinctKeys, List<List<Integer>> rooms) {

        if(distinctKeys.contains(key)){
            return;
        }

        distinctKeys.add(key);

        for(int roomKey : rooms.get(key)) {
            dfs(roomKey, distinctKeys, rooms);
        }
    }
}
