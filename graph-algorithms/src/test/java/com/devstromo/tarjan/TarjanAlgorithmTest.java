package com.devstromo.tarjan;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TarjanAlgorithmTest {

    @Test
    public void testTarjanAlgorithm() {
        var vertex1 = new Vertex("1");
        var vertex2 = new Vertex("2");
        var vertex3 = new Vertex("3");
        var vertex4 = new Vertex("4");
        var vertex5 = new Vertex("5");
        var vertex6 = new Vertex("6");
        var vertex7 = new Vertex("7");
        var vertex8 = new Vertex("8");

        vertex1.addNeighbor(vertex2);

        vertex2.addNeighbor(vertex3);
        vertex2.addNeighbor(vertex5);
        vertex2.addNeighbor(vertex6);

        vertex3.addNeighbor(vertex4);
        vertex3.addNeighbor(vertex7);

        vertex4.addNeighbor(vertex8);
        vertex4.addNeighbor(vertex3);

        vertex5.addNeighbor(vertex1);
        vertex5.addNeighbor(vertex6);

        vertex6.addNeighbor(vertex7);
        vertex7.addNeighbor(vertex6);
        vertex8.addNeighbor(vertex4);
        vertex8.addNeighbor(vertex7);

        var graph = new ArrayList<Vertex>();
        graph.add(vertex6);
        graph.add(vertex7);
        graph.add(vertex5);
        graph.add(vertex1);
        graph.add(vertex2);
        graph.add(vertex3);
        graph.add(vertex4);
        graph.add(vertex8);

        var algorithm = new TarjanAlgorithm(graph);
        algorithm.run();
        algorithm.showComponents();
    }

}