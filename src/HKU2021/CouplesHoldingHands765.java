package HKU2021;

import org.junit.Test;

public class CouplesHoldingHands765 {
    public int minSwapsCouples(int[] row) {
        int[] originalSeat = new int[row.length];

        for (int i = 0; i < row.length; i++) {
            originalSeat[row[i]] = i;
        }

        int count = 0;
        int realCoupleSeat, couple;
        for (int j = 0; j < row.length - 1; j++) {
            couple = findCouple(row[j]);
            if (couple != row[j + 1]) {
                realCoupleSeat = originalSeat[couple];
                originalSeat[couple] = j + 1;
                originalSeat[row[j + 1]] = realCoupleSeat;
                row[realCoupleSeat] = row[j + 1];
                count++;
            }
            j++;
        }

        return count;
    }

    private int findCouple(int item) {
        if (item % 2 == 0)
            return item + 1;
        else
            return item - 1;
    }

    @Test
    public void test765() {
        System.out.println(minSwapsCouples(new int[]{3, 0, 2, 4, 1, 5}));
    }
}
