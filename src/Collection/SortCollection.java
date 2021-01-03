package Collection;

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
        int temp = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortImprovement(int[] numbers) {
        int temp = 0;
        boolean hasChange = false;
        int lastChangeIndex = numbers.length - 1;
        int tempChangeIndex = 0;

        for (int i = 0; i < lastChangeIndex; i++) {
            hasChange = false;
            for (int j = 0; j < lastChangeIndex - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    hasChange = true;
//                    tempChangeIndex =
                }
            }

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
        int temp = 0;

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
        int temp = 0;
        int j = 0;

        for (int i = 0; i < numbers.length; i++) {
            temp = numbers[i];
            for (j = i; j > 0 && temp < numbers[i - 1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
        }
    }

    public static void printArr(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
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
}
