package HKU2021.nowcoder;

import java.util.Scanner;

public class BaiduTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String xy = sc.nextLine();
        String pos = sc.nextLine();
        int x = Integer.parseInt(xy.split(" ")[0]);
        int y = Integer.parseInt(xy.split(" ")[1]);


        int[][] direction = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        int dir;
        for (int i = 0; i < pos.length(); i++) {
            char temp = pos.charAt(i);
            switch (temp) {
                case 'U':
                    dir = 0;
                    break;
                case 'D':
                    dir = 1;
                    break;
                case 'L':
                    dir = 2;
                    break;
                default:
                    dir = 3;
            }
            x += direction[dir][0];
            y += direction[dir][1];
        }
        System.out.print(x);
        System.out.print(" ");
        System.out.print(y);
    }
}
