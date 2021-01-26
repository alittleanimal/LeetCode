package HKU2021;

import org.junit.Test;

import java.util.*;

/**
 * 1128. Number of Equivalent Domino Pairs
 */
public class EquivalentDomino1128 {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> recordMap = new HashMap<>();

        for (int i = 0; i < dominoes.length; i++) {
            // Sort and record count
            Arrays.sort(dominoes[i]);
            Integer itemRecord = recordMap.getOrDefault(dominoes[i][0] * 10 + dominoes[i][1], 0);
            recordMap.put(dominoes[i][0] * 10 + dominoes[i][1], ++itemRecord);
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> item : recordMap.entrySet()) {
            // C(N)(2)
            res += item.getValue() * (item.getValue() - 1) / 2;
        }
        return res;
    }

    public int numEquivDominoPairsBetterSol(int[][] dominoes) {
        int[] recordArray = new int[100];

        int res = 0;
        for (int[] arr: dominoes) {
            Arrays.sort(arr);
            // Use position to record items
            res += recordArray[arr[0] * 10 + arr[1]]++;
        }
        return res;
    }

    @Test
    public void test1128() {
        System.out.println(numEquivDominoPairsBetterSol(new int[][]{{1, 2}, {1, 2}, {1, 1}, {1, 2}, {1, 1}, {2, 1}}));
    }
}
