package HKU2021.March;

import org.junit.Test;

public class SpiralMatrixII59 {
    public int[][] generateMatrix(int n) {
        int direction = 0;
        int[][] dirArray = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] matrix = new int[n][n];

        int count = 1;
        int i = 0, j = 0;
        int[] dir;
        while (count <= n * n) {
            matrix[i][j] = count;
            count++;

            dir = dirArray[direction % 4];
            i += dir[0];
            j += dir[1];
            if (i >= n || i < 0 || j >= n || j < 0 || matrix[i][j] != 0) {
                i -= dir[0];
                j -= dir[1];

                direction++;
                dir = dirArray[direction % 4];
                i += dir[0];
                j += dir[1];
            }
        }
        return matrix;
    }

    @Test
    public void test59() {
        generateMatrix(1);
    }

    public int[][] generateMatrixOther(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            // 更新边界：例如从左到右填完后，上边界 t += 1，相当于上边界向内缩 1。
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }
}
