package com.devstromo.dag_longest_path;

import static java.lang.Integer.MAX_VALUE;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    // shortest path from the source vertex to actual vertex
    private int minDistance;
    // the previous node in the shortest path
    private Vertex predecessor;
    private final List<Edge> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.minDistance = MAX_VALUE;
        this.adjacencyList = new ArrayList<>();
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

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public List<Edge> getNeighbors() {
        return adjacencyList;
    }

    public void addNeighbor(Edge edge) {
        this.adjacencyList.add(edge);
    }

    public void addNeighbor(Vertex target, int weight) {
        this.adjacencyList.add(new Edge(target, weight));
    }

    @Override
    public String toString() {
        return name + " - " + predecessor;
    }
}
