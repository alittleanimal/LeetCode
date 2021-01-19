package HKU2021;

import org.junit.Test;

import java.util.*;

/**
 * 721. Accounts Merge
 */
public class AccountsMerge721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFindSet unionFindSet = new UnionFindSet(accounts.size());

        Map<String, Integer> foundMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                if (foundMap.get(accounts.get(i).get(j)) != null) {
                    unionFindSet.union(i, foundMap.get(accounts.get(i).get(j)));
                } else {
                    foundMap.put(accounts.get(i).get(j), i);
                }
            }
        }

        Map<Integer, Set<String>> recordMap = new HashMap<>();
        int findI;
        for (int k = 0; k < accounts.size(); k++) {
            findI = unionFindSet.find(k);

            List<String> tempAccount = new ArrayList<>(accounts.get(k));
            tempAccount.remove(0);
            Set<String> tempMapAccount = recordMap.getOrDefault(findI, new HashSet<>());
            tempMapAccount.addAll(tempAccount);
            recordMap.put(findI, tempMapAccount);
        }

        List<List<String>> returnList = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : recordMap.entrySet()) {
            List<String> tempList = new ArrayList<>();
            tempList.add(accounts.get(entry.getKey()).get(0));
            tempList.addAll(entry.getValue());
            Collections.sort(tempList);
            returnList.add(tempList);
        }

        return returnList;
    }

    private class UnionFindSet {
        private int[] parents;

        public UnionFindSet(int n) {
            parents = new int[n];

            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        public boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            parents[pv] = pu;
            return true;

        }

        public int find(int u) {
            return parents[u] == u ? u : (parents[u] = find(parents[u]));
        }
    }

    @Test
    public void test721() {
        List<List<String>> accounts = new ArrayList<>();
        List<String> tempList1 = new ArrayList<>(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john00@mail.com"}));
        List<String> tempList2 = new ArrayList<>(Arrays.asList(new String[]{"John", "johnnybravo@mail.com"}));
        List<String> tempList3 = new ArrayList<>(Arrays.asList(new String[]{"John", "johnsmith@mail.com", "john_newyork@mail.com"}));
        List<String> tempList4 = new ArrayList<>(Arrays.asList(new String[]{"Mary", "mary@mail.com"}));

        accounts.add(tempList1);
        accounts.add(tempList2);
        accounts.add(tempList3);
        accounts.add(tempList4);

        accountsMerge(accounts);
    }
}


