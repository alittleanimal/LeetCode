package HKU2021;

/**
 * 1579. Remove Max Number of Edges to Keep Graph Fully Traversable
 */
public class RemoveEdges1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFindSet unionFindSetA = new UnionFindSet(n + 1); // For type 1
        UnionFindSet unionFindSetB = new UnionFindSet(n + 1); // For type 2
        int res = 0;

        // Union type 3 first
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (!unionFindSetA.Union(edge[1], edge[2])) {
                    res++;
                }
                unionFindSetB.Union(edge[1], edge[2]);
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (!unionFindSetA.Union(edge[1], edge[2]))
                    res++;
            } else if (edge[0] == 2) {
                if (!unionFindSetB.Union(edge[1], edge[2]))
                    res++;
            }
        }

        if (unionFindSetA.edge != n - 1 || unionFindSetB.edge != n - 1) {
            return -1;
        }
        return res;

    }

    private static class UnionFindSet {
        private int[] parents;
        private int[] ranks;
        public int edge; // add edge to check traversable

        public UnionFindSet(int n) {
            parents = new int[n];
            ranks = new int[n];
            edge = 0;

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public boolean Union(int u, int v) {
            int pu = Find(u);
            int pv = Find(v);

            if (pu == pv)
                return false;
            if (ranks[pv] > ranks[pu])
                parents[pu] = pv;
            else if (ranks[pu] > ranks[pv])
                parents[pv] = pu;
            else {
                parents[pv] = pu;
                ranks[pu] += 1;
            }
            edge++;
            return true;

        }

        public int Find(int u) {
            return parents[u] == u ? u : (parents[u] = Find(parents[u]));
        }
    }
}


