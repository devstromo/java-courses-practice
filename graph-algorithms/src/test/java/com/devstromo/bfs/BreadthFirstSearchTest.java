package com.devstromo.bfs;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class BreadthFirstSearchTest {

    @Test
    void testBFS() {
        var a = new Vertex("A");
        var b = new Vertex("B");
        var c = new Vertex("C");
        var d = new Vertex("D");
        var e = new Vertex("E");
        var f = new Vertex("F");
        var g = new Vertex("G");
        var h = new Vertex("H");

        a.addNeighbor(b);
        a.addNeighbor(f);
        a.addNeighbor(g);

        b.addNeighbor(a);
        b.addNeighbor(c);
        b.addNeighbor(d);

        c.addNeighbor(b);

        d.addNeighbor(b);
        d.addNeighbor(e);

        f.addNeighbor(a);

        g.addNeighbor(a);
        g.addNeighbor(h);

        h.addNeighbor(g);

        var result = BreadthFirstSearch.traverse(a);
        assertArrayEquals(new String[]{"A", "B", "F", "G", "C", "D", "H", "E"}, result.toArray());
    }

}