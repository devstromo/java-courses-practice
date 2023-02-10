package com.devstromo;

import org.junit.jupiter.api.Test;

class VertexTest {

    @Test
    public void testAdjacencyMatrix() {
        int[][] adjacencyMatrix = { { 0, 2, 4, 0 }, { 0, 0, 0, 3 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, };
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    System.out.println("Edge with weight: " + adjacencyMatrix[i][j]);
                }
            }
        }
        //if you know the vertices then the lookup is O(1) quite fast
        System.out.println(adjacencyMatrix[0][2]);

        // adjacency list representation
        var a = new Vertex("A");
        var b = new Vertex("B");
        var c = new Vertex("C");
        var d = new Vertex("D");

        a.addNeighbor(b);
        a.addNeighbor(c);
        b.addNeighbor(d);

        // print all neighbors
        a.showNeighbor();
        b.showNeighbor();
        c.showNeighbor();
        d.showNeighbor();
    }
}