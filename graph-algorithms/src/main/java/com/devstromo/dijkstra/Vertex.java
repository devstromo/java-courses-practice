package com.devstromo.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

    private String name;
    private boolean visited;
    private final List<Edge> adjacencyList;
    // distance from teh source
    private double distance;
    // previous vertex on the shortest path
    private Vertex predecessor;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbor(Edge edge) {
        this.adjacencyList.add(edge);
    }

    public void addNeighbor(double weight, Vertex target) {
        this.adjacencyList.add(new Edge(weight, this, target));
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }

    @Override
    public String toString() {
        return name + " - " + distance;
    }
}
