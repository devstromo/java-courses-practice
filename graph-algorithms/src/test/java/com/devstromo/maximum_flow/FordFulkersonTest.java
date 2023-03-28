package com.devstromo.maximum_flow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FordFulkersonTest {

    @Test
    public void testFordFulkerson() {
        FlowNetwork flowNetwork = new FlowNetwork(4);

        Vertex vertex0 = new Vertex(0, "s");
        Vertex vertex1 = new Vertex(1, "A");
        Vertex vertex2 = new Vertex(2, "B");
        Vertex vertex3 = new Vertex(3, "t");

        List<Vertex> vertexList = new ArrayList<>();
        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);

        flowNetwork.addEdge(new Edge(vertex0, vertex1, 4));
        flowNetwork.addEdge(new Edge(vertex0, vertex2, 5));

        flowNetwork.addEdge(new Edge(vertex1, vertex3, 7));

        flowNetwork.addEdge(new Edge(vertex2, vertex1, 4));
        flowNetwork.addEdge(new Edge(vertex2, vertex3, 1));

        FordFulkerson fordFulkerson = new FordFulkerson(flowNetwork, vertex0, vertex3);

        System.out.println("Maximum flow is: " + fordFulkerson.getMaxFlow());
        assertEquals(8.0, fordFulkerson.getMaxFlow());
        // print min-cut
        System.out.println("Vertices in the min cut set: ");
        for (int v = 0; v < vertexList.size(); v++) {
            if (fordFulkerson.isInCut(v))
                System.out.print(vertexList.get(v) + " - ");
            ;
        }
    }

}