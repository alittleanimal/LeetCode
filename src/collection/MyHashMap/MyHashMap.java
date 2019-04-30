package collection.MyHashMap;


import java.util.Set;

public class MyHashMap<K,V> implements MyMap {

    private final int DEFAULT_CAPACITY = 16;
    Node[] table = new Node[DEFAULT_CAPACITY];
    private int size = 0;
    Set<K> keySet;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object get(Object key) {
        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);
        for (Node node = table[i]; node != null; node = node.next) {
            if (node.key.equals(key) && hashValue == node.hash) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {

        int hashValue = hash(key);
        int i = indexFor(hashValue, table.length);
        for (Node node = table[i]; node!=null; node = node.next) {
            Object k;
            if (node.hash == hashValue && ((k=node.key) == key || key.equals(k))) {
                Object oldValue = node.value;
                node.value = value;
                return oldValue;
            }
        }
        addEntry(key, value, hashValue, i);
        return null;
    }

    public void addEntry(Object key, Object value, int hashValue, int i) {
        if (++size == table.length) {
            Node[] newTable = new Node[table.length*2];
            System.arraycopy(table, 0, newTable, 0, table.length);
            table = newTable;
        }
        Node eNode = table[i];
        table[i] = new Node(hashValue, key, value, eNode);
    }

    private int indexFor(int hashValue, int length) {
        return hashValue % length;
    }

    private int hash(Object key) {
        return key.hashCode();
    }

    static class Node implements MyMap.Entry {

        int hash;
        Object key;
        Object value;
        Node next;
        Node(int hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return this.key;
        }

        @Override
        public Object getValue() {
            return this.value;
        }
    }
}

