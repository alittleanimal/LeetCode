package Collection.SpanningTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
    static int[][] graph;
    static List<Node> arr = new ArrayList<>();
    static int[] parents;
    static int[] rank;
    static int ans = 0;

    private static void unionRoot(Node node) {
        int xRoot = findRoot(node.x);
        int yRoot = findRoot(node.y);

        if (xRoot == yRoot) {
            return;
        } else {
            if (rank[xRoot] > rank[yRoot]) {
                parents[yRoot] = xRoot;
            } else if (rank[xRoot] < rank[yRoot]) {
                parents[xRoot] = yRoot;
            } else {
                parents[xRoot] = yRoot;
                rank[yRoot]++;
            }
            ans += node.val;
        }
    }

    private static int findRoot(int u) {
        return parents[u] == u ? u : (parents[u] = findRoot(parents[u]));

    }

    public static void main(String[] args) {
        int len = args.length;
        parents = new int[len];
        rank = new int[len];

        for (int i = 0; i < len; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        graph = new int[][]{
                {0, 6, 1, 5, 0, 0},
                {0, 0, 5, 0, 3, 0},
                {0, 0, 0, 5, 6, 4},
                {0, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 6},
                {0, 0, 0, 0, 0, 0}
        };

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (graph[i][j] != 0) {
                    arr.add(new Node(i, j, graph[i][j]));
                }
            }
        }
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
            Node node = arr.get(i);
            unionRoot(node);
        }
        System.out.println(ans);
    }
}

class Node implements Comparable<Node> {
    int x;
    int y;
    int val;

    public Node(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Node node) {
        return this.val - node.val;
    }
}
