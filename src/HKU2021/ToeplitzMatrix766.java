package HKU2021;

import org.junit.Test;

/**
 * 766. Toeplitz Matrix
 */
public class ToeplitzMatrix766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 1 || matrix[0].length == 1) return true;

        int col = matrix.length, row = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int ni = i, nj = 0;
            while (nj < col - 1 && ni < row - 1) {
                ni++;
                nj++;
                if (matrix[0][i] != matrix[nj][ni])
                    return false;
            }
        }

        for (int j = 0; j < col; j++) {
            int ni = 0, nj = j;
            while (nj < col - 1 && ni < row - 1) {
                ni++;
                nj++;
                if (matrix[j][0] != matrix[nj][ni])
                    return false;
            }
        }

        return true;
    }

    @Test
    public void test766() {
        System.out.println(isToeplitzMatrixBetterSol(new int[][]{{58,25,63}, {30,0,25}, {90,30,58}}));
    }

    public boolean isToeplitzMatrixBetterSol(int[][] matrix) {
        if (matrix.length == 1 || matrix[0].length == 1) return true;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                // 判断：前行中除最后一个元素外剩余的元素,完全等于后行中除第一个元素外剩余的元素
                if (matrix[i][j] != matrix[i + 1][j + 1])
                    return false;
            }
        }
        return true;
    }
}
