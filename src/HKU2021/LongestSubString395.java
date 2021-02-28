package HKU2021;

import org.junit.Test;

/**
 * 395. Longest Substring with At Least K Repeating Characters
 */
public class LongestSubString395 {
    public int longestSubstring(String s, int k) {
        return dfs(s, k, 0, s.length());
    }

    private int dfs(String s, int k, int l, int r) {
        int[] charArray = new int[26];
        char split = 0;
        for (int i = l; i < r; i++) {
            charArray[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > 0 && charArray[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }

        if (split == 0)
            return r - l;

        int count = 0;
        int left = l;
        while (left < r) {
            while (left < r && s.charAt(left) == split) {
                left++;
            }

            if (left >= r)
                break;

            int start = left;
            while (left < r && s.charAt(left) != split)
                left++;

            int length = dfs(s, k, start, left);
            count = Math.max(count, length);
        }
        return count;
    }

    @Test
    public void test395() {
        System.out.println(longestSubstring("aacbbbdc", 2));
    }
}
