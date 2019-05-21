package Preparation;

import java.util.*;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        int[] recordList = nums.clone();
        Arrays.sort(recordList);
        for (int i: nums) {
            if (i==recordList[recordList.length-k]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1};
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(nums, 2));
    }
}
