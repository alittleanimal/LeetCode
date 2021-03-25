package HKU2021.March;

import org.junit.Test;

import java.util.Stack;

public class Pattern456 {
    public boolean find132pattern(int[] nums) {

        int len = nums.length;
        if (len < 3)
            return false;
        Stack<Integer> stack = new Stack<>();
        int max2 = Integer.MIN_VALUE;
        stack.push(nums[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < max2) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                max2 = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    @Test
    public void test456() {
        System.out.println(find132pattern(new int[]{-1,3,2,0}));
    }
}
