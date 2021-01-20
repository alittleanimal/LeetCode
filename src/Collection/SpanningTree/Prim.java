package Collection.SpanningTree;

import java.util.ArrayList;
import java.util.List;

public class Prim {
    static int[][] graph;

    static List<Integer> arr = new ArrayList<>();
    static boolean[] vis;

    private static int prim(int start) {
        int ans = 0;
        for (int i = 0; i < 5; i++) {
            arr.add(start);
            vis[start] = true;
            int val = Integer.MAX_VALUE;

            for (int row : arr) {
                for (int j = 0; j < 6; j++) {
                    if (!vis[j]) {
                        if (graph[row][j] < val && graph[row][j] > 0) {
                            start = j;
                            val = graph[row][j];
                        }
                    }
                }
            }
            ans += val;
        }
        return ans;
    }

    public static void main(String[] args) {
        vis = new boolean[6];
        graph = new int[][]{
                {0, 6, 1, 5, 0, 0},
                {6, 0, 5, 0, 3, 0},
                {1, 5, 0, 5, 6, 4},
                {5, 0, 5, 0, 0, 2},
                {0, 3, 6, 0, 0, 6},
                {0, 0, 4, 2, 6, 0}
        };
        int ans = prim(0);
        System.out.println(ans);
    }
}
