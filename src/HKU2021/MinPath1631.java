package HKU2021;

import org.junit.Test;

import java.util.*;

/**
 * 1631. Path With Minimum Effort
 */
public class MinPath1631 {

    public int minimumEffortPath(int[][] heights) {
        LinkedList<LinkedList<String>> recordList = new LinkedList<>();

        int size = heights.length;
        recordList.add(new LinkedList<>(Arrays.asList("00")));
        String currentItem;
        int tempInt;
        String tempStr;
        String endStr = (size - 1) + String.valueOf(size - 1);
        LinkedList<LinkedList<String>> resultList = new LinkedList<>();
        while (!recordList.isEmpty()) {
            LinkedList<String> currentList = recordList.removeFirst();
            currentItem = currentList.getLast();
            tempInt = Integer.parseInt(currentItem.split("")[0]) + 1;
            if (tempInt < size) {
                LinkedList tempList = new LinkedList(currentList);
                tempStr = String.valueOf(tempInt) + currentItem.charAt(1);
                tempList.add(tempStr);
                if (tempStr.equals(endStr)) {
                    resultList.add(tempList);
                    continue;
                }
                recordList.add(tempList);
            }
            tempInt = Integer.valueOf(currentItem.split("")[1]) + 1;
            if (tempInt < size) {
                tempStr = currentItem.charAt(0) + String.valueOf(tempInt);
                currentList.add(tempStr);
                if (tempStr.equals(endStr)) {
                    resultList.add(currentList);
                    continue;
                }
                recordList.add(currentList);
            }
        }
        return 0;
    }

    /**
     * 并查集
     *
     * 1.先构建各点之间的边列表edges。 其中由edge=[x,y,d]组成，d为点x与y差的绝对值
     *
     * 2.根据边列表中的 各点差的绝对值 从小到大排序
     *
     * 3.依次遍历edges， 并将各点进行连通， 当最左上与最左下 第一次连通时结束，并输出 所遍历过edges中的最大d
     *
     * @param heights
     * @return
     */
    public int minimumEffortPathBetterSol(int[][] heights) {
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
                cost = Math.max(cost, item[2]);
        }
        return cost;
    }

    private boolean isValid(int x, int y, int row, int col) {
        return 0 <= x && x < row && 0 <= y && y < col;
    }


    @Test
    public void test1631() {
        System.out.println(minimumEffortPathBetterSol(new int[][]{{1,2,4}, {1,3,1}, {1,2,1}}));
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
