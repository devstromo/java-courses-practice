package com.devstromo.topologial_ordering;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

    private String name;
    private boolean visited;
    private final List<Vertex> neighborList;

    public Vertex(String name) {
        this.name = name;
        this.neighborList = new ArrayList<>();
    }

    public void addNeighbor(Vertex vertex) {
        neighborList.add(vertex);
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }

    public List<Vertex> getNeighborList() {
        return neighborList;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
