package HKU2021.March;

import org.junit.Test;

import java.util.Arrays;

/**
 * 132. Palindrome Partitioning II
 */
public class PalindromePartitioningII132 {

    boolean[][] f;
    int n;
    int minCount;

    public int minCut(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(f[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        minCount = 2001;
        dfs(0, 0);

        return minCount - 1;
    }

    private void dfs(int index, int count) {
        if (index == n) {
            minCount = Math.min(count, minCount);
            return;
        }

        for (int i = index; i < n; i++) {
            if (f[index][i]) {
                dfs(i + 1, count + 1);
            }
        }
    }

    public int minCutBetter(String s) {
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }


    @Test
    public void test132() {
        System.out.println(minCutBetter("aaba"));
    }
}
