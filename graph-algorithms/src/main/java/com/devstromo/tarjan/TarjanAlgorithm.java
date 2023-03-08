package com.devstromo.tarjan;

import static java.lang.Math.min;

import java.util.List;
import java.util.Stack;

public class TarjanAlgorithm {

    private final List<Vertex> graph;
    // we have to track the vertices in the same SCC
    private final Stack<Vertex> stack;

    private int index;
    // it will track the integer representation of the SCCs
    private int sccCounter;

    public TarjanAlgorithm(List<Vertex> graph) {
        this.graph = graph;
        this.stack = new Stack<>();
    }

    public void run() {
        for (var vertex : graph) {
            if (!vertex.isVisited())
                dfs(vertex);
        }
    }

    private void dfs(Vertex vertex) {
        vertex.setIndex(index);
        vertex.setLowLink(index);
        index++;

        vertex.setVisited(true);
        stack.add(vertex);
        vertex.setOnStack(true);

        for (var v : vertex.getAdjacencyList()) {
            if (!v.isVisited()) {
                dfs(v);
                // after dfs we have to update the low links
                vertex.setLowLink(min(vertex.getLowLink(), v.getLowLink()));
            } else if (v.isOnStack()) {
                vertex.setLowLink(min(vertex.getIndex(), v.getLowLink()));
            }
        }
        // this is what we have to check
        // we have found the root of the scc
        if (vertex.getIndex() == vertex.getLowLink()) {
            while (true) {
                var w = stack.pop();
                w.setOnStack(false);
                w.setComponentId(sccCounter);
                if (w == vertex)
                    break;
            }
            sccCounter++;
        }
    }

    public void showComponents() {
        graph.forEach(System.out::println);
    }
}
