package com.devstromo.kruskal;

public class Node {
    // a unique index for each node in the tree
    private int id;
    // the approximate count of the nodes below this node
    private int height;
    private Node parent;

    public Node(int id, int height, Node parent) {
        this.id = id;
        this.height = height;
        this.parent = parent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }
}
