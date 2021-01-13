package HKU2021;

import org.junit.Test;

import java.util.*;

/**
 * 1203. Sort Items by Groups Respecting Dependencies
 */
public class SortItem1203 {

    /**
     * @param n           n itmes
     * @param m           m groups
     * @param group       group[i] is the group that the i-th item belongs to
     * @param beforeItems a list containing all the items that should come before
     * @return
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int[][] groupG = new int[m + 1][m + 1];
        // group relationship graph
        Map<Integer, ArrayList<Integer>> groupMap = new HashMap<>();
        // item relationship graph
        Map<Integer, ArrayList<Integer>> itemMap = new HashMap<>();

        int[] inDegreeItem = new int[n];
        int noneGroupId = m;
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = noneGroupId++;
            }
        }

        int[] inDegreeGroup = new int[noneGroupId];

        for (int i = 0; i < group.length; i++) {
            // before item of i
            List<Integer> beforeItemi = beforeItems.get(i);
            for (Integer j: beforeItemi) {
                // find beforeItem group id
                if (group[j] != group[i]) {
                    ArrayList<Integer> list = groupMap.getOrDefault(group[j], new ArrayList<>());
                    list.add(group[i]);
                    groupMap.put(group[j], list);
                    inDegreeGroup[group[i]]++;
                }

                // build item sequential order item
                ArrayList<Integer> itemList = itemMap.getOrDefault(j, new ArrayList<>());
                itemList.add(i);
                itemMap.put(j, itemList);
                inDegreeItem[i]++;
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < noneGroupId; i++) {
            set.add(i);
        }

        // get group order
        List<Integer> integers = topuSort(inDegreeGroup, groupMap, set);
        if (integers.size() == 0) {
            return new int[0];
        }

        List<Integer> res = new ArrayList<>();
        Map<Integer, Set<Integer>> groupIdToItems = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            Set<Integer> set1 = groupIdToItems.getOrDefault(group[i], new HashSet<>());
            set1.add(i);
            groupIdToItems.put(group[i], set1);
        }

        for (Integer groupId: integers) {
            Set<Integer> items = groupIdToItems.get(groupId);
            if (items != null) {
                List<Integer> li = topuSort(inDegreeItem, itemMap, items);
                if (li.size() == 0 && groupId != m) {
                    return new int[0];
                }
                res.addAll(li);
            }
        }

        int[] ans = new int[res.size()];
        int index = 0;
        for (Integer item: res) {
            ans[index++] = item;
        }
        return ans;
    }

    /**
     *
     * @param deg  item in degree
     * @param graph  graph
     * @param items  items need topu sort
     * @return
     */
    private List<Integer> topuSort(int[] deg, Map<Integer, ArrayList<Integer>> graph, Set<Integer> items) {
        int n = items.size();
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int item: items) {
            if (deg[item] == 0) {
                queue.offer(item);
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            ArrayList<Integer> integers = graph.get(u);
            if (items.contains(u) && integers != null && integers.size() != 0) {
                for (int v: graph.get(u)) {
                    deg[v]--;
                    if (deg[v] == 0) {
                        queue.offer(v);
                    }
                }
            }
            if (items.contains(u)) {
                items.remove(u);
                res.add(u);
            }
        }
        return res.size() == n ? res : new ArrayList<>();
    }

    @Test
    public void test() {
        List<List<Integer>> a = new ArrayList<>();
        a.add(new ArrayList<>());
		a.add(Arrays.asList(6));
		a.add(Arrays.asList(5));
		a.add(Arrays.asList(6));
		a.add(Arrays.asList(3,6));
		a.add(new ArrayList<>());
		a.add(new ArrayList<>());
		a.add(new ArrayList<>());
        System.out.println(Arrays.toString(sortItems(8,2, new int[]{-1, -1, 1, 0, 0, 1, 0, -1}, a)));

//        List<List<Integer>> a = new ArrayList<>();
//        a.add(new ArrayList<>());
//        a.add(Arrays.asList(0));
//        a.add(Arrays.asList(1));
//        System.out.println(Arrays.toString(sortItems(3, 1, new int[]{-1,0, -1}, a)));
    }

}
