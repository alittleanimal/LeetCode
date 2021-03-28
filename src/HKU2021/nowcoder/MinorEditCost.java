package HKU2021.nowcoder;

import org.junit.Test;

/**
 * https://www.nowcoder.com/practice/dfa502cf6a914fb5b98c59c56619e96c?tpId=101&tqId=33111&rp=1&ru=%2Fta%2Fprogrammer-code-interview-guide&qru=%2Fta%2Fprogrammer-code-interview-guide%2Fquestion-ranking&tab=answerKey
 */
public class MinorEditCost {
    public static int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        int len1 = str1.length();
        int len2 = str2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i * dc;
        }

        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i * ic;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rc, Math.min(dp[i][j - 1] + dc, dp[i - 1][j] + ic));
                }
            }
        }

        return dp[len1][len2];
    }

    @Test
    public void test() {
        System.out.println(minEditCost("abc", "adc", 5, 3, 2));
    }
}
