import java.util.*;

/**
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。

 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。

 最初，除 0 号房间外的其余所有房间都被锁住。

 你可以自由地在房间之间来回走动。

 如果能进入每个房间返回 true，否则返回 false。
 */
public class CanVisitAllRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Map<Integer, Boolean> visited = new HashMap<>();
        dfs(rooms, visited, 0);

        for (int i = 0; i < rooms.size(); i++) {
            if (!visited.containsKey(i)) {
                return false;
            }
        }
        return true;
    }

    private static void dfs (List<List<Integer>> graph, Map<Integer, Boolean> visited, int start) {
        if (!visited.containsKey(start)) {
            visited.put(start, true);
            for (int num: graph.get(start)) {
                if (!visited.containsKey(num)) {
                    dfs(graph, visited, num);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(2);
        List<Integer> temp2 = new ArrayList<>();
        List<Integer> temp3 = new ArrayList<>();
        temp3.add(1);
        List<List<Integer>> test = new ArrayList<>();
        test.add(temp1);
        test.add(temp2);
        test.add(temp3);


        System.out.println(canVisitAllRooms(test));
    }



    /**
     * Best answer
     * BFS
     */
    public boolean canVisitAllRooms_1(List<List<Integer>> rooms) {
        Set<Integer> res = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        res.add(0);
        queue.add(0);
        while (!queue.isEmpty()) {
            for (Integer room : rooms.get(queue.poll())) {
                if (!res.contains(room)) {
                    queue.add(room);
                    res.add(room);
                }
            }
        }
        return res.size() == rooms.size();
    }

    public boolean canVisitAllRooms_2(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        int res = 1;
        while (!queue.isEmpty()) {
            for (Integer room : rooms.get(queue.poll())) {
                if (!visited[room]) {
                    queue.add(room);
                    visited[room] = true;
                    res++;
                }
            }
        }
        return res == rooms.size();
    }


    /**
     * DFS
     */
    public boolean canVisitAllRoomsDFS(List<List<Integer>> rooms) {
        return dfs(rooms, 0, new HashSet<>()) == rooms.size();
    }

    private int dfs(List<List<Integer>> rooms, int room, Set<Integer> res) {
        res.add(room);
        rooms.get(room)
                .stream()
                .filter(r -> !res.contains(r))
                .forEach(r -> dfs(rooms, r, res));
        return res.size();
    }
}
