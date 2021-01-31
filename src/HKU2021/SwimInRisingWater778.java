package HKU2021;

import org.junit.Test;

import java.util.*;

/**
 * 778. Swim in Rising Water
 */
public class SwimInRisingWater778 {

    /**
     * 并查集
     * <p>
     * 1.先构建各点之间的边列表edges。 其中由edge=[x,y,d]组成，d为点x与y之间的最大值
     * <p>
     * 2.根据边列表中的 各点的值 从小到大排序
     * <p>
     * 3.依次遍历edges， 并将各点进行连通， 当最左上与最左下 第一次连通时结束，输出当前加入的边长
     *
     * @param grid
     * @return
     */
    public int swimInWater(int[][] grid) {
        List<Integer[]> recordList = new ArrayList<>();
        recordList.add(new Integer[]{0, 0, 0});

        int row = grid.length;
        int col = grid[0].length;
        int size = row * col;
        int tempX, tempY;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                tempX = i + 1;
                tempY = j;
                addToRecordList(grid, recordList, row, col, tempX, tempY, i, j);

                tempX = i;
                tempY = j + 1;
                addToRecordList(grid, recordList, row, col, tempX, tempY, i, j);

                tempX = i;
                tempY = j - 1;
                addToRecordList(grid, recordList, row, col, tempX, tempY, i, j);
            }
        }

        Collections.sort(recordList, (o1, o2) -> {
            if (o1[2] > o2[2])
                return 1;
            else if (o1[2] < o2[2])
                return -1;

            return 0;
        });

        UnionFind unionFind = new UnionFind(size);

        for (Integer[] item : recordList) {
            unionFind.union(item[0], item[1]);
            if (unionFind.find(0) == unionFind.find(size - 1)) {
                return item[2];
            }

        }
        return -1;
    }

    private void addToRecordList(int[][] heights, List<Integer[]> recordList, int row, int col, int tempX, int tempY, int i, int j) {
        if (isValid(tempX, tempY, row, col)) {
            Integer[] tempIntArray = new Integer[]{i * col + j, tempX * col + tempY,
                    Math.max(heights[tempX][tempY], heights[i][j])};
            if (!recordList.contains(tempIntArray)) {
                recordList.add(tempIntArray);
            }
        }
    }

    private boolean isValid(int x, int y, int row, int col) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }


    @Test
    public void test778() {
        System.out.println(swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5},
                {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
//        System.out.println(minimumEffortPathBetterSol(new int[][]{{3, 2}, {1, 0}}));

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
