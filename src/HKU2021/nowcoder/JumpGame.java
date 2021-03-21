package HKU2021.nowcoder;

import java.util.Scanner;

public class JumpGame {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 返回牛牛最少需要控制该角色多少次才可以到达终点，如果到达不了，返回-1。
     *
     * @param d int整型 代表该角色每次跳跃的最大长度
     * @param s string字符串 代表该关卡河流和石子的分布(0代表河1代表石子)
     * @return int整型
     */
    public static int jumpGame(int d, String s) {
        int len = s.length();
        if (d >= len)
            return 1;

        int i = 0;
        int count = 0;
        while (i < len - 1) {
            int temp = i + d;
            boolean canJump = false;
            if (temp >= len)
                return count + 1;
            for (; temp > i; temp--) {
                if (s.charAt(temp) == '1') {
                    i = temp;
                    canJump = true;
                    count++;
                    break;
                }
            }

            if (!canJump)
                return -1;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        String[] inputs = input.split(",");
        int maxLen = Integer.parseInt(inputs[0]);
        String river = inputs[1];

        System.out.println(maxLen);
        System.out.println(river);
        System.out.println(jumpGame(maxLen, river));
    }
}
