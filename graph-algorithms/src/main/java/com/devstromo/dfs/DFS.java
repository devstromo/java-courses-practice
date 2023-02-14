package com.devstromo.dfs;

import java.util.List;
import java.util.Stack;

public class DFS {

    public static void stack(List<Vertex> vertexList) {

        // it may happen that we have independent clusters
        for (var vertex : vertexList) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfsHelper(vertex);
            }
        }
    }

    public static void recursion(List<Vertex> vertexList) {

        // it may happen that we have independent clusters
        for (var vertex : vertexList) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfs(vertex);
            }
        }
    }

    private static void dfsHelper(Vertex rootVertex) {
        var stack = new Stack<Vertex>();

        stack.push(rootVertex);
        rootVertex.setVisited(true);
        while (!stack.isEmpty()) {
            var actualVertex = stack.pop();
            System.out.println(actualVertex);
            // consider all the neighbors
            for (var vertex : actualVertex.getAdjacencyList()) {
                if (!vertex.isVisited()) {
                    vertex.setVisited(true);
                    stack.add(vertex);
                }
            }
        }
    }

    private static void dfs(Vertex rootVertex) {
        System.out.println(rootVertex);
        for (var vertex : rootVertex.getAdjacencyList()) {
            if (!vertex.isVisited()) {
                vertex.setVisited(true);
                dfs(vertex);
            }
        }
    }
}
