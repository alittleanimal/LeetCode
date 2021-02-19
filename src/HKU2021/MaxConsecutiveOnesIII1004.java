package HKU2021;

import org.junit.Test;

public class MaxConsecutiveOnesIII1004 {
    public int longestOnes(int[] A, int K) {
        int left = 0, count = 0, zeroCount = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                zeroCount++;
                if (zeroCount > K) {
                    count = Math.max(count, i - left);
                    while (A[left] != 0) {
                        left++;
                    }
                    left++;
                    zeroCount--;
                }
            }
        }
        return Math.max(count, A.length - left);
    }

    @Test
    public void test1004() {
        System.out.println(longestOnes(new int[]{0}, 1));
    }
}
