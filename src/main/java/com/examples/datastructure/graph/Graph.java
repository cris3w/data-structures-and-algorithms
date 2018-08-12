package com.examples.datastructure.graph;

import com.examples.datastructure.exceptions.ErrorInvalidAccess;

import java.util.*;

// UNDIRECTED GRAPH

public class Graph {

    private int numVertices;
    private int numEdges;
    private HashMap<Integer, LinkedList<Integer>> adjacency;

    public Graph(int v) {
        this.numVertices = v;
        this.numEdges = 0;
        this.adjacency = new HashMap<>();
    }

    public int getNumVertices() {
        return this.numVertices;
    }

    public int getNumEdges() {
        return this.numEdges;
    }

    public void putEdge(int v, int w) throws ErrorInvalidAccess {
        if (v >= this.numVertices || w >= this.numVertices)
            throw new ErrorInvalidAccess();
        this.numEdges++;
        this.adjacency.get(v).push(w);
        this.adjacency.get(w).push(v);
    }

    public LinkedList<Integer> getAdjacents(int v) {
        return this.adjacency.get(v);
    }
}
