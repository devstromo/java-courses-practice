package com.devstromo.kosaraju_algorithm;

import java.util.Stack;

public class DepthFirstOrder {

    private Stack<Vertex> stack;

    public DepthFirstOrder(Graph graph) {
        stack = new Stack<>();
        for (var vertex : graph.getVertexList()) {
            if (!vertex.isVisited()) {
                dfs(vertex);
            }
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setVisited(true);

        for (var v : vertex.getAdjacencyList()) {
            if (!v.isVisited())
                dfs(v);
        }
        // after a node has been visited we push it
        // onto a stack (that will be processed)
        stack.push(vertex);
    }

    public Stack<Vertex> getStack() {
        return stack;
    }
}
