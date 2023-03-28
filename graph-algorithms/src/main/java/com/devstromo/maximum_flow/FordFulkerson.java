package com.devstromo.maximum_flow;

import static java.lang.Math.min;

import java.util.LinkedList;

public class FordFulkerson {
    private boolean[] marked;//marked[v.getId()]=true s-> v in the residual graph
    private Edge[] edgeTo; // edgeTo[v] = edges in the augmenting path
    private double valueMaxFlow;

    public FordFulkerson(FlowNetwork flowNetwork, Vertex source, Vertex target) {
        while (hasAugmentingPath(flowNetwork, source, target)) {
            var minValue = Double.POSITIVE_INFINITY;
            for (var v = target; v != source; v = edgeTo[v.getId()].getOther(v)) {
                minValue = min(minValue, edgeTo[v.getId()].getResidualCapacity(v));
            }

            for (var v = target; v != source; v = edgeTo[v.getId()].getOther(v)) {
                edgeTo[v.getId()].addResidualFlowTo(v, minValue);
            }
            valueMaxFlow = valueMaxFlow + minValue;
        }
    }

    public boolean isInCut(int index) {
        return marked[index];
    }

    public double getMaxFlow() {
        return this.valueMaxFlow;
    }

    private boolean hasAugmentingPath(FlowNetwork flowNetwork, Vertex source, Vertex target) {
        edgeTo = new Edge[flowNetwork.getNumOfVertices()];
        marked = new boolean[flowNetwork.getNumOfVertices()];
        var queue = new LinkedList<Vertex>();
        queue.add(source);
        marked[source.getId()] = true;
        while (!queue.isEmpty() && !marked[target.getId()]) {
            var v = queue.remove();
            for (var edge : flowNetwork.getAdjacenciesList(v)) {
                var w = edge.getOther(v);
                if (edge.getResidualCapacity(w) > 0) {
                    if (!marked[w.getId()]) {
                        edgeTo[w.getId()] = edge;
                        marked[w.getId()] = true;
                        queue.add(w);
                    }
                }
            }
        }
        // if true there is a path
        return marked[target.getId()];
    }
}
