package HKU2021;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMedian480 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue smallPQ = new PriorityQueue();
        PriorityQueue largePQ = new PriorityQueue();
        Map<Integer, Integer>  recordMap = new HashMap<>();

        int left = 0;
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i - left + 1 > k) {
                Integer tempInt = recordMap.getOrDefault(nums[left], 0);
                recordMap.put(nums[left], tempInt);
                left++;
            }
//            priorityQueue.add(nums[i]);
//            res[i + 1 - k] = getMedian(priorityQueue.toArray(), k);
        }
        return res;
    }

    private double getMedian(Object[] array, int k) {
        Integer[] arr = (Integer[]) array;
        if (k % 2 == 0) {
            return (arr[k / 2] + arr[k / 2 - 1]) / 2.0;
        } else {
            return arr[k / 2];
        }
    }

    @Test
    public void test480() {
        double[] res = medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (double i: res) {
            System.out.println(i);
        }
    }
}
