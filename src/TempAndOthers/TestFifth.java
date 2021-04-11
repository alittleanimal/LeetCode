package TempAndOthers;

import java.util.Arrays;

public class TestFifth {
    public void mergeSort(int[] nums) {
        if (nums.length == 0)
            return;

        mergeSort(nums, 0, nums.length - 1);
        Arrays.toString(nums);
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int l = low, r = mid + 1;
        int index = 0;

        while (l <= mid && r <= high) {
            if (nums[l] <= nums[r]) {
                temp[index++] = nums[l++];
            } else {
                temp[index++] = nums[r++];
            }
        }

        while (l <= mid) {
            temp[index++] = nums[l++];
        }

        while (r <= high) {
            temp[index++] = nums[r++];
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, nums, 0 + low, temp.length);
    }


    public void quickSort(int[] nums) {
        if (nums.length == 0)
            return;

        quickSort(nums, 0, nums.length - 1);
        Arrays.toString(nums);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = getMiddle(nums, low, high);
            quickSort(nums, low, mid);
            quickSort(nums, mid + 1, high);
        }
    }

    private int getMiddle(int[] nums, int low, int high) {
        int target = nums[low];

        while (low < high) {
            while (low < high && nums[high] >= target) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] < target) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = target;
        return low;
    }
}
