package org.atanu.java.ds.graph;

import java.util.*;

// https://leetcode.com/problems/throne-inheritance/description/
// Leetcode 1600

// Build Graph/Adjacency List using Map
// Use a Set to store the member(s) passed away to avoid the dead being on inheritance list;
// Use DFS to get the inheritance order.

public class ThroneInheritance {

    Map<String, List<String>> adjList;
    Set<String> notAlive;
    String kingName;
    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        adjList = new HashMap<>();
        notAlive = new HashSet<>();
    }

    public void birth(String parentName, String childName) {
        adjList.computeIfAbsent(parentName, val -> new ArrayList<>()).add(childName); // build the graph
    }

    public void death(String name) {
        notAlive.add(name); // mark not alive
    }

    public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<>();
        dfs(this.adjList, notAlive, this.kingName, inheritanceOrder);
        return inheritanceOrder;
    }

    private void dfs(Map<String, List<String>> adjList, Set<String> notAlive , String familyMember, List<String>inheritanceOrder){
        if(!notAlive.contains(familyMember)){
            inheritanceOrder.add(familyMember); // Add only alive ones in the inheritanceOrder
        }

        for(String child : adjList.getOrDefault(familyMember, new ArrayList<>())){
            dfs(adjList, notAlive, child, inheritanceOrder);
        }
    }
}
