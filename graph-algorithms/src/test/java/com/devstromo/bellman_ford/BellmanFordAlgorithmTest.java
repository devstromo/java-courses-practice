package com.devstromo.bellman_ford;

import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BellmanFordAlgorithmTest {

    @Test
    @Disabled("Infinite loop")
    public void testBellmanFordAlgorithmInfiniteCycle() {
        var vertexList = new ArrayList<Vertex>();
        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));

        var edges = new ArrayList<Edge>();

        edges.add(new Edge(5, vertexList.get(0), vertexList.get(1)));
        edges.add(new Edge(2, vertexList.get(1), vertexList.get(2)));
        edges.add(new Edge(-10, vertexList.get(2), vertexList.get(0)));

        var algorithm = new BellmanFordAlgorithm(vertexList, edges);
        algorithm.run(vertexList.get(0));
        algorithm.shortestPathTo(vertexList.get(2));
    }

    @Test
    public void testBellmanFordAlgorithm() {
        var vertexList = new ArrayList<Vertex>();
        vertexList.add(new Vertex("A"));
        vertexList.add(new Vertex("B"));
        vertexList.add(new Vertex("C"));

        var edges = new ArrayList<Edge>();

        edges.add(new Edge(5, vertexList.get(0), vertexList.get(1)));
        edges.add(new Edge(2, vertexList.get(1), vertexList.get(2)));
        edges.add(new Edge(10, vertexList.get(2), vertexList.get(0)));

        var algorithm = new BellmanFordAlgorithm(vertexList, edges);
        algorithm.run(vertexList.get(0));
        algorithm.shortestPathTo(vertexList.get(2));
    }

    @Test
    public void testBellmanFordAlgorithmOther() {
        var v0 = new Vertex("A");
        var v1 = new Vertex("B");
        var v2 = new Vertex("C");
        var v3 = new Vertex("D");
        var v4 = new Vertex("E");
        var v5 = new Vertex("F");
        var v6 = new Vertex("G");
        var v7 = new Vertex("H");

        var vertexList = new ArrayList<Vertex>();
        vertexList.add(v0);
        vertexList.add(v1);
        vertexList.add(v2);
        vertexList.add(v3);
        vertexList.add(v4);
        vertexList.add(v5);
        vertexList.add(v6);
        vertexList.add(v7);

        var edges = new ArrayList<Edge>();

        edges.add(new Edge(5, v0, v1));
        edges.add(new Edge(9, v0, v4));
        edges.add(new Edge(8, v0, v7));

        edges.add(new Edge(12, v1, v2));
        edges.add(new Edge(15, v1, v3));
        edges.add(new Edge(4, v1, v7));

        edges.add(new Edge(3, v2, v3));
        edges.add(new Edge(11, v2, v6));

        edges.add(new Edge(9, v3, v6));

        edges.add(new Edge(4, v4, v5));
        edges.add(new Edge(20, v4, v6));
        edges.add(new Edge(5, v4, v7));

        edges.add(new Edge(1, v5, v2));
        edges.add(new Edge(13, v5, v7));

        edges.add(new Edge(7, v7, v2));
        edges.add(new Edge(6, v7, v5));


        var algorithm = new BellmanFordAlgorithm(vertexList, edges);
        algorithm.run(vertexList.get(0));
        algorithm.shortestPathTo(vertexList.get(6));
    }

}