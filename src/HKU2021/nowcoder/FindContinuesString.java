package HKU2021.nowcoder;

import org.junit.Test;

import java.util.Scanner;

public class FindContinuesString {
    public static void solution(int n, int l) {
        if (l > 100) {
            System.out.print("No");
            return;
        }
        int temp = 2 * n - l * (l - 1);
        if (temp % (2 * l) != 0) {
            solution(n, l + 1);
            return;
        }
        int start = temp / (2 * l);

        for (int i = 0; i < l - 1; i++) {
            System.out.print(start + i + " ");
        }
        System.out.print(start + l - 1);
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = console.nextInt();
        int L = console.nextInt();
        solution(N, L);
    }

    public static int display(int N, int L) {
        for (int i = L; i < 101; i++) {
            int temp = (2 * N - i * (i - 1));
            if (temp % (2 * i) == 0 && temp / (2 * i) >= 0) {
                int a1 = temp / (2 * i);
                for (int j = 0; j < i - 1; j++) {
                    System.out.print(a1 + j + " ");
                }
                System.out.print(a1 + (i - 1));
                return 0;
            }
        }
        System.out.print("No");
        return 0;
    }

}
