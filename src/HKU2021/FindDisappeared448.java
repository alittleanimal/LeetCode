package HKU2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FindDisappeared448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] >= 0)
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }

    @Test
    public void test448() {
        System.out.println(findDisappearedNumbers(new int[]{8, 3, 2, 7, 8, 2, 3, 1}));
    }
}
