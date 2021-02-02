package HKU2021;

import org.junit.Test;

import java.util.Arrays;

public class FairCandySwap888 {
    public int[] fairCandySwap(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sumA = 0, sumB = 0;
        for (int itemA : A) {
            sumA += itemA;
        }
        for (int itemB : B) {
            sumB += itemB;
        }

        int diff = Math.abs(sumA - sumB) / 2;
        int[] res = new int[2];
        if (sumA > sumB) {
            res = getDiff(B, A, diff);
            res = new int[]{res[1], res[0]};
        } else if (sumA < sumB) {
            res = getDiff(A, B, diff);
        }
        return res;
    }

    private int[] getDiff(int[] smallArray, int[] largeArray, int diff) {
        int i = 0, j = 0;
        while (i < smallArray.length && j < largeArray.length) {
            if (smallArray[i] + diff == largeArray[j])
                return new int[]{smallArray[i], largeArray[j]};
            else if (smallArray[i] + diff < largeArray[j])
                i++;
            else
                j++;
        }
        return new int[]{0, 0};
    }

    public int[] fairCandySwapBetterSol(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sumA = 0, sumB = 0;
        for (int itemA : A) {
            sumA += itemA;
        }
        for (int itemB : B) {
            sumB += itemB;
        }

        int diff = (sumA - sumB) / 2;
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] - diff == B[j])
                return new int[]{A[i], B[j]};
            else if (A[i] - diff < B[j])
                i++;
            else
                j++;
        }
        return new int[2];
    }

    @Test
    public void test888() {
        int[] res = fairCandySwap(new int[]{1, 2, 5}, new int[]{2, 4});
        System.out.println(res[0]);
        System.out.println(res[1]);
    }
}
