package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/evaluate-division/description/
//Leetcode 399
public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);

        double[] result = new double[queries.size()];
        int i = 0;
        for(List<String> query : queries) {

            String start = query.get(0);
            String end = query.get(1);


            if(!graph.containsKey(start) || !graph.containsKey(end)){
                result[i++] = -1;
            }
            else if(start.equals(end)){
                result[i++] = 1;
            }
            else{
                Set<String> visited = new HashSet<>();
                result[i++] = dfs(graph, start, end, visited);
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited){

        if(graph.get(start).containsKey(end)){
            return graph.get(start).get(end);
        }

        visited.add(start);
        for(Map.Entry<String, Double> entry : graph.get(start).entrySet()) {

            if(visited.contains(entry.getKey())) continue;
            double result = dfs(graph, entry.getKey(), end, visited);
            if(result != -1.0){
                return result*entry.getValue();
            }
        }

        return -1.0;

    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {

            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            double div = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, div);

            graph.putIfAbsent(b, new HashMap<>());
            graph.get(b).put(a, 1/div);
        }

        return graph;
    }
}
