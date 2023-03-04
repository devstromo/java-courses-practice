package com.devstromo.kosaraju_algorithm;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Vertex> vertexList;
    private List<Edge> edgeList;

    public Graph() {
        this.vertexList = new ArrayList<>();
        this.edgeList = new ArrayList<>();
    }

    public Graph(List<Vertex> vertexList, List<Edge> edgeList) {
        this.vertexList = vertexList;
        this.edgeList = edgeList;
    }

    public List<Vertex> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Vertex> vertexList) {
        this.vertexList = vertexList;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    // this is how we transpose a given G(V,E) graph
    public Graph getTransposedGraph() {
        Graph transposedGraph = new Graph();
        // the transposed G'(V,E) contains the exact same vertices
        var transposedList = new ArrayList<Vertex>(this.vertexList);

        // revert the edges (A-C will be C-A)
        for (var edge : edgeList) {
            transposedList.get(edge.target()
                .getId())
              .addNeighbor(edge.start());
        }

        transposedGraph.setVertexList(transposedList);

        return transposedGraph;
    }
}
