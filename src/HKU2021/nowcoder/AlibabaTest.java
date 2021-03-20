package HKU2021.nowcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AlibabaTest {

    private int count = 0;

    // 2
    // 1 6 3
    // 2 6 7
    public int chooseCard(int n, int m, int k) {
        dfs(k, 1, m, n - 1);
        return count;
    }

    private void dfs(int target, int start, int end, int n) {
        if (n == 0) {
            if (target <= end - start + 1)
                count++;
            return;
        }

        if (target == 0) {
            return;
        }

        for (int i = start; i <= end - n; i++) {
            dfs(target - i, 1, end, n - 1);
        }
    }

    /**
     * 5 3
     * -1 3
     * 2 4
     * -3 4
     * 2 5
     * 1 2
     * <p>
     * 1 4
     * 1 5
     * 2 4
     * 2 3
     * 3 5
     */
    private List<Integer> res = new ArrayList<>();
    private int n = 0;
    private ArrayList[] diffCalculate;
    private int[][] item;

    public void calculateItem() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int conflict = sc.nextInt();
        item = new int[n][2];
        for (int i = 0; i < n; i++) {
            item[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        int a, b;
        diffCalculate = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            diffCalculate[i] = new ArrayList();
        }

        for (int i = 0; i < n; i++) {

            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;
            diffCalculate[a].add(b);
            diffCalculate[b].add(a);

        }


        for (int i = 0; i < n; i++) {
            List<Integer> recordList = new ArrayList<>();
            dfs2(i + 1, conflict - 1, recordList, 0, i);
            if (!recordList.isEmpty())
                res.add(Collections.max(recordList));
        }
        System.out.println(res);
    }

    private void dfs2(int start, int count, List<Integer> recordList, int sum, int index) {
        if (count == 0) {
            recordList.add(sum);
        }

        for (int i = start; i < n; i++) {
            if (!diffCalculate[index].contains(i)) {
                int temp = Math.min(item[index][0] + item[i][1], item[index][1] + item[i][0]);
                sum += temp;
                dfs2(i + 1, count - 1, recordList, sum, index);
                sum -= temp;
            }
        }
    }

    public static void main(String[] args) {
//        Scanner console = new Scanner(System.in);
//        int num = console.nextInt();
        AlibabaTest ali = new AlibabaTest();
//        for (int i = 0; i < num; i++) {
//            System.out.println(ali.chooseCard(console.nextInt(), console.nextInt(), console.nextInt()));
//        }

        ali.calculateItem();

//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int ans = 0, x;
//        for(int i = 0; i < n; i++){
//            for(int j = 0; j < n; j++){
//                x = sc.nextInt();
//                ans += x;
//            }
//        }
//        System.out.println(ans);
    }
}
