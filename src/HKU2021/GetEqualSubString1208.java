package HKU2021;

import org.junit.Test;

/**
 * 1208. Get Equal Substrings Within Budget
 */
public class GetEqualSubString1208 {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] recordArray = new int[s.length()];
        int left = 0;
//        int len = 0;
        int cost = 0;

        for (int i = 0; i < s.length(); i++) {
            recordArray[i] = Math.abs(s.charAt(i) - t.charAt(i));
            cost += recordArray[i];
//            len++;
            if (cost > maxCost) {
                cost -= recordArray[left];
                left++;
//                len--;
            }
        }
//        return len;
        return s.length() - left; // 窗口大小每次加一， 只扩张不缩小
    }

    @Test
    public void test1208() {
        System.out.println(equalSubstring("abcd", "bcde", 0));
    }
}
