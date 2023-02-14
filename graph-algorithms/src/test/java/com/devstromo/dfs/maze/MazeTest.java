package com.devstromo.dfs.maze;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 *     integer 1 represents walls
 *     integer 2 is the starting point
 *     integer 3 is the destination (so this is what we are looking for)
 *     integer 0 represents the states we can consider (so the solution contains one or more 0 states)
 */
class MazeTest {

    @Test
    public void testMazeEscape() {
        int[][] map = new int[][] {
          { 1, 1, 1, 1, 1 },
          { 1, 2, 0, 1, 1 },
          { 1, 1, 0, 1, 1 },
          { 1, 1, 0, 0, 0 },
          { 1, 1, 1, 1, 3 },
        };
    }

    @Test
    public void testMazeEscapeSecond() {
        int[][] map = new int[][] {
          { 1, 1, 1, 1, 1, 1 },
          { 2, 1, 0, 0, 0, 0 },
          { 0, 1, 0, 1, 1, 0 },
          { 0, 1, 0, 1, 0, 0 },
          { 0, 1, 0, 1, 1, 0 },
          { 0, 0, 0, 1, 0, 0 },
        };

        Maze maze = new Maze(map, 1, 0);
        assertTrue(maze.findWay());
    }

    @Test
    public void testMazeEscapeNotSolution() {
        int[][] map = new int[][] {
          { 1, 1, 1, 1, 1, 1 },
          { 2, 1, 1, 1, 0, 1 },
          { 0, 0, 0, 1, 0, 1 },
          { 0, 0, 0, 1, 0, 0 },
          { 0, 0, 0, 1, 1, 0 },
          { 0, 0, 0, 1, 0, 0 },
        };

        Maze maze = new Maze(map, 1, 0);
        assertFalse(maze.findWay());
    }

}