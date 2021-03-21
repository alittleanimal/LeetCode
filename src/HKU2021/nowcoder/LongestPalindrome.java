package HKU2021.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindrome {
    public int getLongestPalindrome(String A, int n) {
        // write code here
        int len = A.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], true);
        }

        int count = 0;
        for (int i = len - 1; i >=0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    count = Math.max(count, j - i + 1);
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strs = line.split(",");
        String A = strs[0];
        A = A.substring(1, A.length()-1);

        LongestPalindrome sol = new LongestPalindrome();
        System.out.println(sol.getLongestPalindrome(A, Integer.parseInt(strs[1])));


    }
}
