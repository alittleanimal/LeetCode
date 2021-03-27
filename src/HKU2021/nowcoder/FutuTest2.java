package HKU2021.nowcoder;

import java.util.Scanner;

public class FutuTest2 {
    /**
     * min edit cost
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic   int整型 insert cost
     * @param dc   int整型 delete cost
     * @param rc   int整型 replace cost
     * @return int整型
     */
    public static int minEditCost(String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i * dc;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j * ic;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + rc, Math.min(dp[i - 1][j] + dc, dp[i][j - 1] + ic));
            }
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String[] strings = str1.split(",");
        System.out.println(minEditCost(strings[0], strings[1],
                Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), Integer.parseInt(strings[4])));
    }
}
