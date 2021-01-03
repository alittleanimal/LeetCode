package Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public static void permutation (Integer[] arr, int start, int end, List<List<Integer>> returnList) {
        if (start == end) {
            returnList.add(new ArrayList<Integer>(Arrays.asList(arr)));
            return;
        }

        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            permutation(arr, start+1, end, returnList);
            swap(arr, i ,start);
        }
    }

    private static void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        List<List<Integer>> returnList = new ArrayList<>();
        permutation(arr, 0, arr.length-1, returnList);
        for (List<Integer> returnL : returnList) {
            System.out.println(returnL.toString());
        }
    }
}
