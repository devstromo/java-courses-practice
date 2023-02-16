package com.devstromo.topologial_ordering.shortest_path;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ShortestPathTest {

    @Test
    public void testTopologicalOrderingShortestPath() {
        var graph = new ArrayList<Vertex>();
        var v0 = new Vertex("S");
        var v1 = new Vertex("A");
        var v2 = new Vertex("B");
        var v3 = new Vertex("C");
        var v4 = new Vertex("D");
        var v5 = new Vertex("E");

        v0.addNeighbor(new Edge(v1, 1));
        v0.addNeighbor(new Edge(v3, 2));

        v1.addNeighbor(new Edge(v2, 6));

        v2.addNeighbor(new Edge(v4, 1));
        v2.addNeighbor(new Edge(v5, 2));

        v3.addNeighbor(new Edge(v1, 4));
        v3.addNeighbor(new Edge(v4, 3));

        v4.addNeighbor(new Edge(v5, 1));

        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        var algorithm = new ShortestPath(graph);
        algorithm.compute();
        for (var vertex : graph) {
            System.out.println("Distance from S to " + vertex.getName() + ": " + vertex.getMinDistance() + " - " + vertex.getPredecessor());
        }
    }

}