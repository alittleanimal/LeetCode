package HKU2021;

import org.junit.Test;

/**
 * 424. Longest Repeating Character Replacement
 */
public class LongestRepeatingChar424 {
    public int characterReplacement(String s, int k) {
        if (s.isEmpty()) return 0;
        char[] charArray = s.toCharArray();
        int res = 1;

        int i = 1, diff = 0, tempRes = 1;
        char recordChar = charArray[0];
        int remainK = k;
        while (i < charArray.length) {
            if (charArray[i] == recordChar) {
                i++;
            } else {
                if (remainK == k) {
                    diff = i;

                }

                if (remainK == 0) {
                    recordChar = charArray[diff];
                    i = diff;
                    remainK = k;
                    res = Math.max(res, tempRes);
                    tempRes = 0;
                    continue;
                }

                i++;
                remainK--;
            }

            tempRes++;
        }
        if (tempRes + remainK > charArray.length) {
            return charArray.length;
        }
        return Math.max(res, tempRes + remainK);
    }


    public int characterReplacementBetterSol(String s, int k) {
        char[] charArray = s.toCharArray();
        int[] charRecord = new int[26];

        int left = 0;
        int max = 0;
        int index;

        for (int i = 0; i < charArray.length; i++) {
            index = charArray[i] - 'A';
            charRecord[index]++;
            max = Math.max(max, charRecord[index]);
            // 窗口大小大于可填充的最大值，缩小左侧窗口
            if (i - left + 1 > max + k) {
                charRecord[charArray[left] - 'A']--;
                left++;
            }
        }

        // 返回最大窗口距离
        return charArray.length - left;
    }

    @Test
    public void test424() {
        System.out.println(characterReplacementBetterSol("BAAA", 0));
    }
}
