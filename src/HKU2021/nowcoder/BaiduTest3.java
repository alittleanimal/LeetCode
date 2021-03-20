package HKU2021.nowcoder;

import java.util.*;

public class BaiduTest3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] table = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        System.out.println(Arrays.deepToString(table));

        BaiduTest3 test = new BaiduTest3();
        test.findPath(table);
    }

    public void findPath(int[][] heights) {
        List<Integer[]> recordList = new ArrayList<>();
        recordList.add(new Integer[]{0, 0, 0});

        int row = heights.length;
        int col = heights[0].length;
        int size = row * col;
        int tempX, tempY;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tempX = i + 1;
                tempY = j;
                if (isValid(tempX, tempY, row, col))
                    recordList.add(new Integer[]{i * col + j, tempX * col + tempY,
                            Math.abs(heights[tempX][tempY] - heights[i][j])});

                tempX = i;
                tempY = j + 1;
                if (isValid(tempX, tempY, row, col))
                    recordList.add(new Integer[]{i * col + j, tempX * col + tempY,
                            Math.abs(heights[tempX][tempY] - heights[i][j])});
            }
        }

        recordList.sort((o1, o2) -> {
            if (o1[2] > o2[2])
                return 1;
            else if (o1[2] < o2[2])
                return -1;

            return 0;
        });

        UnionFind unionFind = new UnionFind(size);
        int cost = 0;
        for (Integer[] item : recordList) {
            if (unionFind.find(0) == unionFind.find(size - 1))
                break;

            if (unionFind.union(item[0], item[1]))
                cost += item[2];
        }
        System.out.println(cost);
    }

    private boolean isValid(int x, int y, int row, int col) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }

    private static class UnionFind {
        int[] parents;

        public UnionFind(int size) {
            parents = new int[size];
            for (int i = 0; i < size; i++)
                parents[i] = i;
        }

        public int find(int index) {
            return index == parents[index] ? index : (parents[index] = find(parents[index]));
        }

        public boolean union(int a, int b) {
            int aFind = find(a);
            int bFind = find(b);
            if (aFind == bFind)
                return false;
            else
                parents[aFind] = bFind;
            return true;
        }
    }
}
