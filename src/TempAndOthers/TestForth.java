package TempAndOthers;

import java.util.Arrays;

public class TestForth {
    public void quickSort(int[] nums) {
        if (nums.length == 0)
            return;

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = getMiddle(nums, low, high);
            quickSort(nums, low, mid - 1);
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


    public void mergeSort(int[] nums) {
        if (nums.length == 0)
            return;

        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    public void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low, j = mid + 1;
        int index = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[index++] = nums[i++];
        }

        while (j <= high) {
            temp[index++] = nums[j++];
        }

        if (temp.length >= 0) System.arraycopy(temp, 0, nums, low + 0, temp.length);
    }

    private volatile static TestForth instance = null;
    private TestForth() {}

    public TestForth getInstance() {
        if (instance == null) {
            synchronized(TestForth.class) {
                if (instance == null) {
                    instance = new TestForth();
                }
            }
        }
        return instance;
    }
}
