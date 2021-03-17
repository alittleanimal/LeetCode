package HKU2021.March;

public class DesignHashMap706 {

    private final int DEFAULT_CAPACITY = 4;
    private Node[] table;
    private int size;

    /**
     * Initialize your data structure here.
     */
    public DesignHashMap706() {
        table = new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int i = indexOf(key);
        Node node = table[i];
        if (node == null) {
            table[i] = new Node(i, key, value, null);
            return;
        }
        while (true) {
            if (node.key == key) {
                node.value = value;
                return;
            }

            if (node.next != null)
                node = node.next;
            else
                break;
        }
        node.next = new Node(i, key, value, null);

        if (++size >= table.length * 0.75) {
            scaledUp();
        }
    }

    private void scaledUp() {
        int oldCap = table.length;
        Node[] newTable = new Node[oldCap * 2];
        for (int j = 0; j < oldCap; j++) {
            if (table[j] != null) {
                Node node = table[j];
                Node newNode = null;
                while (node != null) {
                    if ((node.key & oldCap) != 0) {
                        simpleAdd(node.key, node.value, j + oldCap, newTable);
                    } else {
                        if (newNode == null) {
                            newNode = new Node(j, node.key, node.value, null);
                        } else {
                            newNode.next = new Node(j, node.key, node.value, null);
                            newNode = newNode.next;
                        }
                    }
                    node = node.next;
                }
                table[j] = newNode;
            }
        }
        table = newTable;
    }

    private void simpleAdd(int key, int value, int i, Node[] newTable) {
        Node node = newTable[i];
        if (node == null) {
            newTable[i] = new Node(i, key, value, null);
            return;
        }
        while (true) {
            if (node.key == key) {
                node.value = value;
                return;
            }

            if (node.next != null)
                node = node.next;
            else
                break;
        }
        node.next = new Node(i, key, value, null);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int i = indexOf(key);
        Node node = table[i];
        while (node != null) {
            if (node.key == key)
                return node.value;
            node = node.next;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int i = indexOf(key);
        Node node = table[i];
        if (node.key == key) {
            table[i] = node.next;
        } else {
            Node next = node.next;
            while (next != null) {
                if (next.key == key) {
                    node.next = next.next;
                    return;
                } else {
                    node = next;
                    next = next.next;
                }
            }
        }
    }

    private int indexOf(int key) {
        return key & (table.length - 1);
    }

    static class Node {
        int hash;
        int key;
        int value;
        Node next;

        public Node(int hash, int key, int value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        DesignHashMap706 myHashMap = new DesignHashMap706();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
        myHashMap.put(2, 2);
        myHashMap.put(13, 2);
        myHashMap.put(12, 2);
        myHashMap.put(15, 2);
        myHashMap.put(6, 2);
        myHashMap.put(7, 2);
    }
}
