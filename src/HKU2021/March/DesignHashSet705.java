package HKU2021.March;

import java.util.Iterator;
import java.util.LinkedList;

public class DesignHashSet705 {

    private final int DEFAULT_CAPACITY = 16;
    private LinkedList[] table;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public DesignHashSet705() {
        table = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(int key) {
        if (!contains(key)) {
            int i = indexOf(key);
            if (table[i] == null) {
                table[i] = new LinkedList();
            }
            table[i].add(key);
            if (++size == table.length * 0.75) {
                scaledUp();
            }
        }
    }

    private void scaledUp() {
        int oldCap = table.length;
        LinkedList[] newTable = new LinkedList[oldCap * 2];
        for (int j = 0; j < oldCap; j++) {
            if (table[j] != null) {
                Iterator it = table[j].iterator();
                while (it.hasNext()) {
                    int temp = (int) it.next();
                    if ((temp & oldCap) == 1) {
                        if (newTable[j + oldCap] == null) {
                            newTable[j + oldCap] = new LinkedList();
                        }
                        newTable[j + oldCap].add(temp);
                        it.remove();
                    }
                }
            }
        }
        table = newTable;
    }

    public void remove(int key) {
        int i = indexOf(key);
        if (table[i] == null)
            return;

        Iterator iterator = table[i].iterator();
        while (iterator.hasNext()) {
            if ((int) iterator.next() == key) {
                iterator.remove();
                size--;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int i = indexOf(key);
        if (table[i] != null) {
            for (Integer element : (Iterable<Integer>) table[i]) {
                if (key == element)
                    return true;
            }
        }
        return false;
    }

    private int indexOf(int key) {
        return key & (table.length - 1);
    }

    public static void main(String[] args) {
        DesignHashSet705 myHashSet = new DesignHashSet705();
        myHashSet.add(9);      // set = [1]
        myHashSet.remove(19);      // set = [1, 2]
        System.out.println(myHashSet.contains(9)); // 返回 True
        System.out.println(myHashSet.contains(3)); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // 返回 False ，（已移除）
    }
}

class MyHashSet {
    private static final int BASE = 769;
    private LinkedList[] data;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                return;
            }
        }
        data[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                data[h].remove(element);
                return;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int h = hash(key);
        for (Integer element : (Iterable<Integer>) data[h]) {
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }
}
