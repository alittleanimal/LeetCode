package HKU2021;

import org.junit.Test;

/**
 * 978. Longest Turbulent Subarray
 */
public class LongestTurbulentSubarray978 {
    public int maxTurbulenceSize(int[] arr) {
        if (arr.length < 2) return arr.length;

        boolean isLarger = arr[0] > arr[1];
        int res = 0;
        int left = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if ((isLarger && arr[i] < arr[i + 1]) || (!isLarger && arr[i] > arr[i + 1])) {
                res = Math.max(res, i - left + 1);
                left = i;
                isLarger = !isLarger;
            } else if (arr[i] == arr[i + 1]) {
                res = Math.max(res, i - left + 1);
                left = i + 1;
                if (i + 2 < arr.length) {
                    isLarger = arr[i + 1] > arr[i + 2];
                }
                continue;
            }
            isLarger = !isLarger;
        }

        return Math.max(res, arr.length - left);
    }

    public int maxTurbulenceSizeBetterSol(int[] arr) {
        int up = 1, down = 1;
        int res = 0;
        if (arr.length < 2) return arr.length;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                up = down + 1;
                down = 1;
            } else if (arr[i] < arr[i - 1]) {
                down = up + 1;
                up = 1;
            } else {
                down = up = 1;
            }
            res = Math.max(res, Math.max(up, down));
        }
        return res;
    }

    @Test
    public void test978() {
        System.out.println(maxTurbulenceSizeBetterSol(new int[]{2, 0, 2, 4, 2, 5, 0, 1, 2, 3}));
    }
}
