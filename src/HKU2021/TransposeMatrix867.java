package HKU2021;

/**
 * 867. Transpose Matrix
 */
public class TransposeMatrix867 {
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] TranMatrix = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                TranMatrix[i][j] = matrix[j][i];
            }
        }
        return TranMatrix;
    }
}
