package Collection;

public class UnionFindSet {
    // 按轶合并
    private int[] parents;
    private int[] ranks;

    public UnionFindSet(int n) {
        parents = new int[n];
        ranks = new int[n];

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
        return true;

    }

    public int Find(int u) {
        return parents[u] == u ? u : (parents[u] = Find(parents[u]));
    }


    private class UnionFind {
        // 路径压缩
        private int[] parent;
        private int count; // 联通对数

        public int getCount() {
            return count;
        }

        public UnionFind(int n) {
            this.count = n;
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            count --;
        }
    }
}
