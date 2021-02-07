package HKU2021;

import org.junit.Test;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 */
public class ObtainMaxPoints1423 {
    public int maxScore(int[] cardPoints, int k) {
        // Keep a window of size n - k over the array. The result is max(result, sum - windowSum)
        int windowLen = cardPoints.length - k;
        int[] window = new int[windowLen];
        int sum = 0, windowSum = 0;


        for (int i = 0; i < cardPoints.length; i++) {
            if (i < windowLen) {
                window[i] = cardPoints[i];
                windowSum += cardPoints[i];
            }
            sum += cardPoints[i];
        }
        int result = sum - windowSum;
        for (int j = windowLen; j < cardPoints.length; j++) {
            windowSum += cardPoints[j];
            windowSum -= cardPoints[j - windowLen];
            result = Math.max(result, sum - windowSum);
        }

        return result;
    }

    @Test
    public void test1423() {
        System.out.println(maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    }
}
