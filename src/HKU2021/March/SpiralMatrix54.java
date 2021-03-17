package HKU2021.March;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int direction = 0;
        int[][] dirArray = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> res = new ArrayList<>();

        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0, j = 0;
        int[] dir;
        while (res.size() < row * col) {
            res.add(matrix[i][j]);
            dir = dirArray[direction % 4];
            i += dir[0];
            j += dir[1];
            if (i >= row || i < 0 || j >= col || j < 0 || res.contains(matrix[i][j])) {
                i -= dir[0];
                j -= dir[1];

                direction++;
                dir = dirArray[direction % 4];
                i += dir[0];
                j += dir[1];
            }
        }
        return res;
    }

    @Test
    public void test54() {
        System.out.println(spiralOrder(new int[][]{{1,2}}));
    }
}
