package HKU2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> returnList = new ArrayList<>();
        returnList.add(1);
        if (rowIndex == 0) {
            return returnList;
        }
        if (rowIndex == 1) {
            returnList.add(1);
            return returnList;
        }

        List<Integer> lastList = getRow(rowIndex - 1);
        for (int i = 0; i < lastList.size() - 1; i++) {
            returnList.add(lastList.get(i) + lastList.get(i + 1));
        }
        returnList.add(1);
        return returnList;
    }

    public List<Integer> getRowDP(int rowIndex) {
        Integer[][] dp = new Integer[rowIndex + 1][rowIndex + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            dp[i][0] = dp[i][i] = 1;
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return Arrays.asList(dp[rowIndex]);
    }

    public List<Integer> getRowDPSaveSpace(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        dp[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            Integer[] cur = dp.clone();
            dp[0] = dp[i] = 1;
            for (int j = 1; j < i; j++) {
                dp[j] = cur[j - 1] + cur[j];
            }
        }
        return Arrays.asList(dp);
    }

    @Test
    public void test119() {
        System.out.println(getRowDPSaveSpace(5));
    }
}
