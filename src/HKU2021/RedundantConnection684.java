package HKU2021;

import org.junit.Test;

import java.util.*;

/**
 * 684. Redundant Connection
 */
public class RedundantConnection684 {
    /**
     * 并查集的初始化就是每个点只属于自己标记的集合，即p[x]=x。
     * 遍历边，如果两个点集合不同，那就合并进同一个集合，这里用了递归修改集合。
     * 如果遍历边的过程中，发现两个点已经加进过之前的集合了，那就说明成环了，这时就可以输出了。
     * 这就是传统并查集的做法。
     * @param edges
     * @return
     */
    public int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[edges.length + 1];
        int[] res = new int[2];
        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        int a, b;
        for (int j = 0; j < edges.length; j++) {
            a = edges[j][0];
            b = edges[j][1];
            if (find(a, parent) != find(b, parent)) {
                parent[find(a, parent)] = find(b, parent);
            } else {
                res = edges[j];
            }
        }
        return res;
    }

    private int find(int x, int[] parent) {
        return parent[x] == x ? x : find(parent[x], parent);
    }

    /**
     * 2，拓扑排序
     * 利用数组degreeArray记录各顶点的度。
     * 利用Map neighborMap记录各顶点的邻接顶点。
     * 从度为1的节点出发进行拓扑排序，剩余边中在edges中排最后的那条即为答案。
     * 拓扑排序步骤：
     * 1.寻找出最开始的结点（因为是有向图，可以按箭头方向。无向图可任意）。
     * 2.记住，记录一个点后，与这个点有关的所有边全部删除。如：记录点A后，那么A->B、A->C、A->D之间的边全部删除。
     * 3.再一次寻找新的开始结点。。。重复以上步骤。。。。。。。。。。。。
     * 直接看代码
     * @param edges
     * @return
     */
    public int[] findRedundantConnectionTopu(int[][] edges) {
        Map<Integer, List<Integer>> neighborMap = new HashMap<>();
        int[] degreeArray = new int[edges.length + 1];

        for (int i = 0; i < edges.length; i++) {
            List<Integer> tempList0 = neighborMap.getOrDefault(edges[i][0], new ArrayList<>());
            tempList0.add(edges[i][1]);
            neighborMap.put(edges[i][0], tempList0);

            List<Integer> tempList1 = neighborMap.getOrDefault(edges[i][1], new ArrayList<>());
            tempList1.add(edges[i][0]);
            neighborMap.put(edges[i][1], tempList1);

            degreeArray[edges[i][0]]++;
            degreeArray[edges[i][1]]++;
        }

        List<Integer> degOnes = new LinkedList<>();
        for (int j = 1; j < edges.length + 1; j++) {
            if (degreeArray[j] == 1)
                degOnes.add(j);
        }

        while (!degOnes.isEmpty()) {
            List<Integer> ndegOnes = new LinkedList<>();
            Set<Integer> deleteSet = new HashSet<>();
            for (Integer item : degOnes) {
                for (Integer neighborItem : neighborMap.get(item)) {
                    degreeArray[neighborItem]--;
                    if (degreeArray[neighborItem] == 1)
                        ndegOnes.add(neighborItem);
                    deleteSet.add(neighborItem);
                }
                for (Integer deleteItem : deleteSet) {
                    // remove this item from other items which contain it
                    neighborMap.get(deleteItem).remove(item);
                }

                // clear delete set after loop
                deleteSet.clear();
                // remove item which degree == 1
                neighborMap.keySet().removeIf(key -> key == item);
            }
            // update degree ones array
            degOnes = ndegOnes;
        }

        for (int k = edges.length - 1; k >= 0; k--) {
            if (degreeArray[edges[k][0]] > 1 && degreeArray[edges[k][1]] > 1)
                return edges[k];
        }

        return new int[2];
    }

    @Test
    public void test684() {
        int[] list1 = {1, 2};
        int[] list2 = {1, 3};
        int[] list3 = {2, 3};
//        int[] list4 = {1,4};
//        int[] list5 = {1,5};

        int[][] list6 = {list1, list2, list3};
        int[] res = findRedundantConnectionTopu(list6);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
