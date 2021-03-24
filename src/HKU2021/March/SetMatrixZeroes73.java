package HKU2021.March;

import org.junit.Test;

public class SetMatrixZeroes73 {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean rowZero = false;
        boolean colZero = false;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        rowZero = true;
                    }
                    if (j == 0) {
                        colZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < row; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < col; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (colZero) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        if (rowZero) {
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
    }

    @Test
    public void test73() {
        setZeroes(new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}});
    }
}
