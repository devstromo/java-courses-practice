package com.devstromo.euler_cycle;

import java.util.Vector;

class OpenCPP {

    class Arc {

        String lab;

        int u, v;

        float cost;

        Arc(String lab, int u, int v, float cost) {
            this.lab = lab;
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    Vector<Arc> arcs = new Vector<Arc>();

    int N;

    OpenCPP(int vertices) {
        N = vertices;
    }

    OpenCPP addArc(String lab, int u, int v, float cost) {
        if (cost < 0)
            throw new Error("Graph has negative costs");
        arcs.addElement(new Arc(lab, u, v, cost));
        return this;
    }

    float printCPT(int startVertex) {
        ChinesePostmanProblem bestGraph = null, g;
        float bestCost = 0, cost;
        int i = 0;
        do {
            g = new ChinesePostmanProblem(N + 1);
            for (int j = 0; j < arcs.size(); j++) {
                Arc it = arcs.elementAt(j);
                g.addArc(it.lab, it.u, it.v, it.cost);
            }
            cost = g.basicCost;
            g.findUnbalanced(); // initialise g.neg on original graph
            g.addArc("'virtual start'", N, startVertex, cost);
            g.addArc("'virtual end'",
              // graph is Eulerian if neg.length=0
              g.neg.length == 0 ? startVertex : g.neg[i], N, cost);
            g.solve();
            if (bestGraph == null || bestCost > g.cost()) {
                bestCost = g.cost();
                bestGraph = g;
            }
        }

        while (++i < g.neg.length);
        System.out.println("Open CPT from " + startVertex + " (ignore virtual arcs)");
        bestGraph.printCPT(N);
        return cost + bestGraph.phi();
    }
}