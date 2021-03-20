package HKU2021.nowcoder;

import java.util.Scanner;

public class BaiduTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String temp1 = sc.nextLine();
        int[][] record = new int[n][n];
        for (int i = 0; i < n; i++) {
            String temp = sc.nextLine();

            for (int j = 0; j < n; j++) {
                record[i][j] = temp.charAt(j) - '0';
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (record[i][j] == 0) {
                    if (record[i][j + 1] == 0 || record[i][j - 1] == 0
                            || record[i + 1][j] == 0 || record[i - 1][j] == 0) {
                        continue;
                    }
                    record[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(record[i][j]);
            }
            if (i != n - 1)
                System.out.println();
        }
    }
}
