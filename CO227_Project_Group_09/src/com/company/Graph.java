package com.company;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 12/1/2016.
 * This class used to catch all node in graph
 */
public class Graph {

    private  Node [] graph;

    @Override
    public String toString() {
        return "Graph{" +
                "graph=" + Arrays.toString(graph) +
                '}';
    }

    public Node[] getGraph() {
        return graph;
    }

    public void setGraph(Node[] graph) {
        this.graph = graph;
    }

    public HashMap convertToHashmap(){
        HashMap<String,Node> nodeHashMap = new HashMap<>();

        for (int i=0;i<graph.length;i++){
            nodeHashMap.put(graph[i].getName(),graph[i]);
        }
        return  nodeHashMap;
    }

    public String firstNode(){
        return  graph[0].getName();
    }
}
