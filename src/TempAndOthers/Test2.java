package TempAndOthers;

import org.junit.Test;

import java.util.Arrays;

public class Test2 {

    public void quickSort(int[] nums) {
        if (nums.length == 0)
            return;

        quickSort(0, nums.length - 1, nums);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int low, int high, int[] nums) {

        if (low < high) {
            int middle = getMiddle(low, high, nums);
            quickSort(low, middle - 1, nums);
            quickSort(middle + 1, high, nums);
        }
    }

    private int getMiddle(int low, int high, int[] nums) {
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

    @Test
    public void testSort() {
        mergeSort(new int[]{1, 2, 3, 2, 3, 5, 3, 4, 12, 32, 2, 3});
    }

    public void mergeSort(int[] nums) {
        System.out.println(Arrays.toString(mergeSort(nums, 0, nums.length - 1)));
    }

    private int[] mergeSort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
        return nums;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int l = low;
        int r = mid + 1;
        int[] temp = new int[high - low + 1];
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

        if (temp.length >= 0) System.arraycopy(temp, 0, nums, low + 0, temp.length);
    }
}
