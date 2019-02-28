package collection;

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
            while (low < high && numbers[high] > temp) {
                high--;
            }
            numbers[low] = numbers[high];
            while (low < high && numbers[low] < temp) {
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
}
