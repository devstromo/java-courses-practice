package com.devstromo.prim_algorithm.lazy;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;

    private final List<Edge> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbor(Edge edge) {
        this.adjacencyList.add(edge);
    }

    public void addNeighbor(double weight, Vertex target) {
        this.adjacencyList.add(new Edge(this, target, weight));
    }

    @Override
    public String toString() {
        return name;
    }
}
