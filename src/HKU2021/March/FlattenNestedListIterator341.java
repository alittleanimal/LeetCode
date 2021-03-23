package HKU2021.March;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator341 {

    private List<Integer> list;
    private Iterator<Integer> cur;

    public FlattenNestedListIterator341(List<FlattenNestedListIterator341> nestedList) {
        list = new ArrayList<>();
        cur = list.iterator();
        dfs(nestedList);
    }

    private void dfs(List<FlattenNestedListIterator341> nestedList) {
        for (FlattenNestedListIterator341 item: nestedList) {
            if (item.isInteger()) {
                list.add(item.getInteger());
            } else {
                dfs(item.getList());
            }
        }
    }

    private List<FlattenNestedListIterator341> getList() {
        return null;
    }

    private Integer getInteger() {
        return null;
    }

    private boolean isInteger() {
        return false;
    }

    public Integer next() {
        return cur.next();
    }

    public boolean hasNext() {
        return cur.hasNext();
    }

}
