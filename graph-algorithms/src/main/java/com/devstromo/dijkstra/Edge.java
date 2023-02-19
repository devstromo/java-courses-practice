package com.devstromo.dijkstra;

public class Edge {

    private final double weight;
    private final Vertex start;
    private final Vertex target;

    public Edge(double weight, Vertex start, Vertex target) {
        this.weight = weight;
        this.start = start;
        this.target = target;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex startVertex() {
        return start;
    }

    public Vertex targetVertex() {
        return target;
    }
}
