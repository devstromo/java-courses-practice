package com.devstromo.dag_longest_path;

import static java.lang.Math.abs;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class LongestPathTest {

    @Test
    public void testLongestPath() {
        // we use negative weights in order to find the longest path based on the shortest path algorithm
        var graph = new ArrayList<Vertex>();
        var v0 = new Vertex("S");
        var v1 = new Vertex("A");
        var v2 = new Vertex("B");
        var v3 = new Vertex("C");
        var v4 = new Vertex("D");
        var v5 = new Vertex("E");

        v0.addNeighbor(v1, -1);
        v0.addNeighbor(v3, -2);

        v1.addNeighbor(v2, -6);

        v2.addNeighbor(v4, -1);
        v2.addNeighbor(v5, -2);

        v3.addNeighbor(v1, -4);
        v3.addNeighbor(v4, -3);

        v4.addNeighbor(v5, -1);

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        var longestPath = new ShortestPath(graph);
        longestPath.compute();
        for (var vertex : graph) {
            System.out.println("Distance from S to " + vertex.getName() + ": " + abs(vertex.getMinDistance()) + " - " + vertex.getPredecessor());
        }
    }

}