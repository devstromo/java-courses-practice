package com.devstromo.prim_algorithm.lazy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class LazyPrimsAlgorithm {

    // most of the operations have O(1) running time
    private final Set<Vertex> unvisited;

    private final List<Edge> mst;

    private final PriorityQueue<Edge> heap;
    private double fullCost;

    public LazyPrimsAlgorithm(List<Vertex> unvisited) {
        this.unvisited = new HashSet<>(unvisited);
        this.mst = new ArrayList<>();
        this.heap = new PriorityQueue<>();
    }

    public void run(Vertex vertex) {
        // remove the start vertex (source)
        unvisited.remove(vertex);

        // the algorithm terminates when we visit all the vertices
        while (!unvisited.isEmpty()) {
            // insert all the edges into the heap except for the
            // edges leading to already visited vertices
            for (var edge : vertex.getAdjacencyList()) {
                if (unvisited.contains(edge.target())) {
                    heap.add(edge);
                }
            }
            // get the minimum edge from the head in O(logE)
            var minEdge = heap.remove();
            // get another edge if the edge is leading to
            // an already visited vertex
            if (!unvisited.contains(minEdge.target())) {
                continue;
            }

            mst.add(minEdge);
            fullCost += minEdge.weight();

            // in the next iteration we consider the next vertex
            vertex = minEdge.target();
            unvisited.remove(vertex);
        }

    }

    public void printSolution() {
        System.out.println("Cost of MST: " + this.fullCost);
        for (var edge : this.mst) {
            System.out.println(edge.start() + "-" + edge.target());
        }
    }
}
