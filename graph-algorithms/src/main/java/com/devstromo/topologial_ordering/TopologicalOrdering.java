package com.devstromo.topologial_ordering;

import java.util.Stack;

public class TopologicalOrdering {

    private final Stack<Vertex> stack;

    public TopologicalOrdering() {
        this.stack = new Stack<>();
    }

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);
        // all the neighbors in a DFS manner
        for (var v : vertex.getNeighborList())
            if (!v.isVisited())
                dfs(v);

        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return this.stack;
    }
}
