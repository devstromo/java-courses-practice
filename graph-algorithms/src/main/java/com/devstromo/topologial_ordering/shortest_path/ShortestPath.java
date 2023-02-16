package com.devstromo.topologial_ordering.shortest_path;

import java.util.List;

public class ShortestPath {

    private final TopologicalOrdering topologicalOrdering;

    public ShortestPath(List<Vertex> graph) {
        this.topologicalOrdering = new TopologicalOrdering(graph);
        graph.get(0)
          .setMinDistance(0);
    }

    public void compute() {
        var topologicalOrder = topologicalOrdering.stack();
        while (!topologicalOrder.isEmpty()) {
            var u = topologicalOrder.pop();
            for (var edge : u.getNeighbors()) {
                var v = edge.target();
                if (v.getMinDistance() > u.getMinDistance() + edge.weight()) {
                    v.setMinDistance(u.getMinDistance() + edge.weight());
                    v.setPredecessor(u);
                }
            }
        }
    }

}
