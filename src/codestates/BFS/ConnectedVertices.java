package codestates.BFS;

import java.util.*;

public class ConnectedVertices {
    public static void main(String[] args) {
        int result1 = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {4, 5}
        });
        System.out.println(result1);

        int result2 = connectedVertices(new int[][]{
                {0, 1},
                {2, 3},
                {3, 4},
                {3, 5}
        });
        System.out.println(result2); // 2
    }

    public static int connectedVertices(int[][] edges) {
        // TODO:
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        Set<Integer> check = new HashSet<>();
        int max = 0;

        for (int i = 0; i < edges.length; i++){
            max = Math.max(Math.max(edges[i][0],edges[i][1]), max);
        }

        for (int i = 0; i < max + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;
        for(int i = 0; i < max; i++) {
            if(!check.contains(i)) {
                dfs(i, check, max, graph);
                count++;
            }
        }
        if(count == 0) {
            return 1;
        }

        return count;
    }

    public static void dfs(int n, Set<Integer> check, int max, ArrayList<ArrayList<Integer>> graph) {
        check.add(n);
        for(int j = 0; j <= max; j++) {
            if(graph.get(j).contains(n) && !check.contains(j)) {
                dfs(j, check, max, graph);
            }
        }
    }
}
