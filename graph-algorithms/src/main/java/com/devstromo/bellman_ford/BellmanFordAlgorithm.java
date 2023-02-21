package com.devstromo.bellman_ford;

import java.util.List;

public class BellmanFordAlgorithm {

    private final List<Vertex> vertexList;
    private final List<Edge> edges;

    public BellmanFordAlgorithm(List<Vertex> vertexList, List<Edge> edges) {
        this.vertexList = vertexList;
        this.edges = edges;
    }

    // Bellman-Ford algorithm
    public void run(Vertex source) {
        source.setDistance(0);

        // V-1 iterations (in worst-case the longest path contains V)
        for (var i = 0; i < vertexList.size() - 1; i++) {
            //RELAXATION
            for (var edge : edges) {
                var u = edge.start();
                var v = edge.target();
                var distance = u.getDistance() + edge.weight(); // distance[u] + w
                if (distance < v.getDistance()) {
                    v.setDistance(distance);
                    v.setPredecessor(u);
                }
            }
        }

        // if we make an additional relaxation and there is a shorter paths
        // then we know that there is a negative cycle in the network
        for (var edge : edges) {
            if (edge.start()
              .getDistance() != Double.MAX_VALUE) {
                if (hasCycle(edge)) {
                    System.out.println("There is a negative cycle...");
                    return;
                }
            }
        }
    }

    public void shortestPathTo(Vertex vertex) {
        if (vertex.getDistance() == Double.MAX_VALUE) {
            System.out.println("There is no path from source to the given vertex...");
            return;
        }

        var actual = vertex;
        while (actual.getPredecessor() != null) {
            System.out.println(actual);
            actual = actual.getPredecessor();
        }
    }

    private boolean hasCycle(Edge edge) {
        return edge.start()
          .getDistance() + edge.weight() < edge.target()
          .getDistance();
    }
}
