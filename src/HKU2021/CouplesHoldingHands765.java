package HKU2021;

import org.junit.Test;

/**
 * 765. Couples Holding Hands
 */
public class CouplesHoldingHands765 {
    public int minSwapsCouples(int[] row) {
        int[] originalSeat = new int[row.length];

        for (int i = 0; i < row.length; i++) {
            originalSeat[row[i]] = i;
        }

        int count = 0;
        int realCoupleSeat, couple;
        for (int j = 0; j < row.length - 1; j++) {
            couple = findCouple(row[j]);
            if (couple != row[j + 1]) {
                realCoupleSeat = originalSeat[couple];
                originalSeat[couple] = j + 1;
                originalSeat[row[j + 1]] = realCoupleSeat;
                row[realCoupleSeat] = row[j + 1];
                count++;
            }
            j++;
        }

        return count;
    }

    private int findCouple(int item) {
        if (item % 2 == 0)
            return item + 1;
        else
            return item - 1;
    }

    @Test
    public void test765() {
        System.out.println(minSwapsCouplesUnionFind(new int[]{3, 0, 2, 4, 1, 5}));
    }

    public int minSwapsCouplesUnionFind(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i + 1] / 2);
        }
        return N - unionFind.getCount();
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
            count--;
        }
    }
}
