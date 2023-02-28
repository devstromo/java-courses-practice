package com.devstromo.kruskal;

import java.util.ArrayList;
import java.util.List;

public class DisjointSet {

    public DisjointSet(List<Vertex> vertexList) {
        makeSets(vertexList);
    }

    // find the representative (root node) for node 'node'
    public Node find(Node node) {
        var actual = node;
        // find the representative
        while (actual.getParent() != null) {
            actual = actual.getParent();
        }

        // "path compression" to make sure that next time we look for
        // the representative of the node we have O(1)
        Node root = actual;
        actual = node;

        while (actual != root) {
            var temp = actual.getParent();
            actual.setParent(root);
            actual = temp;
        }
        return root;
    }

    // combine two sets
    public void union(Node node1, Node node2) {
        var root1 = find(node1);
        var root2 = find(node2);
        if (root1 == root2) {
            return;
        }

        // attach the smaller tree to the root of the larger tree "union by height"
        if (root1.getHeight() < root2.getHeight()) {
            root1.setParent(root2);
        } else if (root1.getHeight() > root2.getHeight()) {
            root2.setParent(root1);
        } else {
            root2.setParent(root1);
            root1.setHeight(root1.getHeight() + 1);
        }

    }

    private void makeSets(List<Vertex> vertexList) {
        for (var vertex : vertexList) {
            makeSet(vertex);
        }
    }

    private void makeSet(Vertex vertex) {
        var node = new Node(0, null);
        vertex.setNode(node);
    }
}
