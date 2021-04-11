package TempAndOthers;

import org.junit.Test;

import java.util.Arrays;

public class TestThird {
    public void quickSort(int[] nums) {
        if (nums.length == 0)
            return;

        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int middle = getMiddle(nums, low, high);
            quickSort(nums, low, middle - 1);
            quickSort(nums, middle + 1, high);
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

    @Test
    public void test() {
//        insertSort(new int[]{2, 3, 1, 4, 2, 5, 23, 12, 3});
        System.out.println(System.currentTimeMillis());
        System.out.println(binarySearch(new int[]{1,2,3,4,5,6,23,4}, 5));
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

    private void merge(int[] nums, int low, int mid, int high) {
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

    private void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private void chooseSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }

            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }

    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int index = i;
            int temp = nums[i];
            while (index > 0 && temp < nums[index - 1]) {
                nums[index] = nums[index - 1];
                index--;
            }
            nums[index] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }


    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }else if (target < nums[mid]) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//
//    }
}
