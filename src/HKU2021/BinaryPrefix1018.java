package HKU2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. Binary Prefix Divisible By 5
 */
public class BinaryPrefix1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int currentNum = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            currentNum = 2 * currentNum + A[i];
            // 只看最后一位 否则超出int整数范围
            currentNum = currentNum % 10;
            System.out.println(currentNum);
            res.add(currentNum % 5 == 0);
        }
        return res;
    }

    @Test
    public void test1018() {
        int[] a = new int[]{1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        List<Boolean> res = prefixesDivBy5(a);
        for (Boolean item : res) {
            System.out.println(item);
        }
    }
}
