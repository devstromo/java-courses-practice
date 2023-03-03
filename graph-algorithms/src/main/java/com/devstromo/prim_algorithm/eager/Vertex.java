package com.devstromo.prim_algorithm.eager;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private String name;
    // shortest edge from the tree vertex to non-tree vertex
    private Edge minEdge;
    private boolean visited;
    // to detect whether heap is in need of refresh because of better weighted edge
    private double distance = Double.MAX_VALUE;

    private final List<Edge> adjacencies;

    public Vertex(String name) {
        this.name = name;
        this.adjacencies = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacencies() {
        return adjacencies;
    }

    public void addEdge(Edge edge) {
        this.adjacencies.add(edge);
    }

    public void addNeighbor(double weight, Vertex target) {
        this.adjacencies.add(new Edge(this, target, weight));
    }

    public Edge getMinEdge() {
        return minEdge;
    }

    public boolean isVisited() {
        return visited;
    }

    public double getDistance() {
        return distance;
    }

    public void setMinEdge(Edge minEdge) {
        this.minEdge = minEdge;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(this.distance, other.getDistance());
    }
}
