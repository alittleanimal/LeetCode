package HKU2021;

import org.junit.Test;

/**
 * 566. Reshape the Matrix
 */
public class ReshapeTheMatrix566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;

        if (row * col != r * c)
            return nums;

        int[] recordArray = new int[r * c];
        int[][] returnNums = new int[r][c];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // M[i][j]=M[n*i+j]
                recordArray[i * col + j] = nums[i][j];
            }
        }

        for (int k = 0; k < r * c; k++) {
            // M[i] => M[n/i][n%i]
            returnNums[k / c][k % c] = recordArray[k];
        }
        return returnNums;
    }

    @Test
    public void test566() {
        int[][] result = matrixReshapeBetterSol(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public int[][] matrixReshapeBetterSol(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        int originalIndex = 0;

        if (row * col != r * c)
            return nums;

        int[][] returnNums = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                returnNums[i][j] = nums[originalIndex / col][originalIndex % col];
                originalIndex++;
            }
        }

        return returnNums;
    }
}
