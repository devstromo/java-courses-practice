package com.devstromo.arbitrage_on_forex;

import java.util.ArrayList;
import java.util.List;

public class BellmanFordAlgorithm {

    private final List<Vertex> vertexList;
    private final List<Edge> edges;
    private final List<Vertex> cycleList;

    public BellmanFordAlgorithm(List<Vertex> vertexList, List<Edge> edges) {
        this.vertexList = vertexList;
        this.edges = edges;
        this.cycleList = new ArrayList<>();
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
                    var vertex = edge.start();
                    while (!vertex.equals(edge.target())) {
                        this.cycleList.add(vertex);
                        vertex = vertex.getPredecessor();
                    }
                    this.cycleList.add(edge.target());
                    return;
                }
            }
        }
    }

    private boolean hasCycle(Edge edge) {
        return edge.start()
          .getDistance() + edge.weight() < edge.target()
          .getDistance();
    }

    public void printCycle() {
        if (this.cycleList != null) {
            for (Vertex vertex : this.cycleList) {
                System.out.println(vertex);
            }
        } else {
            System.out.println("No arbitrage opportunity...");
        }
    }
}
