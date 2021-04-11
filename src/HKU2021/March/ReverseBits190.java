package HKU2021.March;

/**
 * 190. Reverse Bits
 */
public class ReverseBits190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return res;
    }
}
