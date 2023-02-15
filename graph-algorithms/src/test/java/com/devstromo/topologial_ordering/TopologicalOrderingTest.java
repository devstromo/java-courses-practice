package com.devstromo.topologial_ordering;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TopologicalOrderingTest {

    @Test
    public void testTopologicalOrdering() {
        var ordering = new TopologicalOrdering();
        var graph = new ArrayList<Vertex>();
        graph.add(new Vertex("0"));
        graph.add(new Vertex("1"));
        graph.add(new Vertex("2"));
        graph.add(new Vertex("3"));
        graph.add(new Vertex("4"));
        graph.add(new Vertex("5"));

        graph.get(2)
          .addNeighbor(graph.get(3));

        graph.get(3)
          .addNeighbor(graph.get(1));

        graph.get(4)
          .addNeighbor(graph.get(0));
        graph.get(4)
          .addNeighbor(graph.get(1));

        graph.get(5)
          .addNeighbor(graph.get(0));
        graph.get(5)
          .addNeighbor(graph.get(2));

        // consider all teh vertices
        for (int i = 0; i < graph.size(); i++) {
            if (!graph.get(i)
              .isVisited()) {
                ordering.dfs(graph.get(i));
            }
        }

        var stack = ordering.getStack();
        for (int i = 0; i < graph.size(); i++) {
            System.out.println(stack.pop());

        }
    }

}