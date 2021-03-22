package HKU2021.LeetCodeCampus;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming {
    // 3. 无重复字符的最长子串
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }

        int count = 0;
        int recordI = 0, recordJ = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (j - i + 1 > count) {
                        count = j - i + 1;
                        recordI = i;
                        recordJ = j;
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(recordI, recordJ + 1);
    }

    // 53. 最大子序和
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }

        int count = Integer.MIN_VALUE, temp;
        int recordI = 0, recordJ = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                temp = dp[j + 1] - dp[i];
                if (temp > count) {
                    count = temp;
                    recordI = i;
                    recordJ = j;
                }
            }
        }

        int sum = 0;
        for (int i = recordI; i < recordJ + 1; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public int maxSubArray2(int[] nums) {
        int len = nums.length;
        int pre = nums[0];

        int max = nums[0];
        for (int i = 1; i < len; i++) {
            pre = Math.max(pre, nums[i]);
            max = Math.max(pre, max);
        }

        return max;
    }

    // 42. 接雨水
    public int trap(int[] height) {
        int len = height.length;
        if (len < 3)
            return 0;

        int[] leftHighest = new int[len];
        leftHighest[0] = height[0];
        int[] rightHighest = new int[len];
        rightHighest[len - 1] = height[len - 1];

        for (int i = 1; i < height.length; i++) {
            leftHighest[i] = Math.max(height[i], leftHighest[i - 1]);
        }

        for (int j = len - 2; j >= 0; j--) {
            rightHighest[j] = Math.max(height[j], rightHighest[j + 1]);
        }

        int count = 0, currMax;
        for (int i = 1; i < height.length - 1; i++) {
            currMax = Math.min(leftHighest[i], rightHighest[i]);
            if (currMax > height[i]) {
                count += currMax - height[i];
            }
        }

        return count;
    }

    // 1014. 最佳观光组合
    public int maxScoreSightseeingPair(int[] values) {
        int maxLeft = values[0];
        int ans = 0;
        for (int i = 1; i < values.length; i++) {
            if ((maxLeft + values[i] - i) > ans) {
                ans = maxLeft + values[i] - i;
            }
            if (maxLeft < values[i] + i) {
                maxLeft = values[i] + i;
            }
        }
        return ans;
    }

    // 121. 买卖股票的最佳时机
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int high = prices[0];
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > high) {
                ans = Math.max(ans, prices[i] - low);
                high = prices[i];
            } else if (prices[i] < low) {
                low = prices[i];
                high = prices[i];
            }
        }
        return ans;
    }

    // 139. 单词拆分
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int[] hasWord = new int[len];

        for (int i = 0; i < len; i++) {
            if (i > 0 && hasWord[i - 1] != 1) {
                continue;
            }
            for (int j = i + 1; j <= len; j++) {
                String temp = s.substring(i, j);
                if (wordDict.contains(temp)) {
                    hasWord[j - 1] = 1;
                }
            }
        }
        return hasWord[len - 1] == 1;
    }

    // 70. 爬楼梯
    public int climbStairs(int n) {
        if (n < 3)
            return n;
        int[] record = new int[n + 1];
        record[1] = 1;
        record[2] = 2;
        for (int i = 3; i <= n; i++) {
            record[i] = record[i - 1] + record[i - 2];
        }
        return record[n];
    }
    public int climbStairsSecond(int n) {
        int p, q = 0;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            p = q;
            q = sum;
            sum = p + q;
        }
        return sum;
    }

    @Test
    public void test() {
//        System.out.println(longestPalindrome("aacabdkacaa"));
//        System.out.println(maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(trap(new int[]{1,0,1}));
//        System.out.println(maxScoreSightseeingPair(new int[]{1,2}));
//        System.out.println(maxProfit(new int[]{4, 2, 1, 7}));
        System.out.println(wordBreak("catsandog", new ArrayList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"))));
    }


}
