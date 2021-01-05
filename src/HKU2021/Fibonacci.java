package HKU2021;

public class Fibonacci {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        return fib(n - 1) + fib(n - 2);
    }

    public int fibSecond(int n) {
        if (n < 2) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 0; i < n - 1; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    public int fibThird(int n) {
        if (n < 2) return n;
        int[] a = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n];
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibThird(5));
    }
}
