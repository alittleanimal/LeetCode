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
}
