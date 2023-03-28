package com.devstromo.maximum_flow;

import java.util.ArrayList;
import java.util.List;

public class FlowNetwork {

    private int numOfVertices;
    private int numOfEdges;
    private List<List<Edge>> adjacenciesList;

    public FlowNetwork(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.numOfEdges = 0;
        this.adjacenciesList = new ArrayList<>();
        for (int i = 0; i < numOfVertices; i++) {
            var edges = new ArrayList<Edge>();
            adjacenciesList.add(edges);
        }
    }

    public int getNumOfVertices() {
        return this.numOfVertices;
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public void addEdge(Edge edge) {
        var v = edge.getFrom();
        var w = edge.getTarget();
        adjacenciesList.get(v.getId())
          .add(edge);
        adjacenciesList.get(w.getId())
          .add(edge);
        numOfEdges++;
    }

    public List<Edge> getAdjacenciesList(Vertex vertex) {
        return adjacenciesList.get(vertex.getId());
    }
}
