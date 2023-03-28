package com.devstromo.maximum_flow;

public class Edge {
    private Vertex from;
    private Vertex target;
    private final double capacity;
    private double flow;

    public Edge(Vertex from, Vertex target, double capacity) {
        this.from = from;
        this.target = target;
        this.capacity = capacity;
        this.flow = 0;
    }

    public Edge(Edge edge) {
        this.from = edge.getFrom();
        this.target = edge.getTarget();
        this.capacity = edge.getCapacity();
        this.flow = edge.getFlow();
    }

    public Vertex getFrom() {
        return from;
    }

    public void setFrom(Vertex from) {
        this.from = from;
    }

    public Vertex getTarget() {
        return target;
    }

    public void setTarget(Vertex target) {
        this.target = target;
    }

    public double getCapacity() {
        return capacity;
    }

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public Vertex getOther(Vertex vertex) {
        if (vertex == from)
            return target;
        return from;
    }

    public double getResidualCapacity(Vertex vertex) {
        if (vertex == from) {
            return flow; // backward edge
        }
        return capacity - flow; // forward edge
    }

    public void addResidualFlowTo(Vertex vertex, double delteFlow) {
        if (vertex == from) {
            flow = flow - delteFlow; // backward edge
        } else {
            flow = flow + delteFlow; // forward edge
        }

    }

    @Override
    public String toString() {
        return from + "-" + target + " " + from + "/" + capacity;
    }
}
