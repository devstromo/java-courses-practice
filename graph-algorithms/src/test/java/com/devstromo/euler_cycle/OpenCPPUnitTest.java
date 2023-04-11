package com.devstromo.euler_cycle;

import org.junit.jupiter.api.Test;

class OpenCPPUnitTest {

    @Test
    public void testOpenCPPTest() {
        OpenCPP G = new OpenCPP(4); // create a graph of four vertices
        // add the arcs for the example graph
        G.addArc("a", 0, 1, 1)
          .addArc("b", 0, 2, 1)
          .addArc("c", 1, 2, 1)
          .addArc("d", 1, 3, 1)
          .addArc("e", 2, 3, 1)
          .addArc("f", 3, 0, 1);
        int besti = 0;
        float bestCost = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("Solve from " + i);
            float c = G.printCPT(i);
            System.out.println("Cost = " + c);
            if (i == 0 || c < bestCost) {
                bestCost = c;
                besti = i;
            }
        }

        G.printCPT(besti);
        System.out.println("Cost = " + bestCost);
    }

}