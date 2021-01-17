package HKU2021;

import org.junit.Test;

/**
 * 1232. Check If It Is a Straight Line
 */
public class StraightLine1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        double[] parameter = calculateEquation(coordinates[0][0], coordinates[0][1], coordinates[1][0], coordinates[1][1]);
        if (parameter.length == 0) {
            int tempX = coordinates[0][0];
            for (int i = 2; i < coordinates.length; i++) {
                if (tempX != coordinates[i][0]) return false;
            }
            return true;
        }

        for (int i = 2; i < coordinates.length; i++) {
            if (!verifyLine(parameter, coordinates[i][0], coordinates[i][1]))
                return false;
        }
        return true;
    }

    private double[] calculateEquation(int x1, int y1, int x2, int y2) {
        if (x1 == x2) {
            return new double[0];
        }
        double[] res = new double[2];
        res[0] = ((double) y2 - (double) y1) / (x2 - x1);
        res[1] = y1 - res[0] * x1;
        return res;
    }

    private boolean verifyLine(double[] parameter, int x, int y) {
        return y == parameter[0] * x + parameter[1];
    }

    // compare the slope
    public boolean checkStraightLineBetterSol(int[][] coordinates) {
        if (coordinates.length == 2) return true;

        for (int i = 2; i < coordinates.length; i++) {
            int x0 = coordinates[0][0];
            int x1 = coordinates[1][0];
            int y0 = coordinates[0][1];
            int y1 = coordinates[1][1];

            // avoid dividend equals to zero, change to multiplication
            if (((y1 - y0) * (coordinates[i][0] - x0)) != ((coordinates[i][1] - y0) * (x1 - x0)))
                return false;
        }
        return true;
    }

    @Test
    public void test1232() {
        int[][] coordinates = new int[][]{{2, 1}, {4, 2}, {6, 3}};
        System.out.println(checkStraightLineBetterSol(coordinates));
    }
}
