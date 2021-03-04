package HKU2021.BackTracking;

import org.junit.Test;

public class UniqueDigits357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 10;
        int sumK;
        for (int i = 2; i < n + 1; i++) {
            sumK = 9;
            for (int j = 9; j >= 9 - i + 2; j--) {
                sumK *= j;
            }
            dp[i] = dp[i-1] + sumK;
        }
        return dp[n];
    }

    @Test
    public void test357() {
        System.out.println(countNumbersWithUniqueDigits(3));
    }
}
