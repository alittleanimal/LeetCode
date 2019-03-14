import java.util.ArrayList;
import java.util.List;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。

 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

 给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

 示例 1:

 输入: 2, [[1,0]]
 输出: true
 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

 示例 2:

 输入: 2, [[1,0],[0,1]]
 输出: false
 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 */
public class CanFinishClass {

    static boolean noCircle = true;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        noCircle = true;
        int start = 0;
        if (prerequisites.length == 1 || prerequisites.length == 0) {
            return true;
        }

        // get adjacent matrix through border array
        List<List<Integer>> startList = new ArrayList<>(prerequisites.length);
        for (int i = 0; i < numCourses; i++) {
            startList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            startList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // find start element which has followers
        for (int i=0; i<startList.size(); i++) {
            if (startList.get(i).size() != 0) {
                start = i;
                break;
            }
        }
        int[] result = new int[numCourses];
        dfs(startList, start, result);
        return noCircle;
    }

    private static void dfs(List<List<Integer>> startList, int start, int[] res) {

        res[start] = 1;
        for (Integer list : startList.get(start)) {

            if (res[list] == 1) {
                noCircle = false;
                break;
            } else if (res[list] == -1) {
                continue;
            } else {
                dfs(startList, list, res);
            }
        }
        res[start] = -1; // After search all the linked element, set this element -1
    }

    public static void main(String[] args) {
        int[][] test = {{0,1},{2,0},{3,1},{3,2}};
        int[][] test1 = {{1,0},{2,0}};
        int[][] test2 = {{1,0},{0,1}};
        int[][] test3 = {{1,0},{2,0},{0,2}};
        int[][] test4 = {{0,1},{3,1},{1,3},{3,2}};

        System.out.println(canFinish(4, test4));
    }
}
