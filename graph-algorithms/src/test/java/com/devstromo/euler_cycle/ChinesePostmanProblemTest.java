package com.devstromo.euler_cycle;

import org.junit.jupiter.api.Test;

class ChinesePostmanProblemTest {

    @Test
    public void testChinesePostmanProblem() {
        // create a graph of four vertices
        ChinesePostmanProblem G = new ChinesePostmanProblem(4);
        // add the arcs for the example graph
        G.addArc("a", 0, 1, 1)
          .addArc("b", 0, 2, 1)
          .addArc("c", 1, 2, 1)
          .addArc("d", 1, 3, 1)
          .addArc("e", 2, 3, 1)
          .addArc("f", 3, 0, 1);
        G.solve(); // find the CPT
        G.printCPT(0); // print it, starting from vertex 0
        System.out.println("Cost = " + G.cost());
    }

}