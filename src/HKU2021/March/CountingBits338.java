package HKU2021.March;

/**
 * 338. Counting Bits
 */
public class CountingBits338 {
    public int[] countBits(int num) {
        int[] bit = new int[num + 1];
        bit[0] = 0;
        int highBit = 0;
        for (int i = 1; i < num + 1; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bit[i] = bit[i - highBit] + 1;
        }
        return bit;
    }

    public int[] countBitsSecond(int num) {
        int[] bit = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        return bit;
    }
}
