package com.examples.algorithms.graph;

import com.examples.datastructure.graph.Graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DephFirstPaths {

    private Boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DephFirstPaths(Graph graph, int source) {
        this.marked = new Boolean[graph.getNumVertices()];
        for (int i = 0; i < marked.length; i++)
            marked[i] = false;
        this.s = source;
        dfs(graph, source);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Deque<Integer> pathTo(int v) {
        Deque<Integer> path = new ArrayDeque<>();
        if (!hasPathTo(v)) return path;
        for (int w = v; w != this.s; w = edgeTo[w])
            path.push(w);
        path.push(this.s);
        return path;
    }

    // O(|V|+|E|)
    private void dfs(Graph graph, int v) {
        marked[v] = true;
        for (int w : graph.getAdjacents(v)) {
            if (!marked[v]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }
}
