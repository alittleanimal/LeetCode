package HKU2021.nowcoder;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://www.nowcoder.com/questionTerminal/7201cacf73e7495aa5f88b223bbbf6d1
 */
public class SortedArrayTopK {
    public int[] findTopKinTwoSortedArray(int[] arr1, int[] arr2, int k) {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);
        int len1 = arr1.length;
        int len2 = arr2.length;

        int index1 = len1 - 1;
        int index2 = len2 - 1;

        int[] res = new int[k];
        int resIndex = 0;

        priorityQueue.add(new Node(index1, index2, arr1[index1] + arr2[index2]));

        while (!priorityQueue.isEmpty() && resIndex < k) {
            Node node = priorityQueue.poll();
            res[resIndex++] = node.sum;

            int temp1 = node.index1;
            int temp2 = node.index2;

            if (temp1 - 1 >= 0) {
                priorityQueue.add(new Node(temp1 - 1, temp2, arr1[temp1 - 1] + arr2[temp2]));
            }

            if (temp2 - 1 >= 0) {
                priorityQueue.add(new Node(temp1, temp2 - 1, arr1[temp1] + arr2[temp2 - 1]));
            }
        }

        return res;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(findTopKinTwoSortedArray(new int[]{1, 2, 3, 4, 5}, new int[]{3, 5, 7, 9, 11}, 4)));
    }

    class Node {
        int index1;
        int index2;
        int sum;

        public Node(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }
}
