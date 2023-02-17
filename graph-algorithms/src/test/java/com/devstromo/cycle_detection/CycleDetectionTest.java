package com.devstromo.cycle_detection;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CycleDetectionTest {

    @Test
    public void testCycleDetection() {
        var v0 = new Vertex("A");
        var v1 = new Vertex("B");
        var v2 = new Vertex("C");
        var v3 = new Vertex("D");
        var v4 = new Vertex("E");
        var v5 = new Vertex("F");
        // ADJ. LIST
        v0.addNeighbor(v2);
        v0.addNeighbor(v4);

        v2.addNeighbor(v1);
        v2.addNeighbor(v3);

        v4.addNeighbor(v5);

        v5.addNeighbor(v0);

        var graph = new ArrayList<Vertex>();
        graph.add(v0);
        graph.add(v1);
        graph.add(v2);
        graph.add(v3);
        graph.add(v4);
        graph.add(v5);

        var algorithm = new CycleDetection();
        algorithm.detectCycles(graph);
    }

}