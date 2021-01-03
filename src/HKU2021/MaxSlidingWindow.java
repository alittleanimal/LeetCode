package HKU2021;

import java.util.Collections;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> slidingList = new LinkedList<>();
        int[] resultList = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            slidingList.add(nums[i]);
        }
        int max = Collections.max(slidingList);
        resultList[0] = max;
        int first = 0;
        for (int i = k; i < nums.length; i++) {
            first = slidingList.removeFirst();
            slidingList.addLast(nums[i]);

            if (first == max) max = Collections.max(slidingList);
            else if (max < nums[i]) max = nums[i];

            resultList[i - k + 1] = max;
        }
        return resultList;
    }

    /**
     * slidingList size小于等于k， 元素从大到小排列
     * 每次扫描新的元素，弹出队列中小于他的数
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindowBetterSol(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;

        LinkedList<Integer> slidingList = new LinkedList<>();
        int[] resultList = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            while (slidingList.size() > 0 && nums[slidingList.peekLast()] < nums[i]) {
                slidingList.removeLast();
            }
            slidingList.addLast(i);
            if (slidingList.peek() < i - k + 1) {
                slidingList.removeFirst();
            }
            if ((i - k + 1) >= 0) {
                resultList[i - k + 1] = nums[slidingList.peek()];
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        long start = System.currentTimeMillis();
        int[] nums = {1, -1};

        int[] result = maxSlidingWindow.maxSlidingWindowBetterSol(nums, 1);

        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        for (int i : result) {
            System.out.println(i);
        }
    }
}
