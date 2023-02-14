package com.devstromo.dfs.maze;

public class Maze {

    private final int[][] maze;
    private final boolean[][] visited;

    private final int startRow;
    private final int startCol;

    public Maze(int[][] maze, int startRow, int startCol) {
        this.maze = maze;
        this.visited = new boolean[maze.length][maze.length];
        this.startRow = startRow;
        this.startCol = startCol;
    }

    public boolean findWay() {
        if (dfs(startRow, startCol)) {
            return true;
        }
        return false;
    }

    private boolean dfs(int x, int y) {
        // base case
        if (x == maze.length - 1 && y == maze.length - 1) {
            return true;
        }

        if (isFeasible(x, y)) {
            visited[x][y] = true;
            // then we have to visit the next cells(U,D,L,R)
            // going down
            if (dfs(x + 1, y)) {
                return true;
            }
            // going up
            if (dfs(x - 1, y)) {
                return true;
            }
            // going to the right
            if (dfs(x, y + 1)) {
                return true;
            }
            // going to the left
            if (dfs(x + 1, y - 1)) {
                return true;
            }
            // backtrack
            visited[x][y] = false;
        }
        return false;
    }

    private boolean isFeasible(int x, int y) {
        // we check vertical dimension
        if (x < 0 || x > maze.length - 1)
            return false;
        // we check horizontal dimension
        if (y < 0 || y > maze.length - 1)
            return false;
        // when we have already considered that state
        if (visited[x][y])
            return false;
        //there is an obstacle in the way
        if (maze[x][y] == 1)
            return false;
        return true;
    }
}
