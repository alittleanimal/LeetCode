package Collection;

import org.junit.Test;

import java.util.Arrays;

public class SortCollection {

    /**
     * Bubble sort
     * Compare adjacent two element, if the first one is bigger than the second one, swap this two number
     * Doing the same thing to every adjacent element, from the first pair to the end.
     * After this, the last one should be the biggest one.
     * Doing this to all the element except for the last one.
     *
     * @param numbers
     */
    public static void bubbleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortImprovement(int[] numbers) {
        boolean hasChange;
        int lastChangeIndex = numbers.length - 1;
        int arrayBoundary = numbers.length - 1;

        for (int i = 0; i < numbers.length - 1; i++) {
            hasChange = false;
            for (int j = 0; j < arrayBoundary; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;

                    hasChange = true;
                    lastChangeIndex = j;
                }
            }
            arrayBoundary = lastChangeIndex;

            if (!hasChange)
                break;
        }
    }

    /**
     * find the position of axis after the sort of number array
     *
     * @param numbers
     * @param low
     * @param high
     * @return
     */
    public static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low];

        while (low < high) {
            while (low < high && numbers[high] >= temp) {
                high--;
            }
            numbers[low] = numbers[high];
            while (low < high && numbers[low] <= temp) {
                low++;
            }
            numbers[high] = numbers[low];
        }
        numbers[low] = temp;
        return low;
    }

    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high);
            quickSort(numbers, low, middle - 1);
            quickSort(numbers, middle + 1, high);
        }
    }

    public static void quick(int[] numbers) {
        if (numbers.length > 0) {
            quickSort(numbers, 0, numbers.length - 1);
        }
    }

    /**
     * Select Sort
     * Find the smallest element in the unsorted array, put it in the first one of the sorted array.
     * Find the smallest element in the rest of the array, put it in the end of the sorted array.
     * Doing this until all the element sorted
     *
     * @param numbers
     */
    public static void selectSort(int[] numbers) {
        int temp;

        for (int i = 0; i < numbers.length; i++) {
            int k = i;
            for (int j = numbers.length - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            if (i != k) {
                temp = numbers[i];
                numbers[i] = numbers[k];
                numbers[k] = temp;
            }
        }
    }

    /**
     * Insert Sort
     * From the first element, consider it's the sorted element
     * get the next element, scan the sorted element from back to front
     * if the sorted element bigger than the new element, put it into the next place
     * repeat this step until find the sorted element smaller than or equal to the new element
     * insert the new element to this place
     * repeat
     *
     * @param numbers
     */
    public static void insertSort(int[] numbers) {
        int j;
        for (int i = 0; i < numbers.length; i++) {
            int temp = numbers[i];
            for (j = i; j > 0 && temp < numbers[i - 1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
        }
    }

    public static void printArr(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers = {10, 20, 15, 0, 6, 7, 2, 1, -5, 55};
        System.out.print("排序前：");
        printArr(numbers);

        bubbleSort(numbers);
        System.out.print("冒泡排序后：");
        printArr(numbers);


        quick(numbers);
        System.out.print("快速排序后：");
        printArr(numbers);
    }

    /**
     * https://blog.csdn.net/qq_36186690/article/details/82505569
     * @param nums
     */
    public void heapSort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, nums.length);
        }

        for (int j = nums.length - 1; j > 0; j--) {
            swap(nums, 0, j);
            adjustHeap(nums, 0, j);
        }
        System.out.println(Arrays.toString(nums));
    }

    private void adjustHeap(int[] nums, int i, int length) {
        int temp = nums[i];

        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {
            if (j + 1 < length && nums[j] < nums[j + 1]) {
                j++;
            }
            if (nums[j] > temp) {
                nums[i] = nums[j];
                i = j;
            } else {
                break;
            }
        }
        nums[i] = temp;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }


    @Test
    public void testSort() {
        heapSort(new int[]{7,6,7,11,5,12,3,0,1});
    }
}
