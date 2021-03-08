package HKU2021.March;

import org.junit.Test;

import java.util.*;

public class Match0307 {
    public boolean checkOnesSegment(String s) {
        boolean findOne = true;

        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (findOne && charArray[i] == '0') {
                findOne = false;
            }
            if (!findOne && charArray[i] == '1')
                return false;
        }
        return true;
    }

    public int minElements(int[] nums, int limit, int goal) {
        int sum;
        if (limit >= 1000000) {
            double res = Arrays.stream(nums).map(n -> n / limit).sum();
            goal = goal / limit;
            if (res % 1 == 0 && goal % limit != 0)
                return (int) Math.abs(goal - res);
            else
                return (int) (Math.abs(goal - res) + 1);
        }
        sum = Arrays.stream(nums).sum();

        int diff = Math.abs(sum - goal);

        int count = diff / limit;
        if (diff % limit != 0)
            count++;

        return count;
    }

    /**
     * 5698. Minimum Elements to Add to Form a Given Sum
     *
     * @param nums
     * @param limit
     * @param goal
     * @return
     */
    public int minElementsBetter(int[] nums, int limit, int goal) {
        long sum = 0L;
        for (int item : nums)
            sum += item;

        if (sum == goal)
            return 0;

        long diff = Math.abs(sum - goal) / limit;
        if (Math.abs(sum - goal) % limit != 0)
            diff++;
        return (int) diff;
    }

    /**
     * 5699. Number of Restricted Paths From First to Last Node
     *
     * @param n
     * @param edges
     * @return
     */
    public int countRestrictedPaths(int n, int[][] edges) {
        int cnt;
        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int[] t : edges) {
            int x = t[0];
            int y = t[1];
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            map.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{y, t[2]});
            map.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{x, t[2]});
        }

        int[] dis;
        Long[] mem = new Long[n + 1];
        dis = findShortPath(map, n, n);
        cnt = (int) findLimitedPathCount(map, 1, n, dis, mem);
        return cnt;
    }

    private final int MOD = 1000000007;
    private long findLimitedPathCount(Map<Integer, List<int[]>> map, int i, int n, int[] dis, Long[] mem) {
        if (mem[i] != null) {
            return mem[i];
        }

        if (i == n) return 1;
        long cnt = 0;
        List<int[]> list = map.getOrDefault(i, Collections.emptyList());
        for (int[] arr: list) {
            int next = arr[0];
            if (dis[next] < dis[i]) {
                cnt += findLimitedPathCount(map, next, n, dis, mem);
                cnt %= MOD;
            }
        }
        mem[i] = cnt;
        return cnt;
    }

    private int[] findShortPath(Map<Integer, List<int[]>> map, int n, int k) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, 0x3f3f3f3f);
        boolean[] vis = new boolean[n + 1];

        dis[k] = 0;
        dis[0] = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> dis[o]));
        queue.offer(k);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (vis[poll])
                continue;
            vis[poll] = true;
            List<int[]> list = map.getOrDefault(poll, Collections.emptyList());

            for (int[] arr : list) {
                int next = arr[0];
                if (vis[next])
                    continue;
                dis[next] = Math.min(dis[next], dis[poll] + arr[1]);
                queue.offer(next);
            }
        }

        return dis;
    }


    @Test
    public void test0307() {
//        System.out.println(checkOnesSegment("10000011"));
        System.out.println(minElementsBetter(new int[]{1, -1, 1}, 3, -4)); // 1

//        double test = 1000000000 * 101000;
//        System.out.println(test);
    }
}
