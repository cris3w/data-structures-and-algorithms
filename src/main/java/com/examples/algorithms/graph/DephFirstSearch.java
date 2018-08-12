package com.examples.algorithms.graph;

import com.examples.datastructure.graph.Graph;

public class DephFirstSearch {

    private Boolean[] marked;
    private int count;

    public DephFirstSearch(Graph graph, int source) {
        this.marked = new Boolean[graph.getNumVertices()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        this.count = 0;
        dfs(graph, source);
    }

    // O(|V|+|E|)
    private void dfs(Graph graph, int v) {
        this.count++;
        this.marked[v] = true;
        for (int w : graph.getAdjacents(v)) {
            if (!marked[v]) {
                dfs(graph, w);
            }
        }
    }
}
