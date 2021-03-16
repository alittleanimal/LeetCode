package Collection.MyHashMap;


public class MyHashMap<K,V> implements MyMap {

    private final int DEFAULT_CAPACITY = 16;
    private Node[] table = new Node[DEFAULT_CAPACITY];
    private int size = 0;

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

    private void addEntry(Object key, Object value, int hashValue, int i) {
        if (++size == table.length) {
            Node[] newTable = new Node[table.length*2];
//            System.arraycopy(table, 0, newTable, 0, table.length);
            transfer(table, newTable);
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

    public void transfer(Node[] src,Node[] newTable) {         //src引用了旧的Entry数组
        int newCapacity = newTable.length;
        for (int j = 0; j < src.length; j++) { //遍历旧的Entry数组
            Node e = src[j];             //取得旧Entry数组的每个元素
            if (e != null) {
                src[j] = null;//释放旧Entry数组的对象引用（for循环后，旧的Entry数组不再引用任何对象）
                do {
                    Node next = e.next;
                    int i = indexFor(e.hash, newCapacity); //！！重新计算每个元素在数组中的位置
                    e.next = newTable[i]; //标记[1]
                    newTable[i] = e;      //将元素放在数组上
                    e = next;             //访问下一个Entry链上的元素
                } while (e != null);
            }
        }
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

