package com.devstromo.prim_algorithm.eager;

import java.util.List;
import java.util.PriorityQueue;

public class EagerPrimsAlgorithm {

    private List<Vertex> vertexList;
    private PriorityQueue<Vertex> heap;

    public EagerPrimsAlgorithm(List<Vertex> vertexList) {
        this.vertexList = vertexList;
        this.heap = new PriorityQueue<>();
    }

    public void run(Vertex vertex) {
        vertex.setDistance(0);
        heap.add(vertex);
        while (!heap.isEmpty()) {
            var v = heap.remove();
            scanVertex(v);
        }
    }

    private void scanVertex(Vertex vertex) {
        vertex.setVisited(true);
        // consider all the edges of the given vertex
        for (var edge : vertex.getAdjacencies()) {
            var w = edge.target();
            // we do not want to revisit already visited vertices
            if (w.isVisited())
                continue;
            // there is a "shorter path" to the unvisited vertex set
            // from the visited vertex cluster
            if (edge.weight() < w.getDistance()) {
                w.setDistance(edge.weight());
                w.setMinEdge(edge);
                if (this.heap.contains(w)) {
                    this.heap.remove(w);
                }
                this.heap.add(w);
            }
        }
    }

    public void printSolution() {
        var cost = 0.0D;

        for (var vertex : vertexList) {
            if (vertex.getMinEdge() != null) {
                var edge = vertex.getMinEdge();
                System.out.println("Edge: " + edge);
                cost += edge.weight();
            }
        }
        System.out.println("Cost of the MST: " + cost);
    }
}
