package com.devstromo.kosaraju_algorithm;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private int id;
    private String name;
    private boolean visited;
    private final List<Vertex> adjacencyList;
    // assign an integer to every single vertex in the G graph
    private int componentId;

    public Vertex(int id, String name) {
        this.id = id;
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public int getId() {
        return id;
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

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void addNeighbor(Vertex vertex) {
        this.adjacencyList.add(vertex);
    }

    public int getComponentId() {
        return componentId;
    }

    public void setComponentId(int componentId) {
        this.componentId = componentId;
    }

    @Override
    public String toString() {
        return name;
    }
}
