package com.devstromo.dfs;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class DFSTest {

    @Test
    void testStackDFS() {
        var v1 = new Vertex("A");
        var v2 = new Vertex("B");
        var v3 = new Vertex("C");
        var v4 = new Vertex("D");
        var v5 = new Vertex("E");

        var list = new ArrayList<Vertex>();
        v1.addNeighbor(v2);
        v1.addNeighbor(v3);

        v3.addNeighbor(v4);
        v4.addNeighbor(v5);

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);

        DFS.stack(list);
    }

    @Test
    void testDFS() {
        var v1 = new Vertex("A");
        var v2 = new Vertex("B");
        var v3 = new Vertex("C");
        var v4 = new Vertex("D");
        var v5 = new Vertex("E");

        var list = new ArrayList<Vertex>();
        v1.addNeighbor(v2);
        v1.addNeighbor(v3);

        v3.addNeighbor(v4);
        v4.addNeighbor(v5);

        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);

        DFS.recursion(list);
    }

}