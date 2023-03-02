package com.devstromo.prim_algorithm;

public record Edge(Vertex start, Vertex target, double weight) implements Comparable<Edge> {
    @Override
    public int compareTo(Edge other) {
        // compare edge based on the weight
        return Double.compare(this.weight, other.weight);
    }
}