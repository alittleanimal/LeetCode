public class NthUglyNumber {
    /**
     * 编写一个程序，找出第 n 个丑数。

     丑数就是只包含质因数 2, 3, 5 的正整数。

     示例:

     输入: n = 10
     输出: 12
     解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
     * @param n
     * @return
     */
    public static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;

        int a,b,c,temp;
        for (int i=1; i<n; i++) {
            a = 2 * ugly[index_2];
            b = 3 * ugly[index_3];
            c = 5 * ugly[index_5];

            temp = Math.min(Math.min(a,b), c);
            if (temp == a) index_2 ++;
            if (temp == b) index_3 ++;
            if (temp == c) index_5 ++;
            ugly[i] = temp;
        }

        return ugly[n-1];
    }

    public static void main(String[] args) {

        System.out.println(nthUglyNumber(10));
    }
}
