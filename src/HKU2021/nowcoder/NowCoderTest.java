package HKU2021.nowcoder;

import java.util.Scanner;

public class NowCoderTest {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param buttons int整型一维数组
     * @return long长整型
     */
    public long findMaxButtons(int[] buttons) {
        long count = 0L;
        for (int i = 0; i < buttons.length; i++) {
            count += (buttons[i] - 1) * i + buttons[i];
        }
        // write code here
        return count;
    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String test = sc.nextLine();
//        String[] chars = test.split(",");
//        int len = chars.length;
//        int[] buttons = new int[len];
//        if (chars.length == 1)
//            System.out.print(1);
//        else {
//            for (int i = 0; i < len; i++) {
//                if (i == 0)
//                    chars[0] = chars[0].split("")[1];
//                if (i == len - 1)
//                    chars[len - 1] = chars[len - 1].split("")[0];
//                buttons[i] = Integer.parseInt(chars[i]);
//            }
//        }
////        System.out.println(buttons);
//        NowCoderTest coderTest = new NowCoderTest();
//        System.out.print(coderTest.findMaxButtons(buttons));
//    }

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String temp1 = sc.nextLine();
//        String test = sc.nextLine();
//        String[] chars = test.split("");
//
//        int countRecord = 0;
//        int countAll = 0;
//        for (String item : chars) {
//            if (item.equals("1"))
//                countAll++;
//        }
//        countAll = Math.min(countAll, n - countAll);
//
//        int i = 0, j = n - 1;
//        while (i < j) {
//            while (chars[i].equals("1"))
//                i++;
//
//            while (chars[j].equals("0"))
//                j--;
//
//            if (i < j) {
//                countRecord += 2;
//                i++;
//                j--;
//            }
//        }
//        countRecord = Math.min(countRecord - 1, countAll);
//        System.out.print(countRecord);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String temp1 = sc.nextLine();
        String ming = sc.nextLine();
        String wang = sc.nextLine();
        String li = sc.nextLine();

        int count1 = getMaxCount(ming);
        int count2 = getMaxCount(wang);
        int count3 = getMaxCount(li);

        int len = ming.length();
        int max = Math.max(count1, Math.max(count2, count3));
        int diff = len - n;
        String res = "";
        if (count1 == max) {
            res = "xiaoming";
        } else if (count1 + diff >= len) {
            System.out.print("draw");
            return;
        }

        if (count2 == max && "".equals(res)) {
            res = "xiaowang";
        } else if (count2 == max || count2 + diff >= len) {
            System.out.print("draw");
            return;
        }

        if (count3 == max && "".equals(res)) {
            res = "xiaohong";
        } else if (count3 == max || count3 + diff >= len) {
            System.out.print("draw");
            return;
        }

        System.out.print(res);
    }

    private static int getMaxCount(String str) {
        int temp;
        int count = 0;
        int[] record = new int[26];
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            temp = str.charAt(i) - 'a';
            record[temp]++;
            count = Math.max(count, record[temp]);
        }
        return count;
    }
}
