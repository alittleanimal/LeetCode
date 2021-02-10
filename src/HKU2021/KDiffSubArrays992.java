package HKU2021;

import org.junit.Test;

/**
 * 992. Subarrays with K Different Integers
 */
public class KDiffSubArrays992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostWithKDistinct(A, K) - atMostWithKDistinct(A, K - 1);
    }

    private int atMostWithKDistinct(int[] A, int K) {
        int len = A.length;
        int[] freq = new int[len + 1];

        int left = 0, right = 0;
        int count = 0, res = 0;

        while (right < len) {
            if (freq[A[right]] == 0) {
                count++;
            }
            freq[A[right]]++;
            right++;

            while (count > K) {
                freq[A[left]]--;
                if (freq[A[left]] == 0) {
                    count--;
                }
                left++;
            }

            res += right - left;
        }
        return res;
    }

    @Test
    public void test992() {
        System.out.println(subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
