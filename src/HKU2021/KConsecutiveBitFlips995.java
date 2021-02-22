package HKU2021;

import org.junit.Test;

/**
 * 995. Minimum Number of K Consecutive Bit Flips
 */
public class KConsecutiveBitFlips995 {

    public int minKBitFlips(int[] A, int K) {
        int ans = 0, revCnt = 0;

        for (int i = 0; i < A.length; i++) {
            if (i > K && A[i - K] > 1) { // indicate in i-K position, array A flipped
                revCnt ^= 1;
            }

            if (A[i] == revCnt) {
                if (i + K > A.length)
                    return -1;
                ans++;
                A[i] += 2; // indicate A[i] flips
                revCnt ^= 1;
            }
        }
        return ans;
    }

    @Test
    public void test995() {
        System.out.println(minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
    }
}
