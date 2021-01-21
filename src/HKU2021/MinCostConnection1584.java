package HKU2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1584. Min Cost to Connect All Points
 */
public class MinCostConnection1584 {

    public int minCostConnectPoints(int[][] points) {
        int[][] disRecord = new int[points.length][points.length];

        int[] currentPoint;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                currentPoint = points[i];
                disRecord[i][j] = manhattanDis(currentPoint, points[j]);
            }
        }

        List<Integer> connectedPoint = new ArrayList<>();
        boolean[] vis = new boolean[disRecord.length];
        int start = 0;
        int result = 0;
        for (int i = 0; i < disRecord.length - 1; i++) {
            connectedPoint.add(start);
            vis[start] = true;
            int val = Integer.MAX_VALUE;

            for (int pointItem : connectedPoint) {
                for (int j = 0; j < disRecord.length; j++) {
                    if (!vis[j]) {
                        if (disRecord[pointItem][j] < val && disRecord[pointItem][j] > 0) {
                            start = j;
                            val = disRecord[pointItem][j];
                        }
                    }
                }
            }
            result += val;

        }
        return result;
    }

    private int manhattanDis(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    @Test
    public void test1584() {
        int[][] points = new int[][]{{3,12},{-2,5},{-4,1}};
        System.out.println(minCostConnectPoints(points));
    }
}
