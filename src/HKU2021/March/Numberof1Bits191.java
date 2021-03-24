package HKU2021.March;

import org.junit.Test;

public class Numberof1Bits191 {
    public int hammingWeight(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                cnt++;
            }
        }
        return cnt;
    }

    @Test
    public void test191() {
        System.out.println(hammingWeightSecond(00000000000000000000000000001011));
    }

    public int hammingWeightSecond(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }
}
