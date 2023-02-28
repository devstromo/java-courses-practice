package com.devstromo.kruskal;

public record Edge(double weight, Vertex start, Vertex target) implements Comparable<Edge> {
    @Override
    public int compareTo(Edge other) {
        // compare edge based on the weight
        return Double.compare(this.weight, other.weight);
    }
}