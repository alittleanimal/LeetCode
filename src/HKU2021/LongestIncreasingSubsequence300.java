package HKU2021;

import org.junit.Test;

public class LongestIncreasingSubsequence300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    @Test
    public void test300() {
        System.out.println(lengthOfLIS(new int[]{7,7,7,7,7,7,7}));
    }
}
