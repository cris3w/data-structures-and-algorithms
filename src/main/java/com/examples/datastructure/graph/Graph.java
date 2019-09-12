package com.examples.datastructure.graph;

import java.util.*;

public class Graph { // UNDIRECTED GRAPH

    private int vertexs;
    private int edges;
    private HashMap<Integer, LinkedList<Integer>> adjacency;

    public Graph(int v) {
        this.vertexs = v;
        this.edges = 0;
        this.adjacency = new HashMap<>();
    }

    public int getVertexs() {
        return this.vertexs;
    }

    public int getEdges() {
        return this.edges;
    }

    public void putEdge(int v, int w) {
        if (v >= this.vertexs || w >= this.vertexs)
            throw new IllegalArgumentException("Node not found");
        this.edges++;
        this.adjacency.get(v).push(w);
        this.adjacency.get(w).push(v);
    }

    public LinkedList<Integer> getAdjacents(int v) {
        return this.adjacency.get(v);
    }
}
