package collection;

public class ShortestPath {

    /**
     * @param graph The adjacency matrix of the graph
     * @param n     The number of the vertex
     * @return
     */
    public int[][] floyd(int[][] graph, int n) {
        int[][] edge = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                edge[i][j] = graph[i][j];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (edge[i][j] > edge[i][k] + edge[k][j]) {
                        edge[i][j] = edge[i][k] + edge[k][j];
                    }
                }
            }
        }
        return edge;
    }

    public int[] dijsktra(int[][] edge) {
        int vartex = edge.length;
        int flag = 0;
        int[] mark = new int[vartex];
        mark[0] = 1;

        int[] distance = new int[vartex];

        for (int i = 0; i < vartex; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < vartex; j++) {
                if (mark[j] == 0 && distance[j] < min) {
                    min = distance[j];
                    flag = j;
                }
            }
            mark[flag] = 1;
            for (int k = 0; k < vartex; k++) {
                if (distance[k] > distance[flag] + edge[flag][k]) {
                    distance[k] = distance[flag] + edge[flag][k];
                }
            }
        }

        return distance;
    }
}
