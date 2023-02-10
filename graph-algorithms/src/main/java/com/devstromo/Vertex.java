package com.devstromo;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private final String name;
    private final List<Vertex> adjacencyList;

    public Vertex(String name) {
        this.name = name;
        this.adjacencyList = new ArrayList<>();
    }

    public void addNeighbor(Vertex vertex) {
        adjacencyList.add(vertex);
    }

    public void showNeighbor() {
        adjacencyList.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return name;
    }
}
