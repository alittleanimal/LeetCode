package HKU2021.March;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer[]> stack = new Stack<>(); // [nums[i], index]
        Map<Integer, Integer> recordMap = new HashMap<>(); // (index, greater)

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > stack.peek()[0])
                recordMap.put(stack.pop()[1], nums[i]);

            stack.push(new Integer[]{nums[i], i});
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = recordMap.getOrDefault(i, -1);
            while (stack.size() > 1 && nums[i] > stack.peek()[0])
                recordMap.put(stack.pop()[1], nums[i]);
        }

        return res;
    }

    @Test
    public void test503() {
        System.out.println(Arrays.toString(nextGreaterElementsBetter(new int[]{1, 2, 1, 3, 1, 4, 1, 2})));
    }

    public int[] nextGreaterElementsBetter(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];

        Arrays.fill(res, -1);

        for (int i = 0; i < n * 2 - 1; i++) {
            if (i > n && stack.size() == 1) {
                break;
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }
}
