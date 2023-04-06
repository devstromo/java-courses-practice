package com.devstromo.travelling_salesman_problem;


import org.junit.jupiter.api.Test;

class TravellingSalesmanProblemTest {


    @Test
    public void testTravellingSalesmanProblem(){
        // adjacency matrix (graph)
        int[][] graph = {{0, 1, 0, 0, 1},
          {1, 0, 1, 1, 0},
          {0, 1, 0, 1, 1},
          {0, 1, 1, 0, 1},
          {1, 0, 1, 1, 0}};


        var tsp = new TravellingSalesmanProblem(graph);
        // starting vertex has index 0
        // 1 we start with the first iteration
        // cost is equals to 0
        tsp.solve(0, 1, 0);
        tsp.show();
    }
}