/**
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。

 示例 1:

 输入: S = "loveleetcode", C = 'e'
 输出: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/shortest-distance-to-a-character
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShortestToChar {
    public int[] shortestToChar(String S, char C) {
        char[] charArray = S.toCharArray();
        int[] resultArray = new int[S.length()];

        int a = 10000;
        int charEnd = 0;
        int charStart = 0;

        for (int i =0; i<charArray.length; i++) {
            resultArray[i] = a;
            a++;
            if (charArray[i] == C) {
                a = 1;
                charStart = charEnd;
                charEnd = i;

                for (int j = charEnd; j>= charStart; j --) {
                    if (resultArray[j] > i-j) {
                        resultArray[j] = i-j;
                    }else {
                        break;
                    }
                }
            }
        }

        return resultArray;
    }
}
