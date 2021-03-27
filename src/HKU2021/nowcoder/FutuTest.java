package HKU2021.nowcoder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FutuTest {

    public int[] findTopKinTwoSortedArray(int[] arr1, int[] arr2, int k) {
        // write code here
        int[] res = new int[k];
        int len1 = arr1.length;
        int len2 = arr2.length;

        int index1 = len1 - 1;
        int index2 = len2 - 1;
        boolean[][] visited = new boolean[len1][len2];
        visited[index1][index2] = true;

        int resIndex = 0;
        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> o2.sum - o1.sum);

        maxHeap.add(new Node(index1, index2, arr1[index1] + arr2[index2]));

        while (resIndex < k) {
            Node curNode = maxHeap.poll();
            if (curNode == null)
                break;

            res[resIndex] = curNode.sum;
            index1 = curNode.x;
            index2 = curNode.y;

            if (index1 - 1 >= 0 && !visited[index1 - 1][index2]) {
                visited[index1 - 1][index2] = true;
                maxHeap.add(new Node(index1 - 1, index2, arr1[index1 - 1] + arr2[index2]));
            }

            if (index2 - 1 >= 0 && !visited[index1][index2 - 1]) {
                visited[index1][index2 - 1] = true;
                maxHeap.add(new Node(index1, index2 - 1, arr1[index1] + arr2[index2 - 1]));
            }
            resIndex++;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(",");

        String[] array1 = strings[0].split(",");
        String[] array2 = strings[1].split(",");

        int[] arr1 = parseArray(array1);
        int[] arr2 = parseArray(array2);

        FutuTest test = new FutuTest();
        System.out.println(Arrays.toString(test.findTopKinTwoSortedArray(arr1, arr2, Integer.parseInt(strings[3]))));
    }

    private static int[] parseArray(String[] array) {
        int temp;
        int[] arr = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                temp = Integer.parseInt(String.valueOf(array[i].charAt(1)));
            } else if (i == array.length - 1) {
                temp = Integer.parseInt(String.valueOf(array[i].charAt(0)));
            } else {
                temp = Integer.parseInt(array[i]);
            }
            arr[i] = temp;
        }
        return arr;
    }

    public static class Node {
        int x;
        int y;
        int sum;

        public Node(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
}
