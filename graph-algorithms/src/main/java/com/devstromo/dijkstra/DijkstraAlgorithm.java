package com.devstromo.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithm {

    public void computePath(Vertex source) {
        source.setDistance(0);

        //head
        var queue = new PriorityQueue<Vertex>();
        queue.add(source);

        while (!queue.isEmpty()) {
            var actualVertex = queue.poll();
            for (var edge : actualVertex.getAdjacencyList()) {
                var u = edge.startVertex();
                var v = edge.targetVertex();
                var distance = actualVertex.getDistance() + edge.getWeight();
                if (distance < v.getDistance()) {
                    //there is a shorter path to vertex v
                    // O(n) JAVA HEAP IMPLEMENTATION and of course O(logN) would be better
                    queue.remove(v);
                    v.setDistance(distance);
                    v.setPredecessor(actualVertex);
                    queue.add(v);
                }
            }
        }

    }

    public List<Vertex> getShortestPathTo(Vertex targetVertex) {
        var path = new ArrayList<Vertex>();
        for (var vertex = targetVertex; vertex != null; vertex = vertex.getPredecessor()) {
            path.add(vertex);
        }
        Collections.reverse(path);
        return path;
    }
}
