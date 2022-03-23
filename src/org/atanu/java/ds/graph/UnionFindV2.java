package org.atanu.java.ds.graph;

import java.util.HashMap;
import java.util.Map;

public class UnionFindV2 {

    Map<String, String> root;
    Map<String, Integer> rank;

    public UnionFindV2() {
        root = new HashMap<>();
        rank = new HashMap<>();
    }

    public String find(String x) {
        //Initialize if first time
        if(!root.containsKey(x)) {
            root.put(x, x);
            rank.put(x, 1);
        }

        // if `x` is not the root
        if(!x.equals(root.get(x))) {
            root.put(x, find(root.get(x))); //Path Compression
        }

        return root.get(x);
    }

    public void union(String x, String y) {

        String rootX = find(x);
        String rootY = find(y);

        if(!rootX.equals(rootY)) {

            if (rank.get(rootX) > rank.get(rootY)) {
                root.put(rootY, rootX);
            }
            else if (rank.get(rootX) < rank.get(rootY)) {
                root.put(rootX, rootY);
            }
            else {
                root.put(rootY, rootX);
                rank.put(rootX, rank.get(rootX) + 1);
            }
        }
    }

}
