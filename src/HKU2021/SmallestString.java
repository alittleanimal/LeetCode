package HKU2021;

import java.util.*;

/**
 * 1202. Smallest String With Swaps
 */
public class SmallestString {

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFindSet unionFindSet = new UnionFindSet(s.length());
        for (List<Integer> pairList: pairs) {
            unionFindSet.union(pairList.get(0), pairList.get(1));
        }

        HashMap<Integer, LinkedList<Character>> recordMap = new HashMap<>();
        for (int i = 0; i<s.length(); i++) {
            int root = unionFindSet.find(i);

            if (recordMap.containsKey(root)){
                recordMap.get(root).add(s.charAt(i));
            } else {
                LinkedList<Character> tempList = new LinkedList<>();
                tempList.add(s.charAt(i));
                recordMap.put(root, tempList);
            }
        }

        for (Map.Entry<Integer, LinkedList<Character>> map: recordMap.entrySet()) {
            Collections.sort(map.getValue());
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i =0; i<s.length(); i ++) {
            int root = unionFindSet.find(i);
            stringBuilder.append(recordMap.get(root).remove());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
//        String s1 = "bcad";
//        String s2 = "bacd";
//        String s3 = "abcd";
//
//        System.out.println(s1.compareTo(s2));
//        System.out.println(s1.compareTo(s3));
//        System.out.println(s2.compareTo(s3));
        SmallestString smallestString = new SmallestString();
        List<List<Integer>> pairList = new ArrayList<>();
        List<Integer> intList = new ArrayList<>();
        intList.add(0);
        intList.add(3);
        pairList.add(intList);
        intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        pairList.add(intList);
        System.out.println(smallestString.smallestStringWithSwaps("dcab", pairList));;
    }

    private class UnionFindSet {
        private int[] parents;
        private int[] ranks;

        public UnionFindSet(int n) {
            parents = new int[n];
            ranks = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
                ranks[i] = 1;
            }
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return false;
            if (ranks[pv] > ranks[pu])
                parents[pu] = pv;
            else if (ranks[pu] > ranks[pv])
                parents[pv] = pu;
            else {
                parents[pv] = pu;
                ranks[pu] += 1;
            }
            return true;

        }

        public int find(int u) {
            return parents[u] == u ? u : (parents[u] = find(parents[u]));
        }
    }
}

