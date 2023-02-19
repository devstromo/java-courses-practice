package com.devstromo.dijkstra;

import org.junit.jupiter.api.Test;

class DijkstraAlgorithmTest {

    @Test
    public void testDijkstraAlgorithm() {
        var v0 = new Vertex("A");
        var v1 = new Vertex("B");
        var v2 = new Vertex("C");
        var v3 = new Vertex("D");
        var v4 = new Vertex("E");
        var v5 = new Vertex("F");
        var v6 = new Vertex("G");
        var v7 = new Vertex("H");

        v0.addNeighbor(5, v1);
        v0.addNeighbor(9, v4);
        v0.addNeighbor(8, v7);

        v1.addNeighbor(12, v2);
        v1.addNeighbor(15, v3);
        v1.addNeighbor(4, v7);

        v2.addNeighbor(3, v3);
        v2.addNeighbor(11, v6);

        v3.addNeighbor(9, v6);

        v4.addNeighbor(4, v5);
        v4.addNeighbor(20, v6);
        v4.addNeighbor(5, v7);

        v5.addNeighbor(1, v2);
        v5.addNeighbor(13, v7);

        v7.addNeighbor(7, v2);
        v7.addNeighbor(6, v5);

        var algorithm = new DijkstraAlgorithm();
        algorithm.computePath(v0);
        System.out.println(algorithm.getShortestPathTo(v6));
    }

}