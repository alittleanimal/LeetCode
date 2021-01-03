package OnceAgain;

import com.sun.javaws.IconUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanMakePaliQueries {

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> resultList = new ArrayList<>();
        Map<Character, Boolean> recordMap = new HashMap<>();
        for (int i = 0; i < queries.length; i++) {
            String operateStr = s.substring(queries[i][0], queries[i][1] + 1);
            for (char c : operateStr.toCharArray()) {
                if (recordMap.containsKey(c)) {
                    recordMap.put(c, !recordMap.get(c));
                } else {
                    recordMap.put(c, false);
                }
            }

            int oddNumbers = 0;
            int replace = queries[i][2];
            for (Boolean record : recordMap.values()) {
                if (!record) oddNumbers++;
            }

            if (operateStr.length() % 2 != 0)
                oddNumbers--;

            if (oddNumbers <= replace * 2)
                resultList.add(true);
            else
                resultList.add(false);

            recordMap.clear();
        }

        return resultList;
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            while (j < arr.length - 1) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c){
                            result++;
                        }
                    }
                }
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /*String s = "abcda";
        CanMakePaliQueries canMakePaliQueries = new CanMakePaliQueries();
        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
        List<Boolean> result = canMakePaliQueries.canMakePaliQueries(s, queries);
        for (Boolean b : result) {
            System.out.println(b);
        }*/

        CanMakePaliQueries canMakePaliQueries = new CanMakePaliQueries();
        int[] arr = {1,1,2,2,3};
        int result = canMakePaliQueries.countGoodTriplets(arr, 0,0,1);
        System.out.println(result);
    }
}
