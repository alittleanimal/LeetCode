import java.util.ArrayList;
import java.util.List;

public class canFinishClass {

    static boolean hasCircle = false;

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 1 || prerequisites.length == 0) {
            return true;
        }
        List<List<Integer>> startList = new ArrayList<>(prerequisites.length);
        for (int i = 0; i < numCourses; i++) {
            startList.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            startList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        List<Integer> result = new ArrayList<>();
        return hasCircle;
    }

    private static void dfs(List<List<Integer>> startList, int start, List<Integer> res) {
        res.add(start);
        for (Integer list : startList.get(start)) {
            if (!res.contains(list)) {
                dfs(startList, list, res);

            } else {
                hasCircle = true;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = {{1,0},{2,0}};

        System.out.println(canFinish(3, test));
    }
}
