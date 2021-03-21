package HKU2021.nowcoder;

import java.util.Scanner;

public class CommonPrefixSuffix {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 给定一个字符串s，返回具有相同前缀后缀的子串的第二大长度，反之，返回-1即可。
     *
     * @param s string字符串 代表题意中的字符串s
     * @return int整型
     */
    public static int solve(String s) {
        int len = s.length();
        if (len == 0)
            return -1;

        int i = 0, j = len - 1;
        int count = 0;
        while (i < len && j >= 0) {
            if (s.charAt(i) != s.charAt(j))
                break;

            count++;
            i++;
            j--;
        }

        return count == 0 ? -1 : count;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String str = "";
        if (console.hasNextLine()) {
            str = console.nextLine();
            System.out.println("输入的数据为：" + str);
        }
        System.out.println(solve(str));
    }
}
