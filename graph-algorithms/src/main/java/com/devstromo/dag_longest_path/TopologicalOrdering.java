package com.devstromo.dag_longest_path;

import java.util.List;
import java.util.Stack;

public class TopologicalOrdering {

    private final Stack<Vertex> stack;

    public TopologicalOrdering(List<Vertex> graph) {
        this.stack = new Stack<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!graph.get(i)
              .isVisited()) {
                dfs(graph.get(i));
            }
        }
    }

    public void dfs(Vertex vertex) {
        vertex.setVisited(true);
        // all the neighbors in a DFS manner
        for (var edge : vertex.getNeighbors())
            if (!edge.target()
              .isVisited())
                dfs(edge.target());

        stack.push(vertex);
    }

    public Stack<Vertex> stack() {
        return this.stack;
    }
}
