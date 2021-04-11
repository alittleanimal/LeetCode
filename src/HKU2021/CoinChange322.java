package HKU2021;

import org.junit.Test;

import java.util.Arrays;

public class CoinChange322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int Max = amount + 1;
        Arrays.fill(dp, Max);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    @Test
    public void test322() {
        System.out.println(coinChange(new int[]{2}, 3));
    }
}
