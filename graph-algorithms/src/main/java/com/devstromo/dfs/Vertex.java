package com.devstromo.dfs;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private String name;
    private boolean visited;
    private final List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex vertex) {
        adjacencyList.add(vertex);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
