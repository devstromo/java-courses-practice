package com.devstromo.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearch {
    public static List<String> traverse(Vertex root) {
        var queue = new LinkedList<Vertex>();
        var list = new ArrayList<String>();
        root.setVisited(true);
        queue.add(root);
        while (!queue.isEmpty()) {
            var vertex = queue.poll();
            list.add(vertex.getName());
            for (var neighbor : vertex.getAdjacencyList()) {
                if (!neighbor.isVisited()) {
                    neighbor.setVisited(true);
                    queue.add(neighbor);
                }
            }
        }
        return list;
    }
}
