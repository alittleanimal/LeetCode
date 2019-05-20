package collection.MyHashSet;

import java.util.HashMap;
import java.util.Iterator;

public class MyHashSet<E> implements MySet<E> {

    private HashMap<E, Object> map;

    private static final Object PRECENT = new Object();

    public MyHashSet() {
        this.map = new HashMap<>();
    }

    public MyHashSet(int initialCapacity) {
        this.map = new HashMap<>(initialCapacity);
    }

    public MyHashSet(int initialCapacity, float initialLoadFactor) {
        this.map = new HashMap<>(initialCapacity, initialLoadFactor);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRECENT) == null;
    }

    @Override
    public boolean remove(E e) {
        return map.remove(e) == PRECENT;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}
