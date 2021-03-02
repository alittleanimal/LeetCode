package HKU2021.March;

/**
 * 304. Range Sum Query 2D - Immutable
 */
public class RangeSumQuery2DImmutable {
    private int[][] dp;

    public RangeSumQuery2DImmutable(int[][] matrix) {
        if (matrix.length == 0)
            return;

        dp = new int[matrix.length][matrix[0].length + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length + 1; j++) {
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = dp[i][j - 1] + matrix[i][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += dp[i][col2 + 1] - dp[i][col1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{}};
        RangeSumQuery2DImmutable rs = new RangeSumQuery2DImmutable(matrix);
        System.out.println(rs.sumRegion(2, 1, 4, 3));
        System.out.println(rs.sumRegion(1, 1, 2, 2));
        System.out.println(rs.sumRegion(1, 2, 2, 4));
    }
}
